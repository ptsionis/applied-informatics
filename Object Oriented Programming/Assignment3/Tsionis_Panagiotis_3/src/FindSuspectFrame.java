import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FindSuspectFrame extends JFrame {
	
	//Creation of frame components
	private JPanel panel;
	private JTextField textField;
	private JButton findButton;
	private Registry registry;
	
	public FindSuspectFrame(Registry aRegistry) {
		panel = new JPanel();
		textField = new JTextField("Enter suspect's name", 20);
		findButton = new JButton("Find");
		registry = aRegistry;
		
		//Adding the text field and button to the panel
		panel.add(textField);
		panel.add(findButton);
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		findButton.addActionListener(listener);
		
		this.setVisible(true);
		this.setTitle("Find Suspect");
		this.setSize(400,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		//This code is executed when the find button is pressed
		public void actionPerformed(ActionEvent e) {
			String name = textField.getText();
			ArrayList<Suspect> tempSus = registry.getSuspects();
			boolean found = false;
			for (Suspect suspect : tempSus) {
				//If the suspect in the text field is found, a new suspect page window opens and this frame is terminated
				if (suspect.getName().equals(name)) {
					found = true;
					new SuspectPageFrame(registry, suspect);
					dispose();
				}
			}
			//If the suspect in the text field is not found, this message pops up
			if(!found) {
				JOptionPane.showMessageDialog(null, "Suspect " + name + " Not Found");
			}
		}
		
	}
	
}