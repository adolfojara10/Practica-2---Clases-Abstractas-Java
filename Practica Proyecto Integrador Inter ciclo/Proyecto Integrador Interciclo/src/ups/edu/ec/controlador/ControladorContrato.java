/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import ups.edu.ec.modelo.Cliente;
import ups.edu.ec.modelo.Contrato;
import ups.edu.ec.modelo.EnumTipoPrecioContrato;
import ups.edu.ec.modelo.Sitio;

/**
 *
 * @author User
 */
public class ControladorContrato extends Controlador {

    public ControladorContrato(String ruta) {
        super(ruta);
    }

    public int generarCodigo() {
        int codigo = 0;
        for (Contrato c : (List<Contrato>) getListaGenerica()) {
            codigo = c.getCodigo();
        }

        return codigo + 1;
    }

    public double obtenerSubtotal(Sitio sitio, Date fechaEntrada, Date fechaSalida, EnumTipoPrecioContrato tipoPrecio) {

        long tiempoE = 0;
        long tiempoS = 0;
        int tiempo = 0;

        switch (tipoPrecio) {
            case MES -> {
                tiempoE = (fechaEntrada.getYear() + 1900) * 525600;
                tiempoE += (fechaEntrada.getMonth() + 1) * 43804.8;
                tiempoE += (fechaEntrada.getDate() * 1440);
                tiempoS = (fechaSalida.getYear() + 1900) * 525600;
                tiempoS += (fechaSalida.getMonth() + 1) * 43804.8;
                tiempoS += (fechaSalida.getDate() * 1440);
                tiempo = Math.round(tiempoS - tiempoE);
                break;
            }
            case SEMANA -> {
                tiempoE = (fechaEntrada.getYear() + 1900) * 525600;
                tiempoE += (fechaEntrada.getMonth() + 1) * 43804.8;
                tiempoE += (fechaEntrada.getDate() * 1440);
                tiempoS = (fechaSalida.getYear() + 1900) * 525600;
                tiempoS += (fechaSalida.getMonth() + 1) * 43804.8;
                tiempoS += (fechaSalida.getDate() * 1440);
                tiempo = Math.round(tiempoS - tiempoE);
                break;
            }
            default -> {
                tiempoE = (fechaEntrada.getYear() + 1900) * 525600;
                tiempoE += (fechaEntrada.getMonth() + 1) * 43804.8;
                tiempoE += (fechaEntrada.getDate() * 1440);
                tiempoS = (fechaSalida.getYear() + 1900) * 525600;
                tiempoS += (fechaSalida.getMonth() + 1) * 43804.8;
                tiempoS += (fechaSalida.getDate() * 1440);
                tiempo = Math.round(tiempoS - tiempoE);
                break;
            }
        }

        System.out.println(tiempoS + " " + tiempoE);

        double subtotal = tiempo * sitio.getPrecioHora();
        return subtotal;

    }

    public double obtenerTotal(double subtotal) {

        return subtotal - (subtotal * 0.10);
    }

}
