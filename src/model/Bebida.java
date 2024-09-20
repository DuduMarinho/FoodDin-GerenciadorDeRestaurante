// src/model/Bebida.java
package model;

public class Bebida extends ItemCardapio {

    public Bebida(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public String getDescricao() {
        return "Bebida: " + nome + " - Preço: R$" + preco;
    }
}
