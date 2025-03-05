package basico;

import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        double mediaAvaliacao = 0;
        double nota = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite a sua avaliação:");
            nota = leitura.nextDouble();
            leitura.nextLine();
            mediaAvaliacao += nota;
        }

        System.out.println("A média das avaliações é " + (mediaAvaliacao / 5));
    }
}
