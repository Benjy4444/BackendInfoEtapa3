package com.aplicacion.asistenciayturnos.controller;

import com.aplicacion.asistenciayturnos.converter.Converters;
import com.aplicacion.asistenciayturnos.dto.OrganizacionDto;
import com.aplicacion.asistenciayturnos.dto.TurnoDto;
import com.aplicacion.asistenciayturnos.entity.Turno;

import com.aplicacion.asistenciayturnos.entity.Usuario;
import com.aplicacion.asistenciayturnos.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.ArrayList;
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
    public List<TurnoDto> findAll() {

        List<Turno> listaTurnos = turnoService.findAll();
        List<TurnoDto> listaTurnosDto = new ArrayList<>();

        for (Turno turno : listaTurnos) {

            TurnoDto turnoDto = Converters.mapToTurnoDto(turno);
            listaTurnosDto.add(turnoDto);

        }

        //retornará todos los usuarios
        return listaTurnosDto;
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/api/v1/turnos/1
    */

    /*Esto no se pide en la consigna
    @RequestMapping(value = "turnos/id/{turnoId}", method = RequestMethod.GET)
    public TurnoDto getTurno(@PathVariable Long turnoId) {
        Turno turno = turnoService.findById(turnoId);

        if (turno == null) {
            throw new RuntimeException("Identificador de turno no encontrado -" + turnoId);
        }

        TurnoDto turnoDto = Converters.mapToTurnoDto(turno);
        //retornará el turno con id pasado en la url
        return turnoDto;
    }
    */

    @RequestMapping(value = "/turnos/organizacion/{cuitOrganizacion}/evento/{nombreEvento}", method = RequestMethod.GET)
    public List<TurnoDto> getTurnosPorOrganizacionYEvento(@PathVariable String nombreEvento, @PathVariable Long cuitOrganizacion) {
        List<Turno> listaTurnos = turnoService.findByEventoNombreAndEventoOrganizacionCuit(nombreEvento, cuitOrganizacion);

        if (listaTurnos == null) {
            throw new RuntimeException("Turnos por organización y evento no encontrados.");
        }

        List<TurnoDto> listaTurnosDto = new ArrayList<>();

        for (Turno turno : listaTurnos) {

            TurnoDto turnoDto = Converters.mapToTurnoDto(turno);
            listaTurnosDto.add(turnoDto);

        }

        //retornará al usuario con cuit o nombre pasado en la url
        return listaTurnosDto;
    }

    //Conviene configurar la búsqueda por "nombre" del evento y no por "id"
    @RequestMapping(value = "/turnos/evento/{nombreEvento}", method = RequestMethod.GET)
    public List<TurnoDto> getTurnosPorEvento(@PathVariable String nombreEvento) {
        List<Turno> listaTurnos = turnoService.findByEventoNombre(nombreEvento);

        if(listaTurnos == null) {

            throw new RuntimeException("Turnos para evento no encontrados - "+ nombreEvento);

        }

        List<TurnoDto> listaTurnosDto = new ArrayList<>();

        for (Turno turno : listaTurnos) {

            TurnoDto turnoDto = Converters.mapToTurnoDto(turno);
            listaTurnosDto.add(turnoDto);

        }

        //retornará los turnos del evento pasado en la url
        return listaTurnosDto;
    }


    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/turnos
    */

    //V1
    //@PostMapping("/turnos")
    //V2
    @RequestMapping(value = "/turnos", method = RequestMethod.POST)
    public TurnoDto addTurno(@RequestBody Turno turno) {

        turno.setIdturno(0L);
        turno.setActivo(true);
        Usuario usuario = turno.getUsuario();
        //Lo que sigue debería generar un código único por cada turno...
        turno.setCodigo(usuario.getDni()+usuario.getApellido()+usuario.getIdusuario()+ turno.getIdevento());

        //Este método guardará el turno enviado
        turnoService.create(turno);

        TurnoDto turnoDto = Converters.mapToTurnoDto(turno);

        return turnoDto;

    }
    /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/turnos
    */

    @RequestMapping(value = "/turnos/codigo/{turnoCodigo}/clave/{claveIngresada}", method = RequestMethod.PUT)
    public TurnoDto updateTurno(@PathVariable String turnoCodigo, @PathVariable String claveIngresada, @RequestBody TurnoDto turnoDto) {

        Turno turno = turnoService.findByCodigo(turnoCodigo);

        if (turno == null) {
            throw new RuntimeException("Código de turno no encontrado -" + turnoCodigo);
        }

        Turno turnoModificado = new Turno();

        if (claveIngresada.equals(turnoModificado.getUsuario().getClave())) {

            turnoModificado.setIdturno(turno.getIdturno());
            turnoModificado.setActivo(true);
            turnoModificado.setCodigo(turno.getCodigo());

            if(turno.getEvento().getTipo()){

            }else{
                turnoModificado.setFecha(turno.getEvento().getFecha());
                turnoModificado.setHora(turno.getEvento().getHora());
            }

            //este método actualizará el turno enviado
            turnoService.update(turnoModificado);

            TurnoDto turnoModificadoDto = Converters.mapToTurnoDto(turnoModificado);
            return turnoModificadoDto;

        }else{

            //Aquí va mensaje de error si no se ingresó la clave correctamente
            throw new RuntimeException("Clave incorrecta - No se realizó la modificación.");
            //return null;

        }

    }

    /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
    http://127.0.0.1:8080/api/v1/turnos/1
    */

    @RequestMapping(value = "turnos/codigo/{turnoCodigo}/clave/{claveIngresada}", method = RequestMethod.DELETE)
    public String deleteTurno(@PathVariable String turnoCodigo, @PathVariable String claveIngresada) {

        Turno turno = turnoService.findByCodigo(turnoCodigo);

        if (turno == null) {
            throw new RuntimeException("Código de turno no encontrado -" + turnoCodigo);
        }

        if (claveIngresada.equals(turno.getUsuario().getClave())) {

            //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
            //turnoService.delete(turno.getIdturno());

            turno.setActivo(false);
            turnoService.update(turno);

            return "Código de turno borrado - " + turnoCodigo;

        } else {

            //Aquí va mensaje de error si no se ingresó la clave correctamente
            throw new RuntimeException("Clave incorrecta - No se realizó el borrado.");
            //return null;

        }

    }
}