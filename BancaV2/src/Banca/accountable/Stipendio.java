package Banca.accountable;

public class Stipendio extends AbstractAccountable {
    private double cifraBase, cifraReale;
    private final double COSTO_ORA = 15;

    public Stipendio(double cifraBase) {
        super(AccountableType.ACCREDITO);
        this.cifraBase = cifraBase;
        this.cifraReale = cifraBase;
    }

    public void addStraordinario(int oreStr){
        cifraReale += COSTO_ORA * oreStr;
    }

    @Override
    public double getImporto() {
        double salario = cifraReale;
        cifraReale = cifraBase;

        return salario;
    }
}
