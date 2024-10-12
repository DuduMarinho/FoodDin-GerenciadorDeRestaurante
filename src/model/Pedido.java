// src/model/Pedido.java
package model;

import exceptions.PedidoInvalidoException;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemCardapio> itens;
    private Mesa mesa;

    public Pedido(Mesa mesa) throws PedidoInvalidoException {
        if (mesa == null) {
            throw new PedidoInvalidoException("Mesa não pode ser nula.");
        }
        this.mesa = mesa;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemCardapio item) throws PedidoInvalidoException {
        if (item == null) {
            throw new PedidoInvalidoException("Item não pode ser nulo.");
        }
        itens.add(item);
        System.out.println(item.getNome() + " adicionado ao pedido.");
    }

    public double calcularTotal() throws PedidoInvalidoException {
        if (itens.isEmpty()) {
            throw new PedidoInvalidoException("Seu pedido está sem nada. Não é possível calcular o valor.");
        }
        double total = 0;
        for (ItemCardapio item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }

    public Mesa getMesa() {
        return mesa;
    }
}
