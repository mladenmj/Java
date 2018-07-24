package Alimenti;

public class Vino extends Alimento {
    String tipo;
    String colore;
    double gradAlcolica;

    public Vino(String nome, String tipo, String colore, double gradAlcolica) {
        super(nome);
        this.tipo = tipo;
        this.colore = colore;
        this.gradAlcolica = gradAlcolica;
    }

    @Override
    public String toString() {
        return super.toString() + gradAlcolica + "° " + tipo + " " + colore;
    }
}