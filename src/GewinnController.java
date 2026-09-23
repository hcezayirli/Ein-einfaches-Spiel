import java.awt.Color;

public class GewinnController {

    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        // Enter im Eingabefeld startet eine neue Runde
        view.getSpielerFeld().addActionListener(e -> rundeSpielen());

        // Der Button bereitet die Oberfläche für die nächste Runde vor
        view.getNochmalButton().addActionListener(e -> nochmalSpielen());
    }

    private void rundeSpielen() {

        // Nach Gewinn oder Verlust darf keine weitere Runde gespielt werden
        if (model.hatGewonnen() || model.hatVerloren()) {
            return;
        }

        String eingabe = view.getSpielerFeld().getText();

        // Ungültige Eingaben werden abgefangen und verursachen keinen Absturz
        if (!spieleRunde(eingabe)) {
            view.getRundenErgebnisLabel().setText("Ungültige Eingabe");
            setzeLabelFarbe(Color.WHITE);
            return;
        }

        // Die vom Model erzeugte Computerzahl wird angezeigt
        view.getComputerFeld().setText(
                String.valueOf(model.getComputerZahl())
        );

        // Ergebnis der Runde bzw. Spielende anzeigen
        if (model.hatGewonnen()) {
            view.getRundenErgebnisLabel().setText("Gewonnen");
        } else if (model.hatVerloren()) {
            view.getRundenErgebnisLabel().setText("Verloren");
        } else {
            int ergebnis = model.getRundenErgebnis();

            if (ergebnis > 0) {
                view.getRundenErgebnisLabel().setText("+" + ergebnis);
            } else {
                view.getRundenErgebnisLabel().setText(
                        String.valueOf(ergebnis)
                );
            }
        }

        // Aktuellen Gesamtpunktestand anzeigen
        view.getGesamtPunkteLabel().setText(
                String.valueOf(model.getGesamtPunkte())
        );

        // Nach einer Runde wird die Eingabe gesperrt
        view.getSpielerFeld().setEditable(false);

        // Bei Spielende bleibt der "Noch einmal!"-Button deaktiviert
        if (model.hatGewonnen() || model.hatVerloren()) {
            view.getNochmalButton().setEnabled(false);
        } else {
            view.getNochmalButton().setEnabled(true);
        }

        // Positive Ergebnisse werden grün, negative rot dargestellt
        if (model.getRundenErgebnis() > 0 || model.hatGewonnen()) {
            setzeLabelFarbe(Color.GREEN);
        } else if (model.getRundenErgebnis() < 0 || model.hatVerloren()) {
            setzeLabelFarbe(Color.RED);
        } else {
            setzeLabelFarbe(Color.WHITE);
        }
    }

    private void nochmalSpielen() {

        // Eingaben der letzten Runde löschen
        view.getSpielerFeld().setText("");
        view.getComputerFeld().setText("");
        view.getRundenErgebnisLabel().setText("Tippe eine Zahl von 1 bis 9");

        // Eingabefeld wieder freigeben und Button deaktivieren
        view.getSpielerFeld().setEditable(true);
        view.getNochmalButton().setEnabled(false);

        // Farben für die neue Runde zurücksetzen
        setzeLabelFarbe(Color.WHITE);

        // Cursor wieder in das Eingabefeld setzen
        view.getSpielerFeld().requestFocus();
    }

    public boolean spieleRunde(String eingabe) {

        // Null-Werte dürfen keinen Fehler verursachen
        if (eingabe == null) {
            return false;
        }

        try {
            // Texteingabe in eine ganze Zahl umwandeln
            int zahl = Integer.parseInt(eingabe.trim());

            // Nur Zahlen von 1 bis 9 sind erlaubt
            if (zahl < 1 || zahl > 9) {
                return false;
            }

            // Gültige Zahl an das Model weitergeben
            model.berechneRunde(zahl);
            return true;

        } catch (NumberFormatException e) {
            // Zum Beispiel bei "abc" statt einer Zahl
            return false;
        }
    }

    // Hilfsmethode vermeidet doppelte Farblogik
    private void setzeLabelFarbe(Color farbe) {
        view.getRundenErgebnisLabel().setBackground(farbe);
        view.getGesamtPunkteLabel().setBackground(farbe);
    }
}