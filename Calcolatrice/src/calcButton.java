import javax.swing.*;

public class calcButton extends JButton implements Comparable {
    private int order;
    private boolean special;

    public calcButton(String string, int order, boolean special) {
        super(string);
        this.order = order;
        this.special = special;
    }

    public boolean isSpecial() {
        return special;
    }

    @Override
    public int compareTo(Object o) {
        return order - ((calcButton) o).order;
    }
}
