import java.util.Scanner;

public class Exercicios {
    public void calcuarTemperatura(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma temperatura em ºCelsius:");
        double celsius = scanner.nextDouble();
        scanner.nextLine();

        double fahrenheit = (celsius * 1.8) + 32;

        System.out.println("A temperatura " + celsius + "ºC é equivalente a " +
                fahrenheit + "°F");
    }



}
