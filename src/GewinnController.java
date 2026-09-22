public class GewinnController {

    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        view.getSpielerFeld().addActionListener(e -> rundeSpielen());
    }

    private void rundeSpielen() {

        String eingabe = view.getSpielerFeld().getText();

        if (!spieleRunde(eingabe)) {
            view.getRundenErgebnisLabel().setText("Ungültige Eingabe");
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
}