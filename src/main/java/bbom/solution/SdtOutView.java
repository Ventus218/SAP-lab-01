package bbom.solution;

public class SdtOutView implements ModelListener {

    private final Model model;

    public SdtOutView(Model model) {
        this.model = model;

        model.addListener(this);
    }

    @Override
    public void modelUpdated() {
        System.out.println(model.getState());
    }

}
