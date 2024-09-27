package bbom;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MyApp extends JFrame  implements ActionListener {

	private int state;
	
	public MyApp() {		
		super("My BBoM App");

		state = 0;
		
		setSize(300, 70);
		setResizable(false);
		
		JButton button = new JButton("Update");
		button.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.add(button);		
		
		setLayout(new BorderLayout());
	    add(panel,BorderLayout.NORTH);
	    	    		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				System.exit(-1);
			}
		});
		log("State value: " + state);
	}

	public void actionPerformed(ActionEvent ev) {
		state++;
		/* THIS IS THE OUTPUT */
		log("State value: " + state);
	}	
	
	private void log(String msg) {
		System.out.println("[Output] " + msg);
	}

    static public void main(String[] args) throws Exception {			  
    	MyApp app = new MyApp();
		SwingUtilities.invokeAndWait(() -> {
			app.setVisible(true);
		});
	}	
}
