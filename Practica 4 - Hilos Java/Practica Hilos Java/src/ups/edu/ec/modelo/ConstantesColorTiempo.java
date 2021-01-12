/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.awt.Color;

/**
 *
 * @author User
 */
public class ConstantesColorTiempo {

    public ConstantesColorTiempo() {

    }

    public static final int DEMORA_PENSANDO_MIN = 1000;
    public static final int DEMORA_PENSANDO_MAX = 5000;
    public static final int DEMORA_COMIENDO_MIN = 1000;
    public static final int DEMORA_COMIENDO_MAX = 5000;
    public static final int TIEMPO_DORMIR_HILO = 5000;
    public static final Color COLOR_PANEL = new Color(0, 51, 102);
    public static final Color COLOR_PANEL2 = new Color(102, 102, 0);
    public static final Color COLOR_MESA = new Color(153, 51, 255);
    public static final Color COLOR_FILO_MESA = new Color(64, 55, 158);
    public static final Color COLOR_TENEDOR = new Color(225, 225, 225);

    public static final Color[] ESTADOS_COLOR = {
        new Color(0, 255, 0), //pensar
        new Color(255, 85, 0), //hambre
        new Color(0, 51, 255) // comer
    };


}
