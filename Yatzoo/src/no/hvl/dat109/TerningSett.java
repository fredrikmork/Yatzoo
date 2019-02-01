package no.hvl.dat109;

import java.util.ArrayList;

public class TerningSett {
	//Objektvariabler
	private ArrayList<Terning> terningSett;
	
	/**
	 * Konstruktor
	 */
	public TerningSett() {
		terningSett = new ArrayList<Terning>();
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
	 * @param TerningSett, det terningssettet som skal trilles
	 * @return Returnerer et terningsSett med terninger som ble trilt
	 */
	public TerningSett trillTerninger(TerningSett terningSett){
		TerningSett etterTrill = new TerningSett();
		for(Terning t: terningSett.getTerningSett()) {
			t.resultat();
			etterTrill.leggTilTerning(t);
		}
		return etterTrill;
	}
	
	public void leggTilTerning(Terning terning) {
		terningSett.add(terning);
	}
	
	public ArrayList<Terning> getTerningSett() {
		return terningSett;
	}

	public void setTerningSett(ArrayList<Terning> terningSett) {
		this.terningSett = terningSett;
	}
	
	public String toString() {
		String toString = "";
		int index = 1;
		for(Terning t: terningSett) {
			toString += index + ": " + t.getDyr() + " ";
			index++;
		}
		return toString;
		
	}
	

}
