import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o seu filme favorito:");
        String filme = leitura.nextLine();
        System.out.println("Qual o ano de lançamento?");
        int anoDeLancamento = leitura.nextInt();
        leitura.nextLine();
        System.out.println("Digite a sua avaliação:");
        double avaliacao = leitura.nextDouble();
        leitura.nextLine();

        System.out.printf("""
                Filme: %s
                Ano de lançamento: %d
                Avaliação: %.1f
                """, filme, anoDeLancamento, avaliacao);

    }
}
