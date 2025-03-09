package OO.screenmatch.calculos;

import OO.screenmatch.modelo.Titulo;

public class CalculadoraDeTempo {
    private  int tempoTotal = 0;

    public int getTempoTotal() {
        return this.tempoTotal;
    }

    public void inclui(Titulo t){
        this.tempoTotal += t.getDuracaoEmMinutos();
    }
}
