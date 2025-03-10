package OO.screenmatch.principal;

import OO.screenmatch.modelo.Filme;
import OO.screenmatch.modelo.Serie;
import OO.screenmatch.modelo.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme filme1 = new Filme("Barbie", 2001, 95);
        filme1.avalia(9.9);
        Serie serie1 = new Serie("Lost", 2001, 0);
        Filme filme2 = new Filme("Avatar", 2022, 120);
        filme2.avalia(7.6);
        Filme filme3 = new Filme("Moana", 2015, 65);
        filme3.avalia(7.4);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filme3);
        lista.add(filme1);
        lista.add(filme2);
        lista.add(serie1);

        for (Titulo item : lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        List<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("The Rock");
        buscaPorArtista.add("Fernanda Montenegro");
        buscaPorArtista.add("Vin Diesel");

        System.out.println(buscaPorArtista);
        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação da lista de artistas: " + buscaPorArtista);

        Collections.sort(lista);
        System.out.println("Depois da ordenação da lista de filmes: " + lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Depois da ordenação por ano de lançamento da lista de filmes: \n" + lista);


    }
}
