import java.util.Random;
import java.util.Scanner;

import java.lang.Math;

public class Exercicios {
    Scanner scanner = new Scanner(System.in);

    public void calcuarTemperatura() {
        System.out.println("Digite uma temperatura em ºCelsius:");
        double celsius = scanner.nextDouble();
        scanner.nextLine();

        double fahrenheit = (celsius * 1.8) + 32;

        System.out.println("A temperatura " + celsius + "ºC é equivalente a " +
                fahrenheit + "°F");
    }

    public void conversaoDeMoeda() {
        System.out.println("Digite um valor em reais:");
        double reais = scanner.nextDouble();
        scanner.nextLine();

        double dolares = reais * 5.88;

        System.out.println("O valor R$" + reais + " reais é equivalente a R$" +
                dolares + " dólares");
    }

    public void desconto() {
        System.out.println("Digite o valor do produto:");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        double desconto = valor * 0.1;

        System.out.println("O valor final é de R$" + (valor - desconto) + " com um desconto (10%) de R$" +
                desconto);
    }

    public void numeroAleatorio() {
        int numAleatorio = new Random().nextInt(100);
        //System.out.println(numAleatorio);
        int cont = 1;

        while (true) {
            System.out.println("Digite um número:");
            double numero = scanner.nextDouble();
            scanner.nextLine();

            if (numero > numAleatorio) {
                System.out.println("O número aleatório é menor!");
                cont++;
            } else if (numero < numAleatorio) {
                System.out.println("O número aleatório é maior!");
                cont++;
            } else {
                System.out.println("Parabéns!!! Você acertou o número aleatório com " + cont + " tentativas.");
                break;
            }

        }
    }

    public void classificacaoNumero() {
        System.out.println("Digite um número:");
        int numero = scanner.nextInt();
        scanner.nextLine();

        // se o número é ímpar ou par
        if (numero % 2 == 0) {
            System.out.printf("O número %d é par.\n", numero);
        } else {
            System.out.printf("O número %d é ímpar.\n", numero);
        }

        // se o número é positivo ou negativo
        if (numero >= 0) {
            System.out.printf("O número %d é positivo.\n", numero);
            // fatorial do número
            int fatorial = 1;
            for (int i = numero; i > 0; i--) {
                fatorial *= i;
            }
            System.out.printf("O fatorial do número %d é %d\n", numero, fatorial);
        } else {
            System.out.printf("O número %d é negativo.\n", numero);
        }

        // tabuada do número
        int cont = 0;
        System.out.println("---- Tabuada ----");
        while (cont <= 10) {
            System.out.printf("%d X %d = %d\n", numero, cont, (numero * cont));
            cont++;
        }
    }

    public void calcularArea(){
        System.out.println("Digite um valor:");
        int valor = scanner.nextInt();
        scanner.nextLine();

        System.out.println("""
                Escolha o que quer calcular com esse valor:
                1 - Calcular área de um quadrado
                2 - Calcular área de um círculo
                """);

        while (true){
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("A área do quadrado é " + valor * valor);
                    return;
                case 2:
                    System.out.println("A área do círculo é " + (Math.pow(valor, 2) * Math.PI));
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

    }

}
