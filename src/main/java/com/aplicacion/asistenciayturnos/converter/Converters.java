package com.aplicacion.asistenciayturnos.converter;

import com.aplicacion.asistenciayturnos.dto.EventoDto;
import com.aplicacion.asistenciayturnos.dto.OrganizacionDto;
import com.aplicacion.asistenciayturnos.dto.TurnoDto;
import com.aplicacion.asistenciayturnos.dto.UsuarioDto;
import com.aplicacion.asistenciayturnos.entity.Evento;
import com.aplicacion.asistenciayturnos.entity.Organizacion;
import com.aplicacion.asistenciayturnos.entity.Turno;
import com.aplicacion.asistenciayturnos.entity.Usuario;

import java.util.Optional;

public class Converters {

    public static OrganizacionDto mapToOrganizacionDto(Organizacion organizacion){
        OrganizacionDto organizacionDto = new OrganizacionDto();
        organizacionDto.setCuit(organizacion.getCuit());
        organizacionDto.setNombre(organizacion.getNombre());
        organizacionDto.setDireccion(organizacion.getDireccion());
        organizacionDto.setTelefono(organizacion.getTelefono());
        organizacionDto.setCorreo(organizacion.getCorreo());
        return organizacionDto;
    }

    public static Organizacion mapToOrganizacion(OrganizacionDto organizacionDto) {
        Organizacion organizacion = new Organizacion();
        organizacion.setCuit(organizacionDto.getCuit());
        organizacion.setNombre(organizacionDto.getNombre());
        organizacion.setDireccion(organizacionDto.getDireccion());
        organizacion.setTelefono(organizacionDto.getTelefono());
        organizacion.setCorreo(organizacionDto.getCorreo());
        return organizacion;
    }

    public static EventoDto mapToEventoDto(Evento evento){
        EventoDto eventoDto = new EventoDto();
        eventoDto.setNombre(evento.getNombre());
        eventoDto.setFecha(evento.getFecha());
        eventoDto.setHora(evento.getHora());
        eventoDto.setUbicacion(evento.getUbicacion());
        eventoDto.setTipo(evento.getTipo());
        Organizacion organizacion = evento.getOrganizacion();
        String nombreOrganizacion = organizacion.getNombre();
        eventoDto.setOrganizacion(nombreOrganizacion);
        return eventoDto;
    }

    public static Evento mapToEvento (EventoDto eventoDto){
        Evento evento = new Evento();
        evento.setNombre(eventoDto.getNombre());
        evento.setFecha(eventoDto.getFecha());
        evento.setHora(eventoDto.getHora());
        evento.setUbicacion(eventoDto.getUbicacion());
        evento.setTipo(eventoDto.getTipo());
        //evento.setOrganizacion(eventoDto.getOrganizacion());
        return evento;
    }

    public static UsuarioDto mapToUsuarioDto(Usuario usuario){
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setDni(usuario.getDni());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setApellido(usuario.getApellido());
        usuarioDto.setDireccion(usuario.getDireccion());
        usuarioDto.setTelefono(usuario.getTelefono());
        usuarioDto.setCorreo(usuario.getCorreo());
        return usuarioDto;
    }

    public static Usuario mapToUsuario(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        usuario.setDni(usuarioDto.getDni());
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellido(usuarioDto.getApellido());
        usuario.setDireccion(usuarioDto.getDireccion());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setCorreo(usuarioDto.getCorreo());
        return usuario;
    }

    public static TurnoDto mapToTurnoDto (Turno turno){
        TurnoDto turnoDto = new TurnoDto();
        turnoDto.setFecha(turno.getFecha());
        turnoDto.setHora(turno.getHora());

        Organizacion organizacion = turno.getEvento().getOrganizacion();
        String nombreOrganizacion = organizacion.getNombre();
        turnoDto.setOrganizacion(nombreOrganizacion);

        Evento evento = turno.getEvento();
        String nombreEvento = evento.getNombre();
        turnoDto.setEvento(nombreEvento);

        Usuario usuario = turno.getUsuario();
        String nombreUsuario = usuario.getNombre();
        String apellidoUsuario = usuario.getApellido();
        turnoDto.setUsuario(nombreUsuario+" "+apellidoUsuario);

        return turnoDto;
    }

    public static Turno mapToTurno (TurnoDto turnoDto){

        Turno turno = new Turno();
        turno.setFecha(turnoDto.getFecha());
        turno.setHora(turnoDto.getHora());

        Evento evento = turno.getEvento();
        Long idEvento = evento.getIdevento();
        turno.setIdevento(idEvento);

        Organizacion organizacion = turno.getEvento().getOrganizacion();
        Long idOrganizacion = organizacion.getIdorganizacion();
        evento.getOrganizacion().setIdorganizacion(idOrganizacion);

        Usuario usuario = turno.getUsuario();
        Long idUsuario = usuario.getIdusuario();
        turno.setIdusuario(idUsuario);

        return turno;
    }

}
