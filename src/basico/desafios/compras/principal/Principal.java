package basico.desafios.compras.principal;

import basico.desafios.compras.modelo.Cartao;
import basico.desafios.compras.modelo.Compra;

import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o limite do cartão: ");
        double limite = scanner.nextDouble();
        scanner.nextLine();
        Cartao cartao = new Cartao(limite);

        while (true){
            System.out.println("Descreva a compra: ");
            String descricao = scanner.nextLine();

            System.out.println("Digite o valor da compra: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            Compra novaCompra = new Compra(descricao, valor);

            if (!cartao.compra(novaCompra)){
                break;
            }

            System.out.println("\n0 - Sair\n1 - Continuar\n");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if(opcao != 1){
                break;
            }
        }

        System.out.println("\n--------------- Extrato ---------------\n");

        Collections.sort(cartao.getCompras());
        for (Compra item : cartao.getCompras()) {
            System.out.println(item.getDescricao() + " - " + item.getValor());
        }
        System.out.println("\n---------------------------------------");
        System.out.println("\nSaldo: " + cartao.getSaldo());
    }
}
