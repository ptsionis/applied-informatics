import java.util.ArrayList;

public class State {
	
	private double value;
	private ArrayList<String> sequence = new ArrayList<>();
	
	public State(double value, ArrayList<String> oldSequence, String newOperation) {
		this.value = value;
		this.sequence.addAll(oldSequence);
		this.sequence.add(newOperation);
	}
	
	public double getValue() {
		return value;
	}
	
	public ArrayList<String> getSequence() {
		return sequence;
	}

}
