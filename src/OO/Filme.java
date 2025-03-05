package OO;

public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    double somaAvaliacoes;
    int totalAvaliacoes;
    int duracaoEmMinutos;

    void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de Lançamento: " + anoDeLancamento);
    }

    void avalia(double nota){
        somaAvaliacoes += nota;
        totalAvaliacoes++;
    }

    double retornaMedia(){
        return somaAvaliacoes / totalAvaliacoes;
    }
}
