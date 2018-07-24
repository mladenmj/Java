import javax.swing.*;
import java.awt.*;

public class ResidenceGUI extends JFrame {
    Residence residence;
    JPanel mainPanel = new JPanel();

    public ResidenceGUI(Residence residence) {
        this.residence = residence;
        initGui();
    }

    private void initGui() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();

        setSize(d.width / 2, d.height / 2);
        setLocation(d.width / 4, d.height / 4);
        setLayout(new BorderLayout());

        JButton button = new JButton();

        add(mainPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}