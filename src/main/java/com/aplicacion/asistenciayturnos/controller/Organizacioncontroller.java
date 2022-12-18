package com.aplicacion.asistenciayturnos.controller;

import com.aplicacion.asistenciayturnos.converter.Converters;
import javax.swing.JOptionPane;
import com.aplicacion.asistenciayturnos.dto.OrganizacionDto;
import com.aplicacion.asistenciayturnos.entity.Organizacion;
import com.aplicacion.asistenciayturnos.service.OrganizacionService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import javax.validation.Valid;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Scanner;

import static java.time.LocalTime.now;

//Indicamos que es un controlador rest
@Slf4j
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

    @RequestMapping(value = "/organizaciones", method = RequestMethod.GET)
    public List<OrganizacionDto> findAll() {

        List<Organizacion> listaOrganizaciones = organizacionService.findAll();
        List<OrganizacionDto> listaOrganizacionesDto = new ArrayList<>();

        for (Organizacion organizacion : listaOrganizaciones) {

            //Aquí filtra para mostrar solamente las activas
            if (organizacion.getActivo() == true) {
                OrganizacionDto organizacionDto = Converters.mapToOrganizacionDto(organizacion);
                listaOrganizacionesDto.add(organizacionDto);
            } else {
                //Aquí va mensaje de error por si no hay ninguna organización que listar
            }
        }

        //retornará todos las organizaciones
        return listaOrganizacionesDto;
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/api/v1/organizaciones/1*/

    /*
    //Esto no lo pide la consigna del trabajo
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
    */


    @RequestMapping(value = "/organizaciones/cuit/{organizacionCuit}", method = RequestMethod.GET)
    public OrganizacionDto getOrganizacionCuit(@Valid @PathVariable Long organizacionCuit) {

        Organizacion organizacion = organizacionService.findByCuit(organizacionCuit);

        if(organizacion == null) {
            throw new RuntimeException("Cuit de organización no encontrado -"+organizacionCuit);
        }

        if (organizacion.getActivo() == true) {
            OrganizacionDto organizacionDto = Converters.mapToOrganizacionDto(organizacion);
            return organizacionDto;
        } else {
            //Aquí va mensaje de error por si no se encuentra ninguna organizacion activa con el cuit indicado
            return null;
        }
    }

    //Lo hice separado en el controller a la búsqueda por cuit o nombre, pero con el mismo servicio, porque
    //me daba un error de página no encontrada cuando intentaba hacerlo en forma conjunta a las opciones de búsqueda

    @RequestMapping(value = "/organizaciones/{organizacionNombre}", method = RequestMethod.GET)
    public OrganizacionDto getOrganizacionNombre(@PathVariable String organizacionNombre) {
        //@PathVariable(required = false) Long organizacionCuit,

        //Long organizacionCuit = 0L;
        Organizacion organizacion = organizacionService.findByNombre(organizacionNombre);

        if(organizacion == null) {
            throw new RuntimeException("Nombre de organizacion no encontrado -"+organizacionNombre);
        }


        if (organizacion.getActivo() == true) {
            OrganizacionDto organizacionDto = Converters.mapToOrganizacionDto(organizacion);
            return organizacionDto;
        } else {

            //Aquí va mensaje de error por si no se encuentra ninguna organizacion activa con el cuit indicado
            return null;

        }
    }

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/organizaciones/
    */

    @RequestMapping(value = "/organizaciones", method = RequestMethod.POST)
    public OrganizacionDto addOrganizacion(@RequestBody Organizacion organizacion) {
        //Se setean los valores por defecto en la organización creada
        organizacion.setIdorganizacion(0L);
        organizacion.setAlta(Calendar.getInstance().getTime());
        organizacion.setActivo(true);

        //Este método guardará al usuario enviado
        organizacionService.create(organizacion);

        OrganizacionDto organizacionDto = Converters.mapToOrganizacionDto(organizacion);

        return organizacionDto;

    }

    /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/organizaciones
    */

    @RequestMapping(value = "/organizaciones/cuit/{organizacionCuit}/clave/{claveIngresada}", method = RequestMethod.PUT)
    public OrganizacionDto updateOrganizacion(@PathVariable Long organizacionCuit, @PathVariable String claveIngresada, @RequestBody OrganizacionDto organizacionDto) {

        //Esto emula el ingreso de la clave por parte del usuario para modificar organización
        //String claveIngresada = organizacion.getClave();
        Organizacion organizacion = organizacionService.findByCuit(organizacionCuit);

        if (claveIngresada.equals(organizacion.getClave())) {

            //este método actualizará al usuario enviado
            Organizacion organizacionModificada = Converters.mapToOrganizacion(organizacionDto);
            organizacionModificada.setIdorganizacion(organizacion.getIdorganizacion());
            organizacionModificada.setCuit(organizacionDto.getCuit());
            organizacionModificada.setActivo(organizacion.getActivo());
            organizacionModificada.setAlta(organizacion.getAlta());
            organizacionModificada.setClave(organizacion.getClave());

            organizacionService.update(organizacionModificada);

            return organizacionDto;
        } else {

            //Aquí va mensaje de error si no se ingresó la clave correctamente
            throw new RuntimeException("Clave incorrecta - Organización no modificada.");
            //return null;

        }
    }

    /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
    http://127.0.0.1:8080/api/v1/organizaciones/1
    */

    @RequestMapping(value = "/organizaciones/cuit/{organizacionCuit}/clave/{claveIngresada}", method = RequestMethod.DELETE)
    public String deleteOrganizacion(@PathVariable Long organizacionCuit, @PathVariable String claveIngresada) {

        Organizacion organizacion = organizacionService.findByCuit(organizacionCuit);

        if(organizacion == null) {
            throw new RuntimeException("Cuit de organización no encontrado -"+organizacionCuit);
        }

        String claveOrganizacion = organizacion.getClave();

        if (claveIngresada.equals(claveOrganizacion)) {

             //Lo que sigue hace el borrado lógico, o sea cambia el estado de del campo activo de true a false,
             //y después no se la va a mostrar a la organizacion en las búsquedas pero queda en la base de datos
             organizacion.setActivo(false);
             organizacionService.update(organizacion);
             return "Cuit de organización borrada - " + organizacionCuit;

        } else {

             //Aquí va mensaje de error si no se ingresó la clave correctamente
             throw new RuntimeException("Clave incorrecta - No se realizó el borrado.");
             //return null;

        }

    }

}
