package com.aplicacion.asistenciayturnos.controller;

import com.aplicacion.asistenciayturnos.entity.Usuario;

import com.aplicacion.asistenciayturnos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indiciamos que es un controlador rest
@RestController
@ControllerAdvice
@RequestMapping(value = "/api/v1") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/v1
public class Usuariocontroller {

    //Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private UsuarioService usuarioService;

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/usuarios
    */

    //V1
    //@GetMapping("/usuarios")
    //V2
    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<Usuario> findAll(){
        //retornará todos los usuarios
        return usuarioService.findAll();
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/api/v1/usuarios/1
    */

    //V1
    //@GetMapping("/usuarios/{usuarioId}")
    //V2
    @RequestMapping(value = "usuarios/{usuarioId}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long usuarioId){
        Usuario usuario = usuarioService.findById(usuarioId);

        if(usuario == null) {
            throw new RuntimeException("Identificador de usuario no encontrado -"+usuarioId);
        }
        //retornará al usuario con id pasado en la url
        return usuario;
    }

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/usuarios
    */

    //V1
    //@PostMapping("/usuarios")
    //V2
    @RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public Usuario addUsuario(@RequestBody Usuario usuario) {

        usuario.setIdusuario(0L);

        //Este método guardará al usuario enviado
        usuarioService.save(usuario);

        return usuario;

    }
    /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/v1/usuarios
    */

    //V1
    //@PutMapping("/usuarios")
    //V2
    @RequestMapping(value = "/usuarios", method = RequestMethod.PUT)
    public Usuario updateUsuario(@RequestBody Usuario usuario) {

        //este método actualizará al usuario enviado
        usuarioService.modify(usuario);

        return usuario;
    }

    /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
    http://127.0.0.1:8080/api/v1/usuarios/1
    */

    //V1
    //@DeleteMapping("/usuarios/{usuarioId}")
    //V2
    @RequestMapping(value = "usuarios/{usuarioId}", method = RequestMethod.DELETE)
    public String deleteUsuario(@PathVariable Long usuarioId) {

        Usuario usuario = usuarioService.findById(usuarioId);

        if(usuario == null) {
            throw new RuntimeException("Identificador de usuario no encontrado -"+usuarioId);
        }

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        usuarioService.deleteById(usuarioId);

        return "Identificador de usuario borrado - "+usuarioId;
    }

}
