import javax.swing.*;
import java.awt.*;

public class GewinnView extends JFrame {

    private JLabel rundenErgebnisLabel;
    private JLabel gesamtPunkteLabel;

    private JTextField spielerFeld;
    private JTextField computerFeld;

    private JButton nochmalButton;

    public GewinnView() {

        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);

        // Oberer Bereich
        JPanel oben = new JPanel(new GridLayout(2, 2, 5, 5));

        JLabel rundenTitel = new JLabel("Rundenergebnis:", SwingConstants.CENTER);
        JLabel punkteTitel = new JLabel("Gesamtpunkte:", SwingConstants.CENTER);

        rundenErgebnisLabel =
                new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);

        gesamtPunkteLabel =
                new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);

        rundenErgebnisLabel.setOpaque(true);
        gesamtPunkteLabel.setOpaque(true);

        rundenErgebnisLabel.setBackground(Color.WHITE);
        gesamtPunkteLabel.setBackground(Color.WHITE);

        oben.add(rundenTitel);
        oben.add(punkteTitel);
        oben.add(rundenErgebnisLabel);
        oben.add(gesamtPunkteLabel);

        // Mittlerer Bereich
        JPanel mitte = new JPanel(new GridLayout(2, 2, 10, 5));

        JLabel spielerTitel =
                new JLabel("Deine Zahl:", SwingConstants.CENTER);

        JLabel computerTitel =
                new JLabel("Computer:", SwingConstants.CENTER);

        spielerFeld = new JTextField();
        computerFeld = new JTextField();

        spielerFeld.setHorizontalAlignment(JTextField.CENTER);
        computerFeld.setHorizontalAlignment(JTextField.CENTER);

        computerFeld.setEditable(false);

        mitte.add(spielerTitel);
        mitte.add(computerTitel);
        mitte.add(spielerFeld);
        mitte.add(computerFeld);

        // Unterer Bereich
        JPanel unten = new JPanel();

        nochmalButton = new JButton("Noch einmal!");
        nochmalButton.setEnabled(false);

        unten.add(nochmalButton);

        // Alles ins Fenster
        setLayout(new BorderLayout(10, 10));

        add(oben, BorderLayout.NORTH);
        add(mitte, BorderLayout.CENTER);
        add(unten, BorderLayout.SOUTH);
    }

    public JTextField getSpielerFeld() {
        return spielerFeld;
    }

    public JTextField getComputerFeld() {
        return computerFeld;
    }

    public JLabel getRundenErgebnisLabel() {
        return rundenErgebnisLabel;
    }

    public JLabel getGesamtPunkteLabel() {
        return gesamtPunkteLabel;
    }

    public JButton getNochmalButton() {
        return nochmalButton;
    }
}