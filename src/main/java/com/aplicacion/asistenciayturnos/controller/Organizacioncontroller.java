package com.aplicacion.asistenciayturnos.controller;

import com.aplicacion.asistenciayturnos.entity.Organizacion;
import com.aplicacion.asistenciayturnos.service.OrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indiciamos que es un controlador rest
@RestController
@ControllerAdvice
@RequestMapping(value = "/api/v1") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/v1
public class Organizacioncontroller {

    //Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private OrganizacionService organizacionService;

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/organizaciones/
    */

    //V1
    //@GetMapping("/organizaciones")
    //V2
    @RequestMapping(value = "/organizaciones", method = RequestMethod.GET)
    public List<Organizacion> findAll(){
        //retornará todos los usuarios
        return organizacionService.findAll();
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/api/v1/organizaciones/1*/

    //V1
    //@GetMapping("/organizaciones/{organizacionId}")
    //V2
    @RequestMapping(value = "organizaciones/{organizacionId}", method = RequestMethod.GET)
    public Organizacion getOrganizacion(@PathVariable Long organizacionId){
        Organizacion organizacion = organizacionService.findById(organizacionId);

        if(organizacion == null) {
            throw new RuntimeException("Identificador de organizacion no encontrado -"+organizacionId);
        }
        //retornará al usuario con id pasado en la url
        return organizacion;
    }

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/organizaciones/
    */

    //V1
    //@PostMapping("/organizaciones")
    //V2
    @RequestMapping(value = "/organizaciones", method = RequestMethod.POST)
    public Organizacion addOrganizacion(@RequestBody Organizacion organizacion) {
        organizacion.setIdorganizacion(0L);

        //Este método guardará al usuario enviado
        organizacionService.save(organizacion);

        return organizacion;

    }
    /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/organizaciones
    */

    //V1
    //@PutMapping("/organizaciones")
    //V2
    @RequestMapping(value = "/organizaciones", method = RequestMethod.PUT)
    public Organizacion updateOrganizacion(@RequestBody Organizacion organizacion) {

        //este método actualizará al usuario enviado
        organizacionService.modify(organizacion);

        return organizacion;
    }

    /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
    http://127.0.0.1:8080/api/v1/organizaciones/1
    */

    //V1
    //@DeleteMapping("/organizaciones/{organizacionId}")
    //V2
    @RequestMapping(value = "organizaciones/{organizacionId}", method = RequestMethod.DELETE)
    public String deleteOrganizacion(@PathVariable Long organizacionId) {

        Organizacion organizacion = organizacionService.findById(organizacionId);

        if(organizacion == null) {
            throw new RuntimeException("Identificador de organizacion no encontrado -"+organizacionId);
        }

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        organizacionService.deleteById(organizacionId);

        return "Identificador de organizacion borrado - "+organizacionId;
    }

}