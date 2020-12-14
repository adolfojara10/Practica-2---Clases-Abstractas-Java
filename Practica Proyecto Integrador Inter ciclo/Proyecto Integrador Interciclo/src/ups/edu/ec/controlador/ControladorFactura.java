/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.text.SimpleDateFormat;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import ups.edu.ec.modelo.Cliente;
import ups.edu.ec.modelo.Factura;

/**
 *
 * @author User
 */
public class ControladorFactura extends Controlador {

    public ControladorFactura(String ruta) {
        super(ruta);
    }

    public int generarCodigo() {
        int codigo = 0;
        for (Factura c : (List<Factura>) getListaGenerica()) {
            codigo = c.getCodigo();
        }

        return codigo + 1;
    }

    public double calcularSubtotal(Date fechaEntrada, Date fechaSalida) {
        /*
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");

        String fechaE = formatter.format(fechaEntrada);
        String fechaS = formatter.format(fechaSalida);

        
        DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy  HH:mm:ss").withLocale(Locale.ENGLISH);

        DateTime dateTime1 = dtf.parseDateTime(fechaE);
        DateTime dateTime2 = dtf.parseDateTime(fechaS);
        Period period = new Period(dateTime1, dateTime2);

        PeriodFormatter formatter = new PeriodFormatterBuilder()
                .appendYears().appendSuffix(" years ")
                .appendMonths().appendSuffix(" months ")
                .appendWeeks().appendSuffix(" weeks ")
                .appendDays().appendSuffix(" days ")
                .appendHours().appendSuffix(" hours ")
                .appendMinutes().appendSuffix(" minutes ")
                .appendSeconds().appendSuffix(" seconds ")
                .printZeroNever()
                .toFormatter();

        String elapsed = formatter.print(period);
        System.out.println(elapsed);*/
 /*
        long numeroMilisegundosEntrada = fechaEntrada.getTime();
        long numeroMilisegundosSalida = fechaSalida.getTime();

        int totalMilisegundos = Math.round(numeroMilisegundosSalida - numeroMilisegundosEntrada);

        double subtotal = 0.25 * ((totalMilisegundos / 1000 * 60) / 10);*/

        int ano = (fechaEntrada.getYear() + 1900) * 31536000;
        int mes = (int) ((fechaEntrada.getMonth() + 1) * 2628288);
        int dia = (fechaEntrada.getDate() * 86400);
        int hora = (fechaEntrada.getHours() * 3600);
        int minutos = (fechaEntrada.getMinutes() * 60);
        int segundos = (fechaEntrada.getSeconds());

        int tiempo1 = hora + minutos + segundos + ano + mes + dia;

        int ano2 = (fechaEntrada.getYear() + 1900) * 31536000;
        int mes2 = (int) ((fechaEntrada.getMonth() + 1) * 2628288);
        int dia2 = (fechaEntrada.getDate() * 86400);
        int hora2 = (fechaSalida.getHours() * 3600);
        int minutos2 = (fechaSalida.getMinutes() * 60);
        int segundos2 = (fechaSalida.getSeconds());

        int tiempo2 = hora2 + minutos2 + segundos2 + ano2 + mes2 + dia2;

        int tiempoTotal = Math.round(((tiempo2 - tiempo1) / 60));

        double subtotal = 0.25 * (tiempoTotal / 10);

        String sub = String.valueOf(subtotal).replace("-", "");

        return Double.valueOf(sub);

    }

    public int calcularTiempo(Date fechaEntrada, Date fechaSalida) {
        /*
        long numeroMilisegundosEntrada = fechaEntrada.getTime();
        long numeroMilisegundosSalida = fechaSalida.getTime();

        int totalMilisegundos = Math.round(numeroMilisegundosSalida - numeroMilisegundosEntrada);

        int tiempo = Math.round((totalMilisegundos / 1000 * 60));

        return tiempo;*/

        int dia = (fechaEntrada.getDate() * 86400);
        int hora = (fechaEntrada.getHours() * 3600);
        int minutos = (fechaEntrada.getMinutes() * 60);
        int segundos = (fechaEntrada.getSeconds());

        int tiempo1 = hora + minutos + segundos + dia;

        int dia2 = (fechaEntrada.getDate() * 86400);
        int hora2 = (fechaSalida.getHours() * 3600);
        int minutos2 = (fechaSalida.getMinutes() * 60);
        int segundos2 = (fechaSalida.getSeconds());

        int tiempo2 = hora2 + minutos2 + segundos2 + dia2;

        int tiempoTotal = Math.round(((tiempo2 - tiempo1) / 60));

        String sub = String.valueOf(tiempoTotal).replace("-", "");

        return Integer.valueOf(sub);
    }

    public double calcularTotal(double subtotal, boolean descuento) {
        if (descuento) {

            subtotal = subtotal - (subtotal * 0.10);
            String numero = String.format(".2f", subtotal);
            numero = numero.replace(",", ".");

            return Double.valueOf(numero);
        } else {
            return subtotal;
        }
    }

}
