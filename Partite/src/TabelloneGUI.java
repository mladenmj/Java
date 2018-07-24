import javax.swing.*;
import java.awt.*;

public class TabelloneGUI extends JFrame {
    private JPanel mainPanel = new JPanel();
    private JPanel scorePanel;
    private JPanel halftimePanel;
    private JLabel homeName, awayName, halftime, homeScore, awayScore;

    public TabelloneGUI() {
        super();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();

        setSize(dim.width / 2, dim.height / 2);
        setLocation(dim.width / 4, dim.height / 4);
        setLayout(new BorderLayout());

        mainPanel.setPreferredSize(new Dimension(dim.width / 8, dim.height / 8));
        mainPanel.setBackground(Color.RED);
        mainPanel.setLayout(new GridLayout(3, 1));

        JPanel teamNamesPanel = new JPanel();
        teamNamesPanel.setLayout(new FlowLayout());
        JLabel homeName = new JLabel("Roma");
        homeName.setFont(new Font("Arial", Font.PLAIN, 50));
        JLabel awayName = new JLabel("Juve");
        awayName.setFont(new Font("Arial", Font.BOLD, 50));
        teamNamesPanel.add(homeName);
        teamNamesPanel.add(awayName);

        scorePanel = new JPanel();
        scorePanel.setLayout(new FlowLayout());
        JLabel homeScore = new JLabel("1");
        JLabel awayScore = new JLabel("0");
        scorePanel.add(homeScore);
        scorePanel.add(awayScore);

        mainPanel.add(teamNamesPanel, 0);
        mainPanel.add(scorePanel, 1);
//        mainPanel.add(halftimePanel, 2);

        add(mainPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}