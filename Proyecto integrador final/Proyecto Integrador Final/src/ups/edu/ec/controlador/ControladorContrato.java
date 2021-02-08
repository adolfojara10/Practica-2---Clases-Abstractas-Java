/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ups.edu.ec.modelo.Contrato;
import ups.edu.ec.modelo.EnumTipoPrecioContrato;
import ups.edu.ec.modelo.Sitio;

/**
 *
 * @author User
 */
public class ControladorContrato extends Controlador<Contrato> {

    public BigDecimal obtenerSubtotal(Sitio sitio, Date fechaEntrada, Date fechaSalida, String tipoPrecio) {

        long tiempoE = 0;
        long tiempoS = 0;
        int tiempo = 0;

        switch (tipoPrecio) {
            case "MES" -> {
                tiempoE = (fechaEntrada.getYear() + 1900) * 525600;
                tiempoE += (fechaEntrada.getMonth() + 1) * 43804.8;
                tiempoE += (fechaEntrada.getDate() * 1440);
                tiempoS = (fechaSalida.getYear() + 1900) * 525600;
                tiempoS += (fechaSalida.getMonth() + 1) * 43804.8;
                tiempoS += (fechaSalida.getDate() * 1440);
                tiempo = Math.round(tiempoS - tiempoE);
                break;
            }
            case "SEMANA" -> {
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

        double subtotal = tiempo * sitio.getPrecio().doubleValue();

        BigDecimal sinRedondear = BigDecimal.valueOf(subtotal);
        BigDecimal redondeado = sinRedondear.setScale(2, RoundingMode.HALF_UP);

        return redondeado;

    }

    public BigDecimal obtenerTotal(double subtotal) {

        subtotal = subtotal - (subtotal * 0.10);

        BigDecimal sinRedondear = BigDecimal.valueOf(subtotal);
        BigDecimal redondeado = sinRedondear.setScale(2, RoundingMode.HALF_UP);

        return redondeado;
    }

    @Override
    public List<Contrato> findAll() {
        Query consulta = getEm().createNamedQuery("Contrato.findAll");
        return consulta.getResultList();

    }

    @Override
    public int getLongitud() {
        EntityManager em = getEm();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contrato> rt = cq.from(Contrato.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            //em.close();
        }
    }

}
