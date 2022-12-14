package com.aplicacion.asistenciayturnos.controller;

import com.aplicacion.asistenciayturnos.converter.Converters;
import com.aplicacion.asistenciayturnos.dto.OrganizacionDto;
import com.aplicacion.asistenciayturnos.entity.Organizacion;
import com.aplicacion.asistenciayturnos.service.OrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Indicamos que es un controlador rest
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
    public List<OrganizacionDto> findAll(){

        List<Organizacion> listaOrganizaciones = organizacionService.findAll();
        List<OrganizacionDto> listaOrganizacionesDto = new ArrayList<>();

        for (Organizacion organizacion:listaOrganizaciones){

            OrganizacionDto organizacionDto = Converters.mapToOrganizacionDto(organizacion);
            listaOrganizacionesDto.add(organizacionDto);

        }

        //retornará todos las organizaciones
        return listaOrganizacionesDto;
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/api/v1/organizaciones/1*/

    //V1
    //@GetMapping("/organizaciones/{organizacionId}")
    //V2
    @RequestMapping(value = "/organizaciones/id/{organizacionId}", method = RequestMethod.GET)
    public OrganizacionDto getOrganizacion(@PathVariable Long organizacionId){

        Organizacion organizacion = organizacionService.findById(organizacionId);

        if(organizacion==null) {
            throw new RuntimeException("Identificador de organizacion no encontrado -"+organizacionId);
        }

        OrganizacionDto organizacionDto = Converters.mapToOrganizacionDto(organizacion);

            //retornará al usuario con id pasado en la url
        return organizacionDto;
    }

    @RequestMapping(value = "/organizaciones/cuit/{organizacionCuit}", method = RequestMethod.GET)
    public OrganizacionDto getOrganizacionCuit(@PathVariable(required = false) Long organizacionCuit, @PathVariable(required = false) String organizacionNombre){
        Organizacion organizacion = organizacionService.findByCuitOrNombre(organizacionCuit, organizacionNombre);

        //Esto que sigue es un dto bien aplicado???
        OrganizacionDto organizacionDto = Converters.mapToOrganizacionDto(organizacion);

        if(organizacion == null) {
            throw new RuntimeException("Cuit de organizacion no encontrado -"+organizacionCuit);
        }
        //retornará la organizacion con cuit en la url
        return organizacionDto;
    }

    //Lo hice separado en el controller a la búsqueda por cuit o nombre, pero con el mismo servicio, porque
    //me daba un error de página no encontrada cuando intentaba hacerlo en forma conjunta a las opciones de búsqueda

    @RequestMapping(value = "/organizaciones/nombre/{organizacionNombre}", method = RequestMethod.GET)
    public OrganizacionDto getOrganizacionNombre(@PathVariable(required = false) Long organizacionCuit, @PathVariable(required = false) String organizacionNombre){
        Organizacion organizacion = organizacionService.findByCuitOrNombre(organizacionCuit, organizacionNombre);

        if(organizacion == null) {
            throw new RuntimeException("Nombre de organizacion no encontrado -"+organizacionNombre);
        }

        //Esto que sigue es un dto bien aplicado???
        OrganizacionDto organizacionDto = Converters.mapToOrganizacionDto(organizacion);

        //retornará la organizacion con nombre pasado en la url
        return organizacionDto;
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
        organizacionService.create(organizacion);

        //Esto que sigue es un dto bien aplicado???
        //OrganizacionDto organizacionDto = Converters.mapToOrganizacionDto(organizacion);

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
        organizacionService.update(organizacion);

        return organizacion;
    }

    /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
    http://127.0.0.1:8080/api/v1/organizaciones/1
    */

    //V1
    //@DeleteMapping("/organizaciones/{organizacionId}")
    //V2

    @RequestMapping(value = "/organizaciones/{organizacionId}", method = RequestMethod.DELETE)
    public String deleteOrganizacion(@PathVariable Long organizacionId) {

        Organizacion organizacion = organizacionService.findById(organizacionId);

        if(organizacion == null) {
            throw new RuntimeException("Identificador de organizacion no encontrado -"+organizacionId);
        }

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        organizacionService.delete(organizacionId);

        return "Identificador de organizacion borrado - "+organizacionId;
    }
}