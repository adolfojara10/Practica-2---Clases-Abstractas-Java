/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Direccion implements Serializable{
    
    private static final long serialVersionUID = 6529685098267757692L;
    
    private String calle1;
    private String calle2;
    private String numeroCalle;

    public Direccion(String calle1, String calle2, String numeroCalle) {
        this.calle1 = calle1;
        this.calle2 = calle2;
        this.numeroCalle = numeroCalle;
    }

    public String getCalle1() {
        return calle1;
    }

    public void setCalle1(String calle1) {
        this.calle1 = calle1;
    }

    public String getCalle2() {
        return calle2;
    }

    public void setCalle2(String calle2) {
        this.calle2 = calle2;
    }

    public String getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(String numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    @Override
    public String toString() {
        return "Direccion:" + "calle1=" + calle1 + ", calle2=" + calle2 + ", numeroCalle=" + numeroCalle;
    }
    
    
}
