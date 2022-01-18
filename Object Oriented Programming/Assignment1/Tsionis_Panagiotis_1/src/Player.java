
public class Player {
	
	String name; //Αποθηκεύεται όνομα παίχτη ("Dealer", αν το αντικείμενο είναι ο dealer)
	int hand;
	int cash;
	
	//Κατασκευαστής για τον παίχτη
	public Player() {
		hand = 0;
		cash = 1000;
	}
	
	//Κατασκευαστής για τον dealer (η παράμετρος θα δέχεται την λέξη Dealer για name, από την main)
	public Player(String name) {
		hand = 0;
		this.name = name;
		cash = 99000;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	/*Μέθοδος που μηδενίζει το χέρι του αντικειμένου για τον νέο γύρο, και εμφανίζει και τα δύο χαρτιά αν το αντικέιμενο είναι ο παίχτης,
	ενώ εμφανίζει μόνο το πρώτο χαρτί αν το αντικείμενο είναι ο dealer*/
	public void initHand(int card1, int card2) {
		hand = 0;
		if (name=="Dealer") {
			System.out.println(name + "\n" + card1 + " | " + "?");
		}
		else {
			System.out.println(name + "\n" + card1 + " | " + card2 + "");
		}
		hand = hand + card1 + card2;
	}
	
	//Προσθέτει στο χέρι του αντικειμένου, την κάρτα που τράβηξε
	public void addHand(int card) {
		System.out.println("Card number: " + card);
		hand += card;
	}
	
	public int getHand() {
		return hand;
	}
	
	//Αφαιρεί το ποσό που πόνταρε το αντικείμενο, από τα συνολικά του μετρητά
	public void placeBet(int bet) {
		cash -= bet;
	}
	
	//Προσθέτει το ποντάρισμα στα συνολικά μετρητά του αντικειμένου
	public void winBet(int bet) {
		cash+= bet;
	}
	
	public int getCash() {
		return cash;
	}

}
