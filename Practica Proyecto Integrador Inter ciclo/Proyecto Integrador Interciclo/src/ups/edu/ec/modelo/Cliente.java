/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author User
 */
public class Cliente extends Persona implements Serializable {

    private EnumClienteContrato enumClienteContrato;

    public Cliente() {

    }

    public Cliente(int codigo, String codigoIdentificacion, String nombre, String apellido,
            Calendar fechaNacimiento, String numeroTelefono, EnumClienteContrato enumClienteContrato) {
        super(codigo, codigoIdentificacion, nombre, apellido, fechaNacimiento, numeroTelefono);

        this.enumClienteContrato = enumClienteContrato;
    }

    public EnumClienteContrato getEnumClienteContrato() {
        return enumClienteContrato;
    }

    public void setEnumClienteContrato(EnumClienteContrato enumClienteContrato) {
        this.enumClienteContrato = enumClienteContrato;
    }

    @Override
    public String toString() {
        return "Cliente{" + "enumClienteContrato=" + enumClienteContrato + '}';
    }

}
