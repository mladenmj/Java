package Alimenti;

public class Carne extends Alimento {
    String animaleProvenienza;
    String pezzoAnimale;

    public Carne(String nome, String animaleProvenienza, String pezzoAnimale) {
        super(nome);
        this.animaleProvenienza = animaleProvenienza;
        this.pezzoAnimale = pezzoAnimale;
    }

    @Override
    public String toString() {
        return super.toString() + animaleProvenienza + " " + pezzoAnimale;
    }
}