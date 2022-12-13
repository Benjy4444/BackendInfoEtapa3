package com.aplicacion.asistenciayturnos.controller;

import com.aplicacion.asistenciayturnos.converter.Converters;
import com.aplicacion.asistenciayturnos.dto.OrganizacionDto;
import com.aplicacion.asistenciayturnos.dto.UsuarioDto;
import com.aplicacion.asistenciayturnos.entity.Organizacion;
import com.aplicacion.asistenciayturnos.entity.Usuario;

import com.aplicacion.asistenciayturnos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Indicamos que es un controlador rest
@RestController
@ControllerAdvice
@RequestMapping(value = "/api/v1") //esta será la raíz de la url, es decir http://127.0.0.1:8080/api/v1
public class Usuariocontroller {

    //Inyectamos el servicio para poder hacer uso de él
    @Autowired
    private UsuarioService usuarioService;

    /* Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/usuarios */

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<UsuarioDto> findAll(){
        List<Usuario> listaUsuarios = usuarioService.findAll();
        List<UsuarioDto> listaUsuariosDto = new ArrayList<>();

        for (Usuario usuario:listaUsuarios){

            UsuarioDto usuarioDto = Converters.mapToUsuarioDto(usuario);
            listaUsuariosDto.add(usuarioDto);

        }
        //retornará todos los usuarios
        return listaUsuariosDto;
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/api/v1/usuarios/id/1 */

    @RequestMapping(value = "/usuarios/id/{usuarioId}", method = RequestMethod.GET)
    public UsuarioDto getUsuario(@PathVariable Long usuarioId){
        Usuario usuario = usuarioService.findById(usuarioId);

        if(usuario == null) {
            throw new RuntimeException("Identificador de usuario no encontrado -"+usuarioId);
        }

        UsuarioDto usuarioDto = Converters.mapToUsuarioDto(usuario);
        //retornará al usuario con id pasado en la url
        return usuarioDto;
    }

    @RequestMapping(value = "/usuarios/dni/{usuarioDni}", method = RequestMethod.GET)
    public UsuarioDto getUsuarioDni(@PathVariable(required = false) Long usuarioDni, @PathVariable(required = false) String usuarioApellido){
        Usuario usuario = usuarioService.findByDniOrApellido(usuarioDni, usuarioApellido);

        if(usuario == null) {
            throw new RuntimeException("Dni de usuario no encontrado -"+usuarioDni);
        }

        UsuarioDto usuarioDto = Converters.mapToUsuarioDto(usuario);
        //retornará al usuario con dni pasado en la url
        return usuarioDto;
    }

    @RequestMapping(value = "/usuarios/apellido/{usuarioApellido}", method = RequestMethod.GET)
    public UsuarioDto getUsuarioApellido(@PathVariable(required = false) Long usuarioDni, @PathVariable(required = false) String usuarioApellido){
        Usuario usuario = usuarioService.findByDniOrApellido(usuarioDni, usuarioApellido);

        if(usuario == null) {
            throw new RuntimeException("Apellido de usuario no encontrado -"+usuarioApellido);
        }

        UsuarioDto usuarioDto = Converters.mapToUsuarioDto(usuario);
        //retornará al usuario con apellido pasado en la url
        return usuarioDto;
    }

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/usuarios */

    @RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        //Esto setea el id en 0 del usuario a crear para que se siga la cuenta automática del id
        usuario.setIdusuario(0L);

        //Este método guardará al usuario enviado
        usuarioService.create(usuario);

        return usuario;

    }
    /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/usuarios */

    @RequestMapping(value = "/usuarios", method = RequestMethod.PUT)
    public Usuario updateUsuario(@RequestBody Usuario usuario) {

        //este método actualizará al usuario enviado
        usuarioService.update(usuario);

        return usuario;
    }

    /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
    http://127.0.0.1:8080/api/v1/usuarios/1 */

    @RequestMapping(value = "/usuarios/{usuarioId}", method = RequestMethod.DELETE)
    public String deleteUsuario(@PathVariable Long usuarioId) {

        Usuario usuario = usuarioService.findById(usuarioId);

        if(usuario == null) {
            throw new RuntimeException("Identificador de usuario no encontrado -"+usuarioId);
        }

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        usuarioService.delete(usuarioId);

        return "Identificador de usuario borrado - "+usuarioId;
    }

}
