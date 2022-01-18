public class SMS extends Communication {
	
	private String text;
	
	public SMS(String number1, String number2, int year, int month, int day, String text) {
		super(number1, number2, year, month, day);
		this.text = text;
	}
	
	public String getText() {
	    return text;
	}

	public void printInfo() {
		System.out.println("This SMS has the following info");
		super.printInfo();
		System.out.println("Text: " + text);
	}

	@Override
	public int getDuration() {
		return 0;
	}

}