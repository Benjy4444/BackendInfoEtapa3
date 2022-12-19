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

            //Aquí filtra para mostrar solamente los usuarios activos
            if (usuario.getActivo()== true){
                UsuarioDto usuarioDto = Converters.mapToUsuarioDto(usuario);
                listaUsuariosDto.add(usuarioDto);
            }else{
                //Aquí va el mesaje de error por si no hay usuarios para incorporar a la lista
            }

        }
        //retornará todos los usuarios
        return listaUsuariosDto;
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/api/v1/usuarios/id/1 */

    /*
    //Esto no se pide en la consigna
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
    */

    @RequestMapping(value = "/usuarios/{usuarioDni}", method = RequestMethod.GET)
    public UsuarioDto getUsuarioDni(@PathVariable Long usuarioDni){
        Usuario usuario = usuarioService.findByDni(usuarioDni);

        if(usuario == null) {
            throw new RuntimeException("Dni de usuario no encontrado -"+usuarioDni);
        }

        if(usuario.getActivo()==true){
            UsuarioDto usuarioDto = Converters.mapToUsuarioDto(usuario);
            //retornará al usuario con dni pasado en la url
            return usuarioDto;
        } else{
            //Aquí va el mensaje de error por si no se encuentra ningún usuario activo con el dni pasado
            return null;
        }
    }

    @RequestMapping(value = "/usuarios{usuarioApellido}", method = RequestMethod.GET)
    public UsuarioDto getUsuarioApellido(@PathVariable String usuarioApellido){
        Usuario usuario = usuarioService.findByApellido(usuarioApellido);

        if(usuario == null) {
            throw new RuntimeException("Apellido de usuario no encontrado -"+usuarioApellido);
        }

        if (usuario.getActivo()==true) {
            UsuarioDto usuarioDto = Converters.mapToUsuarioDto(usuario);
            //retornará al usuario con apellido pasado en la url
            return usuarioDto;
        } else {
            //Aquí va el mesaje de error si no se encuentra ningún usuario activo con el apellido pasado
            return null;
        }
    }

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/usuarios */

    @RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public UsuarioDto addUsuario(@RequestBody Usuario usuario) {
        //Esto setea el id en 0 del usuario a crear para que se siga la cuenta automática del id
        usuario.setIdusuario(0L);
        usuario.setActivo(true);

        //Este método guardará al usuario enviado
        usuarioService.create(usuario);

        UsuarioDto usuarioDto = Converters.mapToUsuarioDto(usuario);

        return usuarioDto;

    }

    /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/usuarios */

    @RequestMapping(value = "/usuarios/dni/{usuarioDni}/clave/{claveIngresada}", method = RequestMethod.PUT)
    public UsuarioDto updateUsuario(@PathVariable Long usuarioDni, @PathVariable String claveIngresada, @RequestBody UsuarioDto usuarioDto) {

        //Esto emula el ingreso de la clave por parte del usuario para modificar organización
        //String claveIngresada = usuario.getClave();
        Usuario usuario = usuarioService.findByDni(usuarioDni);

        if(usuario == null) {
            throw new RuntimeException("Dni de usuario no encontrado -"+usuarioDni);
        }

        if (claveIngresada.equals(usuario.getClave())) {

            Usuario usuarioModificado = Converters.mapToUsuario(usuarioDto);
            usuarioModificado.setIdusuario(usuario.getIdusuario());
            usuarioModificado.setActivo(usuario.getActivo());
            usuarioModificado.setClave(usuario.getClave());

            //este método actualizará al usuario enviado
            usuarioService.update(usuarioModificado);

            return usuarioDto;
        }else{

            //Aquí va mensaje de error si no se ingresó la clave correctamente
            throw new RuntimeException("Clave incorrecta - Usuario no modificado.");
            //return null;

        }
    }

    /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
    http://127.0.0.1:8080/api/v1/usuarios/1 */

    @RequestMapping(value = "/usuarios/dni/{usuarioDni}/clave/{claveIngresada}", method = RequestMethod.DELETE)
    public String deleteUsuario(@PathVariable Long usuarioDni, @PathVariable String claveIngresada) {

        Usuario usuario = usuarioService.findByDni(usuarioDni);

        if(usuario == null) {
            throw new RuntimeException("Dni de usuario no encontrado -"+usuarioDni);
        }

        //Esto que sigue emula el ingreso por parte del usuario de la clave para borrar
        //String claveIngresada = usuario.getClave();

        if (claveIngresada.equals(usuario.getClave())) {

            //Lo que sigue hace el borrado lógico, o sea cambia el estado de del campo activo de true a false,
            //y después no se la va a mostrar a la organizacion en las búsquedas pero queda en la base de datos
            usuario.setActivo(false);
            usuarioService.update(usuario);

            //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
            //usuarioService.delete(usuarioId);

            return "Dni de usuario borrado - "+usuarioDni;
        } else {

            //Aquí va mensaje de error si no se ingresó la clave correctamente
            throw new RuntimeException("Clave incorrecta - Usuario no borrado.");
            //return null;

        }
    }
}
