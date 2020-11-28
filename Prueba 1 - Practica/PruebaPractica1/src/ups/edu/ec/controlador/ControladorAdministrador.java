/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.List;
import ups.edu.ec.modelo.Administrador;

/**
 *
 * @author User
 */
public class ControladorAdministrador extends Controlador{
    
    //private Administrador instance;

    public ControladorAdministrador(String ruta) {
        super(ruta);
                
    }

    @Override
    public int generarID() {
        if (super.getListaGenerica().isEmpty()) {
            return 1;
        } else {
            return (super.getListaGenerica().size() + 1);
        }
    }
    
    public Administrador logIn(String email, String password){
        List<Administrador> listaAdmins = (List<Administrador>) List.copyOf(super.getListaGenerica());
        
        System.out.println(listaAdmins);
        System.out.println(listaAdmins.size());
        
        Administrador administradorLogeado = listaAdmins.stream().filter(ad -> ad.getEmail().equals(email) && 
                ad.getPassword().equals(password)).findFirst().get();
        
        if(administradorLogeado != null){
            return Administrador.getInstance();
        } else {
            return null;
        }
        
        
    }
    
    
}
