// src/model/FechamentoConta.java
package model;

import exceptions.PedidoInvalidoException;
import exceptions.MesaNaoEncontradaException;

public class FechamentoConta {

    public static void fecharConta(Restaurante restaurante, int numeroMesa) {
        try {
            Mesa mesa = restaurante.encontrarMesa(numeroMesa); 
            Pedido pedido = new Pedido(mesa);

            double total = pedido.calcularTotal();
            System.out.println("Conta fechada. Total: R$ " + total);

        } catch (MesaNaoEncontradaException e) {
            System.err.println("Erro: " + e.getMessage());
        } catch (PedidoInvalidoException e) {
            System.err.println("Erro no pedido: " + e.getMessage());
        }
    }
}
