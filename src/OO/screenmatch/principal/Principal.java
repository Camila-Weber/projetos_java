package OO.screenmatch.principal;

import OO.screenmatch.calculos.FiltroRecomendacao;
import OO.screenmatch.modelo.Episodio;
import OO.screenmatch.modelo.Filme;
import OO.screenmatch.modelo.Serie;
import OO.screenmatch.calculos.CalculadoraDeTempo;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme filme1 = new Filme("Barbie", 2001, 95);

        filme1.avalia(8.9);
        filme1.avalia(6.7);
        filme1.avalia(9);

        filme1.exibeFichaTecnica();
        System.out.println("Média: " + filme1.retornaMedia());
        System.out.println("Total de avaliações: " + filme1.getTotalAvaliacoes());

        Serie serie1 = new Serie("Lost", 2001, 0);
        serie1.setTemporadas(10);
        serie1.setEpisodiosPorTemporada(10);
        serie1.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar " + serie1.getNome() + ": " + serie1.getDuracaoEmMinutos());

        Filme filme2 = new Filme("Avatar", 2022, 120);

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

        Filme filme3 = new Filme("Moana", 2015, 65);
        filme3.avalia(8.9);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme3);
        listaDeFilmes.add(filme1);
        listaDeFilmes.add(filme2);

        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
    }
}
