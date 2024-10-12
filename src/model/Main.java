package model;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Criação de algumas mesas para o restaurante
        Mesa mesa1 = new Mesa(1);
        Mesa mesa2 = new Mesa(2);
        Mesa mesa3 = new Mesa(3);

        Restaurante restaurante = new Restaurante(Arrays.asList(mesa1, mesa2, mesa3));

        Scanner scanner = new Scanner(System.in);

        try {
            boolean rodando = true;

            while (rodando) {

                System.out.println("\nEscolha uma ação:");
                System.out.println("1. Fechar conta de uma mesa");
                System.out.println("2. Adicionar item ao pedido");
                System.out.println("3. Editar item do pedido");
                System.out.println("4. Visualizar pedido");
                System.out.println("0. Sair");
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Informe o número da mesa para fechar a conta: ");
                        int numeroMesa = scanner.nextInt();
                        FechamentoConta.fecharConta(restaurante, numeroMesa);
                        break;

                    case 2:
                        System.out.print("Informe o número da mesa para adicionar item: ");
                        numeroMesa = scanner.nextInt();
                        Mesa mesa = restaurante.encontrarMesa(numeroMesa);
                        Pedido pedido = new Pedido(mesa);

                        ItemCardapio prato1 = new Prato("Hamburguer", 20.0);
                        ItemCardapio prato2 = new Bebida("Coca-Cola", 5.0);

                        System.out.println("Escolha um item para adicionar ao pedido:");
                        System.out.println("1. " + prato1.getNome() + " - R$ " + prato1.getPreco());
                        System.out.println("2. " + prato2.getNome() + " - R$ " + prato2.getPreco());
                        int escolhaItem = scanner.nextInt();

                        if (escolhaItem == 1) {
                            pedido.adicionarItem(prato1);
                        } else if (escolhaItem == 2) {
                            pedido.adicionarItem(prato2);
                        }
                        break;

                    case 3:
                        System.out.print("Informe o número da mesa para editar o pedido: ");
                        numeroMesa = scanner.nextInt();
                        mesa = restaurante.encontrarMesa(numeroMesa);
                        pedido = new Pedido(mesa);
                        pedido.listarItens();

                        System.out.print("Escolha o número do item para editar: ");
                        int itemIndex = scanner.nextInt() - 1; 

                        ItemCardapio novoPrato1 = new Prato("Pizza", 30.0);
                        ItemCardapio novoPrato2 = new Bebida("Suco", 8.0);

                        System.out.println("Escolha o novo item:");
                        System.out.println("1. " + novoPrato1.getNome() + " - R$ " + novoPrato1.getPreco());
                        System.out.println("2. " + novoPrato2.getNome() + " - R$ " + novoPrato2.getPreco());

                        escolhaItem = scanner.nextInt();

                        if (escolhaItem == 1) {
                            pedido.editarItem(itemIndex, novoPrato1);
                        } else if (escolhaItem == 2) {
                            pedido.editarItem(itemIndex, novoPrato2);
                        }
                        break;

                    case 4:
                        System.out.print("Informe o número da mesa para visualizar o pedido: ");
                        numeroMesa = scanner.nextInt();
                        mesa = restaurante.encontrarMesa(numeroMesa);
                        pedido = new Pedido(mesa);

                        pedido.listarItens();
                        break;

                    case 0:
                        rodando = false; 
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            }

        } catch (MesaNaoEncontradaException e) {
            System.err.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Sistema de pedidos encerrado.");
        }
    }
}
