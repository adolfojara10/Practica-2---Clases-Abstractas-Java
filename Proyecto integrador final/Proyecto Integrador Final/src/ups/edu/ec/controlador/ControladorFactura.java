/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ups.edu.ec.modelo.Factura;
import ups.edu.ec.modelo.Sitio;

/**
 *
 * @author User
 */
public class ControladorFactura extends Controlador<Factura> {

    public BigDecimal calcularSubtotal(Date fechaEntrada, Date fechaSalida) {

        int ano = (fechaEntrada.getYear() + 1900) * 31536000;
        int mes = (int) ((fechaEntrada.getMonth() + 1) * 2628288);
        int dia = (fechaEntrada.getDate() * 86400);
        int hora = (fechaEntrada.getHours() * 3600);
        int minutos = (fechaEntrada.getMinutes() * 60);
        int segundos = (fechaEntrada.getSeconds());

        int tiempo1 = hora + minutos + segundos + ano + mes + dia;

        int ano2 = (fechaEntrada.getYear() + 1900) * 31536000;
        int mes2 = (int) ((fechaSalida.getMonth() + 1) * 2628288);
        int dia2 = (fechaSalida.getDate() * 86400);
        int hora2 = (fechaSalida.getHours() * 3600);
        int minutos2 = (fechaSalida.getMinutes() * 60);
        int segundos2 = (fechaSalida.getSeconds());

        int tiempo2 = hora2 + minutos2 + segundos2 + ano2 + mes2 + dia2;

        int tiempoTotal = Math.round(((tiempo2 - tiempo1) / 60));

        double subtotal = 0.25 * (tiempoTotal / 10);

        String sub = String.valueOf(subtotal).replace("-", "");

        subtotal = Double.valueOf(sub);

        BigDecimal sinRedondear = BigDecimal.valueOf(subtotal);
        BigDecimal redondeado = sinRedondear.setScale(2, RoundingMode.HALF_UP);

        return redondeado;

    }

    public int calcularTiempo(Date fechaEntrada, Date fechaSalida) {
        int dia = (fechaEntrada.getDate() * 86400);
        int hora = (fechaEntrada.getHours() * 3600);
        int minutos = (fechaEntrada.getMinutes() * 60);
        int segundos = (fechaEntrada.getSeconds());

        int tiempo1 = hora + minutos + segundos + dia;

        int dia2 = (fechaSalida.getDate() * 86400);
        int hora2 = (fechaSalida.getHours() * 3600);
        int minutos2 = (fechaSalida.getMinutes() * 60);
        int segundos2 = (fechaSalida.getSeconds());

        int tiempo2 = hora2 + minutos2 + segundos2 + dia2;

        int tiempoTotal = Math.round(((tiempo2 - tiempo1) / 60));

        String sub = String.valueOf(tiempoTotal).replace("-", "");

        return Integer.valueOf(sub);
    }

    public BigDecimal calcularTotal(double subtotal, boolean descuento) {
        if (descuento) {

            subtotal = subtotal - (subtotal * 0.10);
            /*String numero = String.format(".2f", subtotal);
            numero = numero.replace(",", ".");*/

            BigDecimal sinRedondear = BigDecimal.valueOf(subtotal);
            BigDecimal redondeado = sinRedondear.setScale(2, RoundingMode.HALF_UP);

            return redondeado;
        } else {
            return BigDecimal.valueOf(subtotal);
        }
    }

    public int codigoSiguiente() {
        var lista = findAll();

        Collections.sort(lista, (Factura f1, Factura f2) -> f1.getCodigo().compareTo(f2.getCodigo()));

        return lista.get(lista.size() - 1).getCodigo();
    }

    @Override
    public List<Factura> findAll() {
        Query consulta = getEm().createNamedQuery("Factura.findAll");
        return consulta.getResultList();
    }

    @Override
    public int getLongitud() {
        EntityManager em = getEm();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factura> rt = cq.from(Factura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            //em.close();
        }
    }

}
