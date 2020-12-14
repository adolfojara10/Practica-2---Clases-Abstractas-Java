/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.List;
import ups.edu.ec.modelo.EnumEstadoSitio;
import ups.edu.ec.modelo.Sitio;

/**
 *
 * @author User
 */
public class ControladorSitio extends Controlador {

    public ControladorSitio(String ruta) {
        super(ruta);
        //cargarSitios();
    }

    public void cargarSitios() {
        var listaSitios = (List<Sitio>) getListaGenerica();
        int numeroSitios = 51;

        while (numeroSitios > 1) {
            numeroSitios--;
            Sitio sitio = new Sitio(numeroSitios, EnumEstadoSitio.DESOCUPADO);
            listaSitios.add(sitio);

        }
        guardarDatos(listaSitios);
    }

    public Sitio encontrarSitioDesocupado() {
        var listaSitios = (List<Sitio>) getListaGenerica();
        return listaSitios.stream().filter(sit -> sit.getEnumEstadoSitio().equals(EnumEstadoSitio.DESOCUPADO)).findFirst().get();
    }

    public void cambiarAEstadoOcupado(Sitio sitio) {
        sitio.setEnumEstadoSitio(EnumEstadoSitio.OCUPADO);
        this.update(sitio, sitio);

    }

    public void cambiarAEstadoContratado(Sitio sitio) {
        sitio.setEnumEstadoSitio(EnumEstadoSitio.CONTRATADO);
        this.update(sitio, sitio);

    }

    public void cambiarAEstadoDescupado(Sitio sitio) {
        sitio.setEnumEstadoSitio(EnumEstadoSitio.DESOCUPADO);
        this.update(sitio, sitio);
    }
}
