/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.List;
import ups.edu.ec.modelo.Telefono;
import ups.edu.ec.modelo.Usuario;

/**
 *
 * @author Adolfo
 */
public class ControladorUsuario extends Controlador {

    public ControladorUsuario() {
    }

    @Override
    public int cargarCodigo() {
        if (findAll().size() > 0) {
            return findAll().size() + 1;
        } else {
            return 1;
        }

    }

    public Usuario comprobarMayusculas(Usuario usuario) {
        String[] nombres = usuario.getNombre().split(" ");
        String[] apellidos = usuario.getApellido().split(" ");
        
        String nombreMayusculas = "";
        for (String nombre : nombres) {
            nombreMayusculas += String.valueOf(Character.toUpperCase(nombre.charAt(0))); 
            nombreMayusculas += nombre.substring(1,nombre.length());
            nombreMayusculas += " ";
        }

        String apellidoMayusculas = "";
        for (String apellido : apellidos) {
            apellidoMayusculas += String.valueOf(Character.toUpperCase(apellido.charAt(0))); 
            apellidoMayusculas += apellido.substring(1,apellido.length());
            apellidoMayusculas += " ";
        }
        
        usuario.setNombre(nombreMayusculas.trim());
        usuario.setApellido(apellidoMayusculas.trim());
        
        return usuario;
    }

    public Usuario iniciarSesion(String correo, String password) {
        for (var usuario : (List<Usuario>) findAll()) {
            if (usuario.getCorreo().equals(correo) && usuario.getPassword().equals(password)) {
                return usuario;

            }

        }
        return null;
    }

    public Usuario readCedula(Usuario usuarioBuscar) {
        var copiaListaUsuarios = (List<Usuario>) List.copyOf(findAll());
        return copiaListaUsuarios.stream().filter(usuario -> usuario.getCedula().equals(usuarioBuscar.getCedula())).findFirst().get();
    }

    public Usuario readNumero(Telefono telefonoBuscar) {
        for (var usuario : (List<Usuario>) findAll()) {
            if (usuario.buscarTelefono(telefonoBuscar) != null) {
                return usuario;
            }

        }
        return null;
    }
}
