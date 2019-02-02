package no.hvl.dat109;

import java.util.ArrayList;

public class TerningSett {
	//Objektvariabler
	private ArrayList<Terning> terningSett;
	private int antallTerninger;
	
	/**
	 * Konstruktor
	 */
	public TerningSett() {
		terningSett = new ArrayList<Terning>();
		antallTerninger = 0;
	}
	
	public TerningSett(int antallTerninger) {
		terningSett = new ArrayList<Terning>();
		for (int i = 0; i < antallTerninger; i++) {
			terningSett.add(new Terning());
		}
		
		this.antallTerninger = antallTerninger;
		
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
		antallTerninger ++;
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

	public int getAntallTerninger() {
		return antallTerninger;
	}

	public void setAntallTerninger(int antallTerninger) {
		this.antallTerninger = antallTerninger;
	}
	
	

}
