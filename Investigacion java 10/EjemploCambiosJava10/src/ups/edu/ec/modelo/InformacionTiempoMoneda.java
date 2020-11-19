/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;

/**
 *
 * @author Adolfo
 */
public class InformacionTiempoMoneda {
    
    private Locale localizacion;
    private Currency currency;
    private Calendar calendario;

    public InformacionTiempoMoneda(Locale localizacion, Calendar calendario) {
        this.localizacion = localizacion;
        currency = Currency.getInstance(localizacion);
        this.calendario = calendario;
    }

    @Override
    public String toString() {
        return "Moneda: \n" + "localizacion: " + localizacion + ", currency: " + currency +
                "\nPrimer día de la semana: " + calendario.getFirstDayOfWeek() + 
                " Zona horaria: " + calendario.getTimeZone().getID();
    }
    
    
}
