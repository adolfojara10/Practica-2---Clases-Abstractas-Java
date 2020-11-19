/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.*;
import ups.edu.ec.modelo.Telefono;
import ups.edu.ec.modelo.Usuario;

/**
 *
 * @author Adolfo
 * @param <T>
 */
public class Controlador<T> {

    private List<T> listaGenerica;

    public Controlador() {
        listaGenerica = new ArrayList<>();
    }

    public void create(T objeto) {
        listaGenerica.add(objeto);
        System.out.println(listaGenerica);
    }

    public T read(Object parametroBusqueda) {
        //return listaGenerica.stream().filter(obj -> obj.equals(parametroBusqueda)).findFirst().get();
        
        if(parametroBusqueda.getClass().getName().equalsIgnoreCase("ups.edu.ec.modelo.Usuario")){
            var copiaListaUsuario = (List<Usuario>) listaGenerica;
            
            var usu = (Usuario) parametroBusqueda;
            
            return (T) copiaListaUsuario.stream().filter(usuario -> usuario.equals(usu) || usuario.getCedula().equals(usu.getCedula())).findFirst().get();
           
            /*for(var usuario:copiaListaUsuario){
                
                if(usuario.equals(parametroBusqueda) || usuario.getCedula().equalsIgnoreCase(usu.getCedula()))
                    return (T) usuario;
            }*/
        } else {
            var copiaListaTelefono = (List<Telefono>) listaGenerica;
            return (T) copiaListaTelefono.stream().filter(telefo -> telefo.equals(parametroBusqueda)).findFirst().get();
            /*
            for(var telefono:copiaListaTelefono){
                if(telefono.equals(parametroBusqueda))
                    return (T) telefono;
            }*/
        }
        
        
        
        /*
        for(T objeto:listaGenerica){
            if(objeto.getClass().eparametroBusqueda))
                return objeto;
        }
        return null;*/
    }

    public void update(T objeto, T objetoEliminar) {

        int index = (listaGenerica.indexOf(objetoEliminar));
        listaGenerica.remove(index);
        listaGenerica.add(index, objeto);
        System.out.println("doneeee");

        System.out.println(listaGenerica);
    }

    public void delete(T objeto) {
        listaGenerica.remove(objeto);
    }

    public List<T> findAll() {
        return listaGenerica;
    }

    public Usuario iniciarSesion(String correo, String password) {

        List<Usuario> copiaListaUsuario;
        copiaListaUsuario = (List<Usuario>) List.copyOf(listaGenerica);

        return copiaListaUsuario.stream().filter(usu -> usu.getCorreo().equals(correo)
                && usu.getPassword().equals(password)).findFirst().get();

        //return (Usuario) listaGenerica.stream().filter(tele -> tele.getCorreo().equals(correo) && tele.getPassword().equals(password)).findFirst().get();  
    }

    public int cargarCodigo() {
        var copiaListaTelefonos = (List<Telefono>) listaGenerica;
        if (copiaListaTelefonos.isEmpty()) {
            return 1;
        } else {
            int index = copiaListaTelefonos.size();
            var ultimoTelefono = copiaListaTelefonos.get(index - 1);
            return (ultimoTelefono.getCodigo() + 1);
        }

    }

    public Usuario readNumero(Telefono telefono) {
        var copiaListaUsuario = (List<Usuario>) List.copyOf(listaGenerica);

        for (Usuario usu : copiaListaUsuario) {
            var copiaListaTelefonoUsuario = (List<Telefono>) List.copyOf(usu.getListaTelefonos());
            for (Telefono tele : copiaListaTelefonoUsuario) {
                if (tele.equals(telefono)) {
                    return usu;
                }
            }
        }
        return null;

    }
    
    
    /*
    public Usuario readApellido(String apellidoBusqueda) {
        var copiaListaUsuarios = (List<Usuario>) List.copyOf(listaGenerica);
//        return copiaListaUsuarios.stream().filter(usuario -> usuario.getApellido().equalsIgnoreCase(apellidoBusqueda.trim())).findFirst().get();

        for (Usuario usu : copiaListaUsuarios) {
            if (usu.getApellido().trim().equalsIgnoreCase(apellidoBusqueda.trim())) {
                System.out.println(usu.toString());
                return usu;
            }
        }
        return null;
    }

    public Usuario readCedula(String cedula) {
        var copiaListaUsuarios = (List<Usuario>) List.copyOf(listaGenerica);
        
        return copiaListaUsuarios.stream().filter(usuario -> usuario.getCedula().equals(cedula)).findFirst().get();
        
    }

    

    public Telefono readTelefono(String numero) {
        var copiaListaTelefono = (List<Telefono>) List.copyOf(listaGenerica);

        for (Telefono tele : copiaListaTelefono) {
            if (tele.getNumero().equals(numero.trim())) {
                System.out.println(tele.toString());
                return tele;
            }
        }
        return null;
    }
    
    private List<Usuario> listaUsuarios;
    private List<Telefono> listaTelefonos;

    public Controlador() {
        listaUsuarios = new ArrayList<>();
        listaTelefonos = new ArrayList<>();
    }

    public void createUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public Usuario readUsuario(String apellido) {
        return listaUsuarios.stream().filter(usuario -> usuario.getApellido().equals(apellido)).findFirst().get();
    }

    public void updateUsuario(Usuario usuario) {
        var usuarioUpdate = listaUsuarios.stream().filter(u -> u.getCedula().equals(usuario.getCedula())).findFirst().get();
        int index = listaUsuarios.indexOf(usuarioUpdate);
        listaUsuarios.add(index, usuario);
    }

    public void deleteUsuario(String cedula) {
        var usuarioDelete = listaUsuarios.stream().filter(tele -> tele.getCedula().equals(cedula)).findFirst().get();
        listaUsuarios.remove(usuarioDelete);
    }

    public Usuario iniciarSesion(String correo, String password) {
        return listaUsuarios.stream().filter(u -> u.getCorreo().equals(correo) && u.getPassword().equals(password)).findFirst().get();
    }

  //
    
    public void createTelefono(Telefono telefono) {
        listaTelefonos.add(telefono);
    }

    public Telefono readTelefono(String numero) {
        return listaTelefonos.stream().filter(tele -> tele.getNumero().equals(numero)).findFirst().get();
    }

    public void updateTelefono(Telefono telefono) {
        var telefonoUpdate = listaTelefonos.stream().filter(tele -> tele.getCodigo() == telefono.getCodigo()).findFirst().get();
        int index = listaTelefonos.indexOf(telefonoUpdate);
        listaTelefonos.add(index, telefono);
    }

    public void deleteTelefono(int codigo) {
        var telefonoDelete = listaTelefonos.stream().filter(tele -> tele.getCodigo() == codigo).findFirst().get();
        listaTelefonos.remove(telefonoDelete);
    }

    public List<Telefono> findAll(){
        return listaTelefonos;
    }
     */
}
