// src/model/Restaurante.java
package model;

import exceptions.MesaNaoEncontradaException;
import java.util.List;

public class Restaurante {
    private List<Mesa> mesas;

    public Restaurante(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    public Mesa encontrarMesa(int numeroMesa) throws MesaNaoEncontradaException {
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == numeroMesa) {
                return mesa;
            }
        }
        throw new MesaNaoEncontradaException("Mesa com o número " + numeroMesa + " não foi encontrada.");
    }
}
