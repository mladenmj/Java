import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Basic calculator excercise with Java.
 * Swing library used.
 * @author Mladen
 */

public class calculatorGUI extends JFrame implements ActionListener {
    JLabel screenText = new JLabel("Hello", JLabel.RIGHT);
    JPanel buttonPanel = new JPanel();
    public ArrayList<calcButton> buttons = new ArrayList<>();
    String display = "";
    boolean commaUsed = false, opSet = false;
    int op, tmp;
    double result = 0;

    public calculatorGUI() {
        super();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        setSize(dimension.width / 2, dimension.height / 2);
        setLocation(dimension.width / 4, dimension.height / 4);

        Container mainPane = getContentPane();
        mainPane.setBackground(Color.BLACK);

        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        screenText.setForeground(Color.GREEN);
        screenText.setFont(new Font("Tahoma", Font.BOLD, 36));
        screenText.setPreferredSize(new Dimension(dimension.width, dimension.height / 8));
        buttonPanel.setLayout(new GridLayout(4, 5));

        initPanel();

        for (int i = 0; i < buttons.size(); i++) {
            buttonPanel.add(buttons.get(i), i);
            buttons.get(i).addActionListener(this);
        }

        add(screenText, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void initPanel() {
        buttons.add(new calcButton("0", 16, false));
        buttons.add(new calcButton("1", 11, false));
        buttons.add(new calcButton("2", 12, false));
        buttons.add(new calcButton("3", 13, false));
        buttons.add(new calcButton("4", 6, false));
        buttons.add(new calcButton("5", 7, false));
        buttons.add(new calcButton("6", 8, false));
        buttons.add(new calcButton("7", 1, false));
        buttons.add(new calcButton("8", 2, false));
        buttons.add(new calcButton("9", 3, false));
        buttons.add(new calcButton(".", 17, true));
        buttons.add(new calcButton("=", 18, true));
        buttons.add(new calcButton("+", 4, true));
        buttons.add(new calcButton("-", 9, true));
        buttons.add(new calcButton("*", 14, true));
        buttons.add(new calcButton("/", 19, true));
        buttons.add(new calcButton("MC", 20, true));
        buttons.add(new calcButton("M+", 10, true));
        buttons.add(new calcButton("MR", 15, true));
        buttons.add(new calcButton("CE", 5, true));

        Collections.sort(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String resultString;

        for (int i = 0; i < buttons.size(); i++) {
            if (e.getActionCommand().equals(buttons.get(i).getText())) {
                if (! buttons.get(i).isSpecial()) {
                    display += buttons.get(i).getText();
                    screenText.setText(display);
                    tmp = Integer.parseInt(screenText.getText());
                }
            }
        }

        if (e.getActionCommand().equals("CE")) {
            display = "";
            result = 0;
            commaUsed = false;
            screenText.setText("Hello");
        }

        if (e.getActionCommand().equals(".")) {

            // 'if' statement prevents multiple commas showing on display.
            if (!commaUsed) {
                display += buttons.get(16).getText();
                screenText.setText(display);
                commaUsed = true;
            }
        }

        if (e.getActionCommand().equals("+")) {
            op = 1;
            opSet = true;
            display = "";
            result += tmp;
        }

        if (e.getActionCommand().equals("-")) {
            op = 2;
            opSet = true;
            display = "";
            result += tmp;
        }

        if (e.getActionCommand().equals("*")) {
            result += tmp;
            op = 3;
            opSet = true;
            display = "";
        }

        if (e.getActionCommand().equals("/")) {
            result += tmp;
            op = 4;
            opSet = true;
            display = "";
        }

        if (e.getActionCommand().equals("=")) {
            if (opSet)
                operation(op);

            resultString = "" + result;

            screenText.setText(resultString);
        }
    }

    private void operation(int op) {

        switch (op) {
            case 1: result += tmp;
                tmp = 0;
                opSet = false;
                break;
            case 2: result -= tmp;
                tmp = 0;
                opSet = false;
                break;
            case 3: result *= tmp;
                tmp = 0;
                opSet = false;
                break;
            case 4: result /= tmp;
                tmp = 0;
                opSet = false;
                break;
        }
    }
}