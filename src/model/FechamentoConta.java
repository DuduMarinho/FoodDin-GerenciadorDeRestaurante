package model;

public class FechamentoConta {

    public static void fecharConta(Restaurante restaurante, int numeroMesa) {
        try {
            Mesa mesaEncontrada = restaurante.encontrarMesa(numeroMesa);
            Pedido pedido = new Pedido(mesaEncontrada); 

            double total = pedido.calcularTotal();
            System.out.println("Conta fechada. Total: R$ " + total);

        } catch (MesaNaoEncontradaException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
