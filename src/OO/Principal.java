package OO;

import OO.screenmatch.calculos.FiltroRecomendacao;
import OO.screenmatch.modelo.Episodio;
import OO.screenmatch.modelo.Filme;
import OO.screenmatch.modelo.Serie;
import OO.screenmatch.calculos.CalculadoraDeTempo;

public class Principal {
    public static void main(String[] args) {
        Filme filme1 = new Filme();

        filme1.setNome("Barbie");
        filme1.setAnoDeLancamento(2001);
        filme1.setDuracaoEmMinutos(95);

        filme1.avalia(8.9);
        filme1.avalia(6.7);
        filme1.avalia(9);

        filme1.exibeFichaTecnica();
        System.out.println("Média: " + filme1.retornaMedia());
        System.out.println("Total de avaliações: " + filme1.getTotalAvaliacoes());

        Serie serie1 = new Serie();
        serie1.setNome("Lost");
        serie1.setTemporadas(10);
        serie1.setEpisodiosPorTemporada(10);
        serie1.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar " + serie1.getNome() + ": " + serie1.getDuracaoEmMinutos());

        Filme filme2 = new Filme();

        filme2.setNome("Avatar");
        filme2.setAnoDeLancamento(2022);
        filme2.setDuracaoEmMinutos(120);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filme1);
        calculadora.inclui(filme2);
        calculadora.inclui(serie1);
        System.out.println("Tempo total: " + calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(filme1);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(serie1);
        episodio.setTotalVisualizacoes(90);

        filtro.filtra(episodio);

    }
}
