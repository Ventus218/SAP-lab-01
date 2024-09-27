package bbom.solution;

import javax.swing.SwingUtilities;

public class MyApp {
    public static void main(String[] args) throws Exception {
        final Model model = new Model(0);
        final Controller controller = new Controller(model);
        final SwingView swingView = new SwingView(model, controller);
        new SdtOutView(model);

        SwingUtilities.invokeAndWait(() -> {
            swingView.setVisible(true);
        });
    }

}
