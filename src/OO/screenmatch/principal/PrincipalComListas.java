package OO.screenmatch.principal;

import OO.screenmatch.modelo.Filme;
import OO.screenmatch.modelo.Serie;
import OO.screenmatch.modelo.Titulo;

import java.util.ArrayList;

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

    }
}
