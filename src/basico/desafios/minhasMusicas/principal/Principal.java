package basico.desafios.minhasMusicas.principal;

import basico.desafios.minhasMusicas.modelos.MinhasPreferidas;
import basico.desafios.minhasMusicas.modelos.Musica;
import basico.desafios.minhasMusicas.modelos.Podcast;

public class Principal {
    public static void main(String[] args) {
        Musica musica1 = new Musica();

        musica1.setTitulo("Borboletinha");
        musica1.setAlbum("Músicas infantis");
        musica1.setArtista("Galinha Pintadinha");
        musica1.setGenero("Infantil");

        for (int i = 0; i < 50; i++) {
            musica1.curte();
        }

        for (int i = 0; i < 1000; i++){
            musica1.reproduz();
        }

        Podcast podcast1 = new Podcast();

        podcast1.setTitulo("História da Galinha Pintadinha");
        podcast1.setApresentador("Galo Carijó");
        podcast1.setDescricao("Uma breve história da vida da Galinha Pintadinha contado por seu parceiro.");

        for (int i = 0; i < 5; i++) {
            podcast1.curte();
        }

        for (int i = 0; i < 100; i++){
            podcast1.reproduz();
        }

        MinhasPreferidas minhasPreferidas = new MinhasPreferidas();

        minhasPreferidas.inclui(musica1);
        minhasPreferidas.inclui(podcast1);

    }
}
