import javax.swing.*;
import java.awt.*;

public class GewinnView extends JFrame {

    // Elemente für die Anzeige der Ergebnisse
    private JLabel rundenErgebnisLabel;
    private JLabel gesamtPunkteLabel;

    // Eingabefeld des Spielers und Anzeige der Computerzahl
    private JTextField spielerFeld;
    private JTextField computerFeld;

    private JButton nochmalButton;

    public GewinnView() {

        // Grundeinstellungen des Fensters
        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);

        // Oberer Bereich: Rundenergebnis und Gesamtpunkte
        JPanel oben = new JPanel(new GridLayout(2, 2, 5, 5));

        JLabel rundenTitel =
                new JLabel("Rundenergebnis:", SwingConstants.CENTER);
        JLabel punkteTitel =
                new JLabel("Gesamtpunkte:", SwingConstants.CENTER);

        rundenErgebnisLabel =
                new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);

        gesamtPunkteLabel =
                new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);

        // Opaque ist notwendig, damit die Hintergrundfarbe sichtbar ist
        rundenErgebnisLabel.setOpaque(true);
        gesamtPunkteLabel.setOpaque(true);

        rundenErgebnisLabel.setBackground(Color.WHITE);
        gesamtPunkteLabel.setBackground(Color.WHITE);

        oben.add(rundenTitel);
        oben.add(punkteTitel);
        oben.add(rundenErgebnisLabel);
        oben.add(gesamtPunkteLabel);

        // Mittlerer Bereich: Spielerzahl und Computerzahl
        JPanel mitte = new JPanel(new GridLayout(2, 2, 10, 5));

        JLabel spielerTitel =
                new JLabel("Deine Zahl:", SwingConstants.CENTER);

        JLabel computerTitel =
                new JLabel("Computer:", SwingConstants.CENTER);

        spielerFeld = new JTextField();
        computerFeld = new JTextField();

        spielerFeld.setHorizontalAlignment(JTextField.CENTER);
        computerFeld.setHorizontalAlignment(JTextField.CENTER);

        // Die Computerzahl darf vom Benutzer nicht verändert werden
        computerFeld.setEditable(false);

        mitte.add(spielerTitel);
        mitte.add(computerTitel);
        mitte.add(spielerFeld);
        mitte.add(computerFeld);

        // Unterer Bereich mit dem Button für die nächste Runde
        JPanel unten = new JPanel();

        nochmalButton = new JButton("Noch einmal!");

        // Zu Beginn wurde noch keine Runde gespielt
        nochmalButton.setEnabled(false);

        unten.add(nochmalButton);

        // Die drei Bereiche werden im Hauptfenster angeordnet
        setLayout(new BorderLayout(10, 10));
        add(oben, BorderLayout.NORTH);
        add(mitte, BorderLayout.CENTER);
        add(unten, BorderLayout.SOUTH);
    }

    // Getter, damit der Controller auf die GUI-Elemente zugreifen kann
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