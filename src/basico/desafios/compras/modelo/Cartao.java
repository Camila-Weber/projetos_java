package basico.desafios.compras.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cartao {
    private double limite;
    private double saldo;
    private List<Compra> compras;

    public Cartao(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    public boolean compra(Compra compra){
        if (compra.getValor() > this.saldo){
            System.out.println("Compra inválida. Saldo insuficiente.");
            return false;
        } else {
            saldo -= compra.getValor();
            this.compras.add(compra);
            System.out.println("Compra realizada.");
            return true;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }
}
