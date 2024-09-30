package bbom.solution;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class SwingView extends JFrame implements ActionListener, ModelListener {

    private final Model model;
    private final Controller controller;

    // I've added a label to prove that the model is updating
    private final JLabel label;

    public SwingView(Model model, Controller controller) {
        super("My BBoM App");

        this.model = model;
        this.controller = controller;

        model.addListener(this);

        setSize(300, 70);
        setResizable(false);
        JButton button = new JButton("Update");
        button.addActionListener(this);

        label = new JLabel();

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(label);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(-1);
            }
        });

        updateView();
    }

    private void updateView() {
        label.setText("Value: " + model.getState());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.update();
    }

    @Override
    public void modelUpdated() {
        updateView();
    }

}
