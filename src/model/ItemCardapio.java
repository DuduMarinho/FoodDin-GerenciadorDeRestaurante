// src/model/ItemCardapio.java
package model;

public abstract class ItemCardapio {
    protected String nome;
    protected double preco;

    public ItemCardapio(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    } 

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public abstract String getDescricao();

}
