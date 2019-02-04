package no.hvl.dat109;

import java.util.ArrayList;

public class RegelBok {

	private TerningSett terningene;

	/**
	 * Poeng for et gitt dyr.
	 * @param TerningSett terningene, String dyr
	 * @return sum av antall dyr i terningkastet
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
	 * Finner n-like av terningkast.
	 * @param Terningsett terningene, int n, for 3,4 og 5 like.
	 * @return hvilket dyr som har n-like.
	 */
	public String nLike(TerningSett terningene, int n) {
		ArrayList<Terning> terningListe = terningene.getTerningSett();
		String dyr = "";
		for (int i = 0; i < terningListe.size(); i++) {
			int sum = 0;
			for (int j = i + 1; j < terningListe.size(); j++) {
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

	/**
	 * Sjekker terningsett listen om det er to par der, printer ut de parene
	 * @param TerningSett terningene
	 * @return 
	 */
	public String toPar(TerningSett terningene) {
		String parDyr = "";
		String dyr1 = terningene.getTerningSett().stream().filter(x -> x.);
		
		
		return parDyr;
	}

	/**
	 * Et par og 3 like i et terningsett
	 * @param TerningSett terningene.
	 * @return dyrene det gjelder for
	 */
	public int hus(TerningSett terningene) {
		int sum = 0;

		return sum;
	}

	/**
	 * Finner ut om alle terningene er unike.
	 * @param TerningSett terningene
	 * @return 1 poeng dersom det stemmer
	 */
	public int enAvHver(TerningSett terningene) {
		int sum = 0;
		long unike = terningene.getTerningSett()
				.stream()
				.distinct()
				.count();
		if (unike == 6) {
			sum = 1;
		}
		return sum;
	}

}
