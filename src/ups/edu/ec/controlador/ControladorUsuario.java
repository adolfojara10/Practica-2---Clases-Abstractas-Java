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
        return (int) findAll().get(findAll().size() - 1);
    }

    public Usuario iniciarSesion(String correo, String password){
        for (var usuario : (List<Usuario>) findAll()) {
            if (usuario.getCorreo().equals(correo) && usuario.getPassword().equals(password)){ 
                return usuario;
                
            }
            
        }
        return null;
    }
    
    public Usuario readNumero(Telefono telefonoBuscar) {
        for (var usuario : (List<Usuario>) findAll()) {
            if (usuario.buscarTelefono(telefonoBuscar) != null) 
                return usuario;
            
        }
        return null;
    }
}
