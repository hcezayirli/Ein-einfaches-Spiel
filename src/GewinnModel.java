public class GewinnModel {

    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        gesamtPunkte = 30;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getSpielerZahl() {
        return spielerZahl;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    public void berechneComputerZahl() {
        computerZahl = (int) (Math.random() * 9) + 1;
    }

    public void berechneRunde(int spielerZahl) {

        // Ungültige Zahlen werden ignoriert
        if (spielerZahl < 1 || spielerZahl > 9) {
            return;
        }

        this.spielerZahl = spielerZahl;

        berechneComputerZahl();

        int unterschied = Math.abs(spielerZahl - computerZahl);

        if (unterschied == 0) {
            rundenErgebnis = 20;
        } else if (unterschied == 1) {
            rundenErgebnis = 5;
        } else {
            rundenErgebnis = -10;
        }

        gesamtPunkte += rundenErgebnis;
    }
}