public class Main {

    public static void main(String[] args) {

        // Model und View erstellen
        GewinnModel model = new GewinnModel();
        GewinnView view = new GewinnView();

        // Controller verbindet Model und View miteinander
        new GewinnController(model, view);

        // Benutzeroberfläche anzeigen
        view.setVisible(true);
    }
}