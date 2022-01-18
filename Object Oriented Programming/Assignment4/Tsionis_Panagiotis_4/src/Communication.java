public abstract class Communication {
	
	protected String number1;
	protected String number2;
	protected int year;
	protected int month;
	protected int day;
	
	public Communication(String number1, String number2, int year, int month, int day) {
		this.number1 = number1;
		this.number2 = number2;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public void setNumber1(String number1) {
		this.number1 = number1;
	}
	
	public String getNumber1() {
		return number1;
	}
	
	public void setNumber2(String number2) {
		this.number2 = number2;
	}

	public String getNumber2() {
		return number2;
	}

	protected void printInfo() {
		System.out.println("Between " + number1 + " --- " + number2);
		System.out.println("on " + year + "/" + month + "/" + day);
	}
	
	public abstract int getDuration();
	public abstract String getText();

}