package model;

public class Prato extends ItemCardapio{
    public Prato (String nome, double preco){
        super(nome, preco);
    }

@Override
public String getDescricao(){
    return "Prato: " + nome + "preço: R$" + preco;
}

}