import java.util.ArrayList;

public class Suspect implements Comparable<Suspect> {
	
	private String name;
	private String codeName;
	private String city;
	private ArrayList<String> numbers = new ArrayList<>();
	private ArrayList<Suspect> partners = new ArrayList<>();
	
	public Suspect(String name, String codeName, String city) {
		this.name = name;
		this.codeName = codeName;
		this.city = city;
	}
	
	public String getName() {
		return name;
	}

	public String getCodeName() {
		return codeName;
	}
	
	public ArrayList<String> getNumbers() {
		return numbers;
	}
	
	public ArrayList<Suspect> getPartners() {
		return partners;
	}
	
	public void addNumber(String new_number) {
		numbers.add(new_number);
	}
	
	//Checks if the current object is already partners with the object in the parameter, and if not, it connects them
	public void addPartner(Suspect aPartner) {
		if (!isConnectedTo(aPartner)) {
			partners.add(aPartner);
			aPartner.addPartner(this);
		}
	}
	
	//Checks if the object is connected with an other suspect
	public boolean isConnectedTo(Suspect aSuspect) {
		return partners.contains(aSuspect);
	}
	
	//Returns a list with all the common partners this object and the object in the parameter have
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect) {
		ArrayList<Suspect> temp_list = new ArrayList<>();
		temp_list = partners;
		temp_list.retainAll(aSuspect.getPartners());
		
		return temp_list;
	}
	
	public void printPartners() {
		for (Suspect suspect : partners) {
			System.out.println(suspect.getName() + ", " + suspect.getCodeName());
		}
	}
	
	public ArrayList<Suspect> getSuggestedSuspects() {
	    ArrayList <Suspect> suggestedSuspects = new ArrayList<>();
	    for (Suspect tempPartner : partners) {
            for (Suspect tempSuspect : tempPartner.getPartners()) {
                if (!tempSuspect.equals(this) && !suggestedSuspects.contains(tempSuspect) && !partners.contains(tempSuspect)) {
                    suggestedSuspects.add(tempSuspect);
                }
            }
        }
        
        return suggestedSuspects;
	}

	@Override
	public int compareTo(Suspect o) {
		return this.getName().compareTo(o.getName());
	}

}