import java.util.Scanner;

public class OutroLoop {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        double mediaAvaliacao = 0;
        double nota = 0;
        int totalDeNotas = 0;

        // poderia colocar a condição do while como -1, mas teria que colocar o if do mesmo jeito
        while (true){
            System.out.println("Digite a sua avaliação ou -1 para parar:");
            nota = leitura.nextDouble();
            leitura.nextLine();
            if (nota == -1){ break; }
            mediaAvaliacao += nota;
            totalDeNotas++;
        }

        System.out.println("A média das avaliações é " + (mediaAvaliacao / totalDeNotas));
    }
}
