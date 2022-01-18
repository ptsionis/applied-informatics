import java.util.ArrayList;

public class Registry {
	
	private ArrayList<Communication> communications = new ArrayList<>();
	private ArrayList<Suspect> suspects = new ArrayList<>();
	
	public void addSuspect(Suspect aSuspect) {
		suspects.add(aSuspect);
	}
	
	//Adds a communication and finds which suspects own the numbers that were used, then makes them partners
	public void addCommunication(Communication aCommunication) {
		communications.add(aCommunication);
		
		Suspect suspect1 = null;
		Suspect suspect2 = null;
		for (Suspect temp_suspect : suspects) {
			if (temp_suspect.getNumbers().contains(aCommunication.getNumber1())) {
				suspect1 = temp_suspect;
			}
		}
		for (Suspect temp_suspect : suspects) {
			if (temp_suspect.getNumbers().contains(aCommunication.getNumber2())) {
				suspect2 = temp_suspect;
			}
		}
		suspect1.addPartner(suspect2);
	}
	
	//Returns the suspect which has the most partners
	public Suspect getSuspectWithMostPartners() {
		Suspect suspectWithMostPartners = suspects.get(0);
		int partners_size = suspectWithMostPartners.getPartners().size();
		
		for (int i=1; i<suspects.size(); i++) {
			/*In case there are more than one suspects with most connections, they last one of them in the list is returned (because of >= in the condition,
			 > would return the first of them)*/
			if (suspects.get(i).getPartners().size() >= partners_size) {
				suspectWithMostPartners = suspects.get(i);
				partners_size = suspects.get(i).getPartners().size();
			}
		}
		
		return suspectWithMostPartners;
	}
	
	//Checks all communications and finds the phone call that had the longest duration (SMS have 0 duration)
	public PhoneCall getLongestPhoneCallBetween(String number1, String number2) {
	    PhoneCall longestCall = null;
	    int longestCallDuration = 0;
		for (Communication temp_call : communications) {
		    if (temp_call.getNumber1().equals(number1) && temp_call.getNumber2().equals(number2)) {
		        if (temp_call.getDuration() > longestCallDuration)
		        	//Casts the Communication object to a PhoneCall object since Main file cannot be changed
		        	longestCall = (PhoneCall)temp_call;
		        longestCallDuration = temp_call.getDuration();
		    }
		}
		return longestCall;
	}
	
	//Checks all communications and returns a list with sms that include any of the specified key-words (Phone calls have null text)
	public ArrayList<SMS> getMessagesBetween(String number1, String number2) {
	    ArrayList<SMS> potentialSms = new ArrayList<>();
		for (Communication temp_sms : communications) {
		    if (temp_sms.getNumber1().equals(number1) && temp_sms.getNumber2().equals(number2)) {
		        if (temp_sms.getText().contains("Bomb") || temp_sms.getText().contains("Attack") ||
		        	temp_sms.getText().contains("Explosives") || temp_sms.getText().contains("Gun"))
		        	//Casts the Communication object to a SMS object since Main file cannot be changed
		        	potentialSms.add((SMS)temp_sms);
		    }
		}
		return potentialSms;
	}

}