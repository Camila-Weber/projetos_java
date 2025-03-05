package OO;

public class Principal {
    public static void main(String[] args) {
        Filme filme1 = new Filme();

        filme1.nome = "Barbie";
        filme1.anoDeLancamento = 2001;

        filme1.avalia(8.9);
        filme1.avalia(6.7);
        filme1.avalia(9);

        filme1.exibeFichaTecnica();
        System.out.println("Média: " + filme1.retornaMedia());
    }
}
