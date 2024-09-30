package bbom.solution;

import javax.swing.SwingUtilities;

public class MyApp {
    public static void main(String[] args) throws Exception {
        final Model model = new Model(0);
        final Controller controller = new Controller(model);

        // I've decided to split the two jobs (GUI and output to console) in order to
        // exploit the ability of adding as many views as needed on the same model
        final SwingView swingView = new SwingView(model, controller);
        new SdtOutView(model);

        SwingUtilities.invokeAndWait(() -> {
            swingView.setVisible(true);
        });
    }

}
