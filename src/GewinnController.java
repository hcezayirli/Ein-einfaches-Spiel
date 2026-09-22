public class GewinnController {

    private GewinnModel model;

    public GewinnController(GewinnModel model) {
        this.model = model;
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

    public int getGesamtPunkte() {
        return model.getGesamtPunkte();
    }

    public int getComputerZahl() {
        return model.getComputerZahl();
    }

    public int getRundenErgebnis() {
        return model.getRundenErgebnis();
    }

    public boolean hatGewonnen() {
        return model.hatGewonnen();
    }

    public boolean hatVerloren() {
        return model.hatVerloren();
    }
}