import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SuspectPageFrame extends JFrame {
	
	//Creation of frame components
	private Registry registry;
	private Suspect suspect;
	private JPanel mainPanel, suspectPanel, smsPanel, partnersPanel, suggestedPanel, backPanel;
	private JTextField nameField, codeNameField, phoneField;
	private JTextArea phonesArea, smsArea, partnersArea, suggestedArea;
	private JButton smsButton, backButton;
	private JLabel partnersLabel, suggestedLabel;
	
	public SuspectPageFrame(Registry registry, Suspect suspect) {
		this.registry = registry;
		this.suspect = suspect;
		ButtonListener listener = new ButtonListener();
		
		//Creation of main panels, in to which will be added the other panels
		mainPanel = new JPanel();
		GridLayout mainLayout = new GridLayout(5, 1);
		mainLayout.setVgap(30);
		mainPanel.setLayout(mainLayout);
		
		//Creation of suspect panel
		suspectPanel = new JPanel();
		nameField = new JTextField(suspect.getName(), 10);
		codeNameField = new JTextField(suspect.getCodeName(), 10);
		phonesArea = new JTextArea(5, 10);
		for (String number : suspect.getNumbers()) {
			phonesArea.append(number + "\n");
		}
		suspectPanel.add(nameField);
		suspectPanel.add(codeNameField);
		suspectPanel.add(phonesArea);
		
		//Creation of sms panel
		smsPanel = new JPanel();
		phoneField = new JTextField(10);
		smsArea = new JTextArea(10, 15);
		smsButton = new JButton("Find SMS");
		smsButton.addActionListener(listener);
		smsPanel.add(phoneField);
		smsPanel.add(smsArea);
		smsPanel.add(smsButton);
		
		//Creation of partners panel
		partnersPanel = new JPanel();
		partnersLabel = new JLabel("Partners");
		partnersArea = new JTextArea(10, 15);
		ArrayList<Suspect> partners = new ArrayList<>();
		partners = suspect.getPartners();
		Collections.sort(partners);
		for (Suspect partner : partners) {
			partnersArea.append(partner.getName() + ", " + partner.getCodeName() + "\n");
		}
		partnersPanel.add(partnersLabel);
		partnersPanel.add(partnersArea);
		
		//Creation of suggested panel
		suggestedPanel = new JPanel();
		suggestedLabel = new JLabel("Suggested Partners ----->");
		suggestedArea = new JTextArea(10, 15);
		ArrayList<Suspect> suggested = new ArrayList<>();
		suggested = suspect.getSuggestedSuspects();
		Collections.sort(suggested);
		for (Suspect partner : suggested) {
			suggestedArea.append(partner.getName() + ", " + partner.getCodeName() + "\n");
		}
		suggestedPanel.add(suggestedLabel);
		suggestedPanel.add(suggestedArea);
		
		//Creation of back button panel
		backPanel = new JPanel();
		backButton = new JButton("Back to Search Screen");
		backButton.addActionListener(listener);
		backPanel.add(backButton);
		
		//Add all panels to the main panel
		mainPanel.add(suspectPanel);
		mainPanel.add(smsPanel);
		mainPanel.add(partnersPanel);
		mainPanel.add(suggestedPanel);
		mainPanel.add(backPanel);
		
		this.setContentPane(mainPanel);
		
		this.setVisible(true);
		this.setSize(600,700);
		this.setTitle("Suspect Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//This code is executed when the back to search button is pressed
			if (e.getSource()==backButton) {
				new FindSuspectFrame(registry);
				dispose();
			}
			//This code is executed when the find sms button is pressed
			else {
				String phone = phoneField.getText();
				ArrayList<String> suspectPhones = new ArrayList<>();
				ArrayList<SMS> sms = new ArrayList<>();
				suspectPhones = suspect.getNumbers();
				for (String tempNumber : suspectPhones) {
					sms = registry.getMessagesBetween(tempNumber, phone);
					for (SMS message : sms) {
						smsArea.append(message.getText() + "\n");
					}
				}
			}
		}
		
	}

}