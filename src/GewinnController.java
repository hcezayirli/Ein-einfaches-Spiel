import java.awt.Color;
public class GewinnController {

    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        view.getSpielerFeld().addActionListener(e -> rundeSpielen());
        view.getNochmalButton().addActionListener(e -> nochmalSpielen());
    }

    private void rundeSpielen() {
        if (model.hatGewonnen() || model.hatVerloren()) {
            return;
        }


        String eingabe = view.getSpielerFeld().getText();

        if (!spieleRunde(eingabe)) {
            view.getRundenErgebnisLabel().setText("Ungültige Eingabe");
            setzeLabelFarbe(Color.WHITE);
            return;
        }

        view.getComputerFeld().setText(
                String.valueOf(model.getComputerZahl())
        );

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

        view.getGesamtPunkteLabel().setText(
                String.valueOf(model.getGesamtPunkte())
        );
        view.getSpielerFeld().setEditable(false);

        if (model.hatGewonnen() || model.hatVerloren()) {
            view.getNochmalButton().setEnabled(false);
        } else {
            view.getNochmalButton().setEnabled(true);
        }
        if (model.getRundenErgebnis() > 0 || model.hatGewonnen()) {
            setzeLabelFarbe(Color.GREEN);
        } else if (model.getRundenErgebnis() < 0 || model.hatVerloren()) {
            setzeLabelFarbe(Color.RED);
        } else {
            setzeLabelFarbe(Color.WHITE);
        }
    }
    private void nochmalSpielen() {
        view.getSpielerFeld().setText("");
        view.getComputerFeld().setText("");
        view.getRundenErgebnisLabel().setText("Tippe eine Zahl von 1 bis 9");

        view.getSpielerFeld().setEditable(true);
        view.getNochmalButton().setEnabled(false);

        setzeLabelFarbe(Color.WHITE);
        view.getSpielerFeld().requestFocus();
    }

    public boolean spieleRunde(String eingabe) {

        if (eingabe == null) {
            return false;
        }

        try {
            int zahl = Integer.parseInt(eingabe.trim());

            if (zahl < 1 || zahl > 9) {
                return false;
            }

            model.berechneRunde(zahl);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void setzeLabelFarbe(Color farbe) {
        view.getRundenErgebnisLabel().setBackground(farbe);
        view.getGesamtPunkteLabel().setBackground(farbe);
    }
}