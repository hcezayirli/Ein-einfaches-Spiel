public class GewinnModel {
   // Speichert alle wichtigen Werte des Spiels
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    // Jede neue Spielrunde startet mit insgesamt 30 Punkten
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

    // Erzeugt eine zufällige Zahl von 1 bis 9
    public void berechneComputerZahl() {
        computerZahl = (int) (Math.random() * 9) + 1;
    }


    // Berechnet eine Spielrunde und verändert den Punktestand
    public void berechneRunde(int spielerZahl) {

        // Ungültige Zahlen werden ignoriert
        if (spielerZahl < 1 || spielerZahl > 9) {
            return;
        }

        this.spielerZahl = spielerZahl;

        // Für jede Runde wird eine neue Computerzahl erzeugt
        berechneComputerZahl();

        // Math.abs sorgt dafür, dass der Unterschied immer positiv ist
        int unterschied = Math.abs(spielerZahl - computerZahl);

        // Gleiche Zahl: +20, Unterschied 1: +5, sonst: -10
        if (unterschied == 0) {
            rundenErgebnis = 20;
        } else if (unterschied == 1) {
            rundenErgebnis = 5;
        } else {
            rundenErgebnis = -10;
        }
        // Ergebnis der Runde zum Gesamtpunktestand addieren
        gesamtPunkte += rundenErgebnis;
    }

    // Ab 100 Punkten ist das Spiel gewonnen
    public boolean hatGewonnen() {
        return gesamtPunkte >= 100;
    }

    // Bei 0 oder weniger Punkten ist das Spiel verloren
    public boolean hatVerloren() {
        return gesamtPunkte <= 0;
    }
}