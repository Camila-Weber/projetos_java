import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = 3500;
        String titular = "Camila Weber";
        String tipoDaConta = "Corrente";

        System.out.printf("""
                \n--------------- Dados ---------------\n
                Titular da conta:     %s
                Tipo de conta:        %s
                Saldo:                R$ %.2f \n
                -------------------------------------\n
                """, titular, tipoDaConta, saldo);

        while (true) {
            System.out.printf("""
                    \n--------------- Menu ---------------
                    1 - Consultar saldo
                    2 - Receber valor
                    3 - Transferir valor
                    4 - Sair
                    --------------------------------------
                    """);
            int opcao = scanner.nextInt();
            scanner.nextLine();
            double valor = 0;

            switch (opcao) {
                case 1:
                    System.out.printf("Saldo atualizado: R$ %.2f", saldo);
                    break;
                case 2:
                    System.out.println("Digite o valor a ser recebido:");
                    valor = scanner.nextDouble();
                    scanner.nextLine();
                    saldo += valor;
                    System.out.printf("Saldo atualizado: R$ %.2f", saldo);
                    break;
                case 3:
                    System.out.println("Digite o valor a ser recebido:");
                    valor = scanner.nextDouble();
                    scanner.nextLine();
                    if (valor > saldo) {
                        System.out.println("Saldo insuficiente para realizar a transferência.");
                    } else {
                        saldo -= valor;
                        System.out.printf("Saldo atualizado: R$ %.2f", saldo);
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

}
