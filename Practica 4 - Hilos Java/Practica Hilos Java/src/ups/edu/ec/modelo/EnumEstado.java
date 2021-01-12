/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

/**
 *
 * @author User
 */
public enum EnumEstado {

    PIENSA(0, "Piensa"),
    HAMBRIENTO(1, "Hambriento"),
    COME(2, "Come");

    //id del estado
    private int id;
    //texto del estado
    private String texto;

    EnumEstado(int id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    //para leer un estado a partir del id
    public static EnumEstado getEstado(int id) {
        for (EnumEstado estado : EnumEstado.values()) {
            if (estado.getId() == id) {
                return estado;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return this.texto;
    }

}
