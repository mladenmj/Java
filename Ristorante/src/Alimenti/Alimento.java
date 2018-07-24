package Alimenti;

public abstract class Alimento {
    String nome;

    public Alimento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + " ";
    }
}