package com.aplicacion.asistenciayturnos.controller;

import com.aplicacion.asistenciayturnos.converter.Converters;
import com.aplicacion.asistenciayturnos.dto.EventoDto;
import com.aplicacion.asistenciayturnos.dto.OrganizacionDto;
import com.aplicacion.asistenciayturnos.entity.Evento;
import com.aplicacion.asistenciayturnos.entity.Organizacion;
import com.aplicacion.asistenciayturnos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Indiciamos que es un controlador rest
@RestController
@ControllerAdvice
@RequestMapping(value = "/api/v1") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/v1
public class Eventocontroller {

    //Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private EventoService eventoService;

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/eventos
    */

    //V1
    //@GetMapping("/eventos")
    //V2
    @RequestMapping(value = "/eventos", method = RequestMethod.GET)
    public List<EventoDto> findAll(){
        List<Evento> listaEventos = eventoService.findAll();
        List<EventoDto> listaEventosDto = new ArrayList<>();

        for (Evento evento:listaEventos){

            EventoDto eventoDto = Converters.mapToEventoDto(evento);
            listaEventosDto.add(eventoDto);

        }

        //retornará todos los usuarios
        return listaEventosDto;
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/api/v1/eventos/1
    */

    //V1
    //@GetMapping("/eventos/{eventoId}")
    //V2
    @RequestMapping(value = "eventos/{eventoId}", method = RequestMethod.GET)
    public EventoDto getEvento(@PathVariable Long eventoId){
        Evento evento = eventoService.findById(eventoId);

        if(evento == null) {
            throw new RuntimeException("Identificador de evento no encontrado -"+eventoId);
        }

        EventoDto eventoDto = Converters.mapToEventoDto(evento);
        //retornará el evento con id pasado en la url
        return eventoDto;
    }

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/eventos
    */

    //V1
    //@PostMapping("/eventos")
    //V2
    @RequestMapping(value = "/eventos", method = RequestMethod.POST)
    public Evento addEvento(@RequestBody Evento evento) {

        evento.setIdevento(0L);

        //Este método guardará al usuario enviado
        eventoService.create(evento);

        return evento;

    }
    /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/eventos
    */

    //V1
    //@PutMapping("/eventos")
    //V2
    @RequestMapping(value = "/eventos", method = RequestMethod.PUT)
    public Evento updateEvento(@RequestBody Evento evento) {

        //este método actualizará al usuario enviado
        eventoService.update(evento);

        return evento;
    }

    /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
    http://127.0.0.1:8080/api/v1/eventos/1
    */

    //V1
    //@DeleteMapping("/eventos/{eventoId}")
    //V2
    @RequestMapping(value = "eventos/{eventoId}", method = RequestMethod.DELETE)
    public String deleteEvento(@PathVariable Long eventoId) {

        Evento evento = eventoService.findById(eventoId);

        if(evento == null) {
            throw new RuntimeException("Identificador de evento no encontrado -"+eventoId);
        }

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        eventoService.delete(eventoId);

        return "Identificador de evento borrado - "+eventoId;
    }

}