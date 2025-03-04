import java.util.Scanner;

public class Exercicios {
    Scanner scanner = new Scanner(System.in);

    public void calcuarTemperatura(){
        System.out.println("Digite uma temperatura em ºCelsius:");
        double celsius = scanner.nextDouble();
        scanner.nextLine();

        double fahrenheit = (celsius * 1.8) + 32;

        System.out.println("A temperatura " + celsius + "ºC é equivalente a " +
                fahrenheit + "°F");
    }

    public void conversaoDeMoeda(){
        System.out.println("Digite um valor em reais:");
        double reais = scanner.nextDouble();
        scanner.nextLine();

        double dolares = reais * 5.88;

        System.out.println("O valor R$" + reais + " reais é equivalente a R$" +
                dolares + " dólares");
    }

    public void desconto(){
        System.out.println("Digite o valor do produto:");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        double desconto = valor * 0.1;

        System.out.println("O valor final é de R$" + (valor - desconto) + " com um desconto (10%) de R$" +
                desconto);
    }



}
