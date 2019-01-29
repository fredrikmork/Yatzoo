package no.hvl.dat109;

import java.util.ArrayList;

public class TerningSett {
	//Objektvariabler
	ArrayList<Terning> terningSett;
	
	//Konstruktør
	public TerningSett() {
		super();
	}
	
	public TerningSett(int antallTerninger) {
		terningSett = new ArrayList<Terning>();
		for (int i = 0; i < antallTerninger; i++) {
			terningSett.add(new Terning());
		}
		
	}
	
	//Metoder
	/**
	 * Triller antall terninger som er angitt
	 * @param Antall terninger som skal trilles, maks 5
	 * @return Returnerer en liste med terninger som ble trilt
	 */
	public ArrayList<Terning> trillTerninger(int antall){
		
		
		return null;
	}

}
