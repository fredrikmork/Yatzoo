package no.hvl.dat109;

import java.util.ArrayList;

public class Spiller {
	
	private String navn;
	private TerningSett behold;
	
	
	/**
	 * standar konstruktor
	 */
	public Spiller() {
		this.navn = "";
		this.behold = new TerningSett();
	}
	/**
	 * konstruktor med parameter
	 * @param navn String navnet paa spilleren
	 */
	public Spiller(String navn) {
		this.navn = navn;
		this.behold = new TerningSett();
	}
	/**
	 * triller alle terningene i et terningssett, får hvor mange terninger det er i terningssettet fra 
	 * Terningssettet som puttes inn som parameter
	 * @param terninger, datatype: TerningsSett 
	 */
	public void trill(TerningSett terninger) {
		int index = 0;
		TerningSett trilletSett = new TerningSett(terninger.getTerningSett().size());
		Terning terning = null;
		for(Terning t: terninger.getTerningSett()) {
			t.resultat();
			index = terninger.getTerningSett().indexOf(t);
			terning = terninger.getTerningSett().get(index);
			terninger.getTerningSett().add(terning);
		}
		this.behold = trilletSett;
		
	}

	/**
	 * get metode for spillernavn
	 * @return String navnet paa spiller
	 */
	public String getNavn() {
		return navn;
	}

	/**
	 * set metode for spillernavn
	 * @param navn String navnet paa spilleren
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	/**
	 * setter terninger som skal beholdes
	 * @param behold TerningsSett terninger
	 */
	public void setBehold(TerningSett behold) {
		this.behold = behold;
	}
	
	/**
	 * get metode for TerningsSettet behold
	 * @return TerningsSett som er beholdt
	 */
	public TerningSett getBehold() {
		return behold;
	}
	
	

	

}
