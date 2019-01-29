package no.hvl.dat109;

import java.util.ArrayList;

public class TerningSett {
	//Objektvariabler
	ArrayList<Terning> terningSett;
	YatzooSpillet spillet;
	
	//Konstruktør
	public TerningSett(YatzooSpillet spillet) {
		this.spillet = spillet;
		terningSett = new ArrayList<Terning>();
	}

}
