package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemCardapio> itens;
    public Mesa mesa;

    public Pedido(Mesa mesa) {
        this.mesa = mesa;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemCardapio item) {
        itens.add(item);
        System.out.println("Item " + item.getNome() + " adicionado ao pedido.");
    }

    public void editarItem(int index, ItemCardapio novoItem) {
        if (index >= 0 && index < itens.size()) {
            itens.set(index, novoItem);
            System.out.println("Item " + index + " foi atualizado para " + novoItem.getNome());
        } else {
            System.out.println("Índice do item inválido.");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemCardapio item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum item no pedido.");
        } else {
            for (int i = 0; i < itens.size(); i++) {
                System.out.println((i + 1) + ". " + itens.get(i).getNome() + " - R$ " + itens.get(i).getPreco());
            }
        }
    }
}
