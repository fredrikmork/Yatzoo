package no.hvl.dat109;

import java.util.ArrayList;

public class Spiller {
	
	private String navn;
	private TerningSett behold;
	private int antallBehold;
	
	

	public Spiller() {
		this.navn = "";
		this.behold = new TerningSett();
	}

	public Spiller(String navn) {
		this.navn = navn;
		this.behold = new TerningSett(5);
	}
	
	public void trill(TerningSett terninger) {
		int index = 0;
		TerningSett trilletSett = new TerningSett(terninger.getTerningSett().size());
		Terning terning = null;
		for(Terning t: terninger.getTerningSett()) {
			t.resultat();
			index = terninger.getTerningSett().indexOf(t);
			terning = terninger.getTerningSett().get(index);
			TerningSett.getTerningSett().add(terning);
		}
		this.behold = trilletSett;
		
	}

	public String getNavn() {
		return navn;
	}


	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public int getAntallBehold() {
		return antallBehold;
	}
	
	public void setAntallBehold(int antallBehold) {
		this.antallBehold = antallBehold;
	}
	
	public void setBehold(TerningSett behold) {
		this.behold = behold;
	}

}
