package bbom.solution;

public class Controller {

    private final Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void update() {
        model.update();
    }
}
