package com.aplicacion.asistenciayturnos.controller;

import com.aplicacion.asistenciayturnos.entity.Organizacion;
import com.aplicacion.asistenciayturnos.entity.Turno;

import com.aplicacion.asistenciayturnos.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indiciamos que es un controlador rest
@RestController
@ControllerAdvice
@RequestMapping(value = "/api/v1") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/v1
public class Turnocontroller {

    //Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private TurnoService turnoService;

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/turnos
    */

    //V1
    //@GetMapping("/turnos")
    //V2
    @RequestMapping(value = "/turnos", method = RequestMethod.GET)
    public List<Turno> findAll(){
        //retornará todos los usuarios
        return turnoService.findAll();
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/api/v1/turnos/1
    */

    //V1
    //@GetMapping("/turnos/{turnoId}")
    //V2
    @RequestMapping(value = "turnos/{turnoId}", method = RequestMethod.GET)
    public Turno getTurno(@PathVariable Long turnoId){
        Turno turno = turnoService.findById(turnoId);

        if(turno == null) {
            throw new RuntimeException("Identificador de turno no encontrado -"+turnoId);
        }
        //retornará el turno con id pasado en la url
        return turno;
    }

    /*
    @RequestMapping(value = "/turnos/buscarorganizacionyevento/{idOrganizacion}/{idEvento}", method = RequestMethod.GET)
    public Turno getTurnosPorOrganizacionYEvento(@PathVariable(required = false) Long idOrganizacion, @PathVariable(required = false) Long idEvento){
        List<Turno> turnos = turnoService.findByIdorganizacionAndIdevento(idOrganizacion, idEvento);

        if(turnos == null) {
            throw new RuntimeException("Turnos por organización y evento no encontrados.");
        }
        //retornará al usuario con cuit o nombre pasado en la url
        return (Turno) turnos;
    }
    */

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/turnos
    */

    //V1
    //@PostMapping("/turnos")
    //V2
    @RequestMapping(value = "/turnos", method = RequestMethod.POST)
    public Turno addTurno(@RequestBody Turno turno) {

        turno.setIdturno(0L);

        //Este método guardará el turno enviado
        turnoService.create(turno);

        return turno;

    }
    /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/turnos
    */

    //V1
    //@PutMapping("/turnos")
    //V2
    @RequestMapping(value = "/turnos", method = RequestMethod.PUT)
    public Turno updateTurno(@RequestBody Turno turno) {

        //este método actualizará el turno enviado
        turnoService.update(turno);

        return turno;
    }

    /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
    http://127.0.0.1:8080/api/v1/turnos/1
    */

    //V1
    //@DeleteMapping("/turnos/{turnoId}")
    //V2
    @RequestMapping(value = "turnos/{turnoId}", method = RequestMethod.DELETE)
    public String deleteTurno(@PathVariable Long turnoId) {

        Turno turno = turnoService.findById(turnoId);

        if(turno == null) {
            throw new RuntimeException("Identificador de turno no encontrado -"+turnoId);
        }

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        turnoService.delete(turnoId);

        return "Identificador de turno borrado - "+turnoId;
    }

}