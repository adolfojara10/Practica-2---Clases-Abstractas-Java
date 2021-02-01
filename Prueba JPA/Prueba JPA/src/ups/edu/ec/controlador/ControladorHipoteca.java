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
import javax.persistence.Query;
import ups.edu.ec.modelo.Hipoteca;

/**
 *
 * @author User
 */
public class ControladorHipoteca extends Controlador<Hipoteca> {

    public BigDecimal calcularCargaFinaciera(BigDecimal montoPrestamo, BigDecimal interes, int mesesPlazo) {
        BigDecimal totalCarga = new BigDecimal(0);
        double carga = 0;

        double anios = (mesesPlazo / 12);
        if (mesesPlazo % 12 != 0) {
            anios += 1;
        }

        BigDecimal aniosPago = new BigDecimal(anios);
        BigDecimal aniosPagoRedondeado = aniosPago.setScale(0, RoundingMode.CEILING);
        System.out.println(anios + " " + aniosPago + " " + aniosPagoRedondeado);

//        double pagoSinIntereses = montoPrestamo.doubleValue() / aniosPagoRedondeado.doubleValue();
        double pagoSinIntereses = (montoPrestamo.doubleValue() / mesesPlazo) * 12;
        BigDecimal pago = new BigDecimal(pagoSinIntereses);
        BigDecimal pagoRedondeado = pago.setScale(2, RoundingMode.CEILING);

        double montoInicial = montoPrestamo.doubleValue();
        BigDecimal montoRedondear = new BigDecimal(0);

        for (int i = 1; i <= aniosPagoRedondeado.intValue(); i++) {
            double interesAnual = montoInicial * (interes.doubleValue() / 100);

            carga = totalCarga.doubleValue() + interesAnual;

            totalCarga = BigDecimal.valueOf(carga).setScale(2, RoundingMode.CEILING);

            montoInicial -= pagoRedondeado.doubleValue();
            montoRedondear = BigDecimal.valueOf(montoInicial).setScale(2, RoundingMode.CEILING);
            montoInicial = montoRedondear.doubleValue();

        }

        return totalCarga;

    }

    public BigDecimal calcularTotal(BigDecimal prestamo, BigDecimal carga) {

        return BigDecimal.valueOf(prestamo.doubleValue() + carga.doubleValue()).setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal calcularMensualidad(BigDecimal total, int plazo) {

        return BigDecimal.valueOf(total.doubleValue() / plazo).setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal calcularSueldoNecesario(BigDecimal mensualidad, int plazo) {

        return BigDecimal.valueOf(mensualidad.doubleValue() * 3.705).setScale(2, RoundingMode.CEILING);
    }

    public Date calcularFechaFin(Date fechaInicio, int mesesPlazo) {
        int ano = (fechaInicio.getYear());
        int mes = fechaInicio.getMonth();

        int sumarAnios = mesesPlazo / 12;
        int sumarMes = mesesPlazo % 12;

        Date fechaFin = new Date((ano + sumarAnios), (mes + sumarMes + 1), fechaInicio.getDate());

        return fechaFin;

    }

    @Override
    public List<Hipoteca> findAll() {
        Query consulta = getEm().createNamedQuery("Hipoteca.findAll");
        return consulta.getResultList();
    }

    @Override
    public int getCodigo() {
        var lista = findAll();

        if (!lista.isEmpty()) {
            Collections.sort(lista, (Hipoteca h1, Hipoteca h2) -> h1.getCodigo().compareTo(h2.getCodigo()));
            return lista.get(lista.size() - 1).getCodigo();
        } else {
            return 0;
        }

    }

}
