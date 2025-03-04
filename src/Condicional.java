public class Condicional {
    public static void main(String[] args) {
        int anoDeLancamento = 2022;
        boolean incluidoNoPlano = false;
        double notaDoFilme = 5.9;
        String tipoPlano = "plus";

        if (anoDeLancamento >= 2022){
            System.out.println("Lançamento!");
        } else {
            System.out.println("Filme retrô!");
        }
        // || = or, && = and, ! = not
        if (incluidoNoPlano && tipoPlano.equals("plus")){
            System.out.println("Filme disponível.");
        } else {
            System.out.println("É preciso pagar uma taxa ou alterar o plano.");
        }
    }
}
