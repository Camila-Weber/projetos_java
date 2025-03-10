package OO.screenmatch.modelo;

import OO.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome, int anoDeLancamento, int duracaoMinutos) {
        this.setNome(nome);
        this.setAnoDeLancamento(anoDeLancamento);
        this.setDuracaoEmMinutos(duracaoMinutos);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) retornaMedia() /2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() +
                " (" + this.getAnoDeLancamento() +
                ")";
    }
}
