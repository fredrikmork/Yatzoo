package no.hvl.dat109;

import java.util.ArrayList;

public class RegelBok {

	private TerningSett terningene;

	/**
	 * 
	 * @param TerningSett terningene og String navnet paa dyret
	 * 
	 * @return sum av antall dyr i kastet
	 */
	public int dyr(TerningSett terningene, String dyr) {
		int sum = 0;
		for (Terning t : terningene.getTerningSett()) {
			if (t.getDyr().equals(dyr)) {
				sum += 1;
			}
		}
		return sum;
	}

	/**
	 * 
	 * @param TerningsSett: terningene
	 * @param int n antall like terninger
	 * @return String, hvilket dyr som har n-like
	 */
	public String nLike(TerningSett terningene, int n) {
		ArrayList<Terning> terningListe = terningene.getTerningSett();
		String dyr = "";
		for(int i=0; i< terningListe.size(); i++) {
			int sum = 0;
			for(int j = i + 1; j < terningListe.size(); j++) {
				if (terningListe.listIterator(i).equals(terningListe.listIterator(j))) {
					sum += 1;
					if (sum == n) {
						dyr = terningListe.listIterator(i).toString();
					}
				}
			}
		}
		return dyr;
	}

	public int fireLike(TerningSett terningene) {
		int sum = 0;

		return sum;
	}

	public int toPar(TerningSett terningene) {
		int sum = 0;

		return sum;
	}

	public int hus(TerningSett terningene) {
		int sum = 0;

		return sum;
	}

	public int enAvHver(TerningSett terningene) {
		int sum = 0;

		return sum;
	}

	public int femLike(TerningSett terningene) {
		int sum = 0;

		return sum;
	}

	public TerningSett getTerningene() {
		return terningene;
	}

	public void setTerningene(TerningSett terningene) {
		this.terningene = terningene;
	}
	
	
	
}
