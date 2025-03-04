public class Main {
    public static void main(String[] args) {

        System.out.println("Esse é o Screen Match");

        System.out.println("Filme: Top Gun: Maverick");

        int anoDeLancamento = 2022;
        System.out.println("Ano de lançamento: " + anoDeLancamento);
        boolean incluidoNoPlano = true;
        double notaDoFilme = 5.9;

        double media = (9.8 + 6.3 + 8 + notaDoFilme) / 4;
        System.out.println("Média: " + media);

        String sinopse = "Filme de aventura com galã dos anos 80.";
        System.out.println(sinopse);
        // formatação de texto com concatenação de variáveis com o printf
        System.out.printf("""
                Filme: Top Gun
                Sinopse: %s
                Ano de lançamento: %d
                Média de notas: %.2f
                """, sinopse, anoDeLancamento, media);

    }
}