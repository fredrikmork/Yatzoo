package no.hvl.dat109;

import java.util.ArrayList;

public class RegelBok {

	private TerningSett terningene;

	/**
<<<<<<< HEAD
	 * Poeng for et gitt dyr.
	 * @param TerningSett terningene, String dyr
	 * @return sum av antall dyr i terningkastet
=======
	 * 
	 * @param TerningSett terningene og String navnet paa dyret
	 * 
	 * @return sum av antall dyr i kastet
>>>>>>> 61ffd067d3297d6b3926de731cba0964bc42aef0
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
<<<<<<< HEAD
	 * Finner n-like av terningkast.
	 * @param Terningsett terningene, int n, for 3,4 og 5 like.
	 * @return hvilket dyr som har n-like.
=======
	 * 
	 * @param TerningsSett: terningene
	 * @param int n antall like terninger
	 * @return String, hvilket dyr som har n-like
>>>>>>> 61ffd067d3297d6b3926de731cba0964bc42aef0
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
		//TODO
		return "";
	}

	/**
	 * Et par og 3 like i et terningsett
	 * @param TerningSett terningene.
	 * @return dyrene det gjelder for
	 */
	public int hus(TerningSett terningene) {
//		int sum = 0;
//		ArrayList<Terning> terninger= terningene.getTerningSett();
//		
//		for(int i = 0; i < terningene.getAntallTerninger()-1; i++ ) { // dices is your integer array
//			   switch( terninger.get(i) ) {
//			      case 1: terninger.get(1) += 1; break;
//			      // all other cases up to 6
//			    }
//			 }
//		boolean trelike = false;
//		boolean tolike = false;
//		for (int i = 0; i < terningene.getAntallTerninger() - 1 && (!tolike || !trelike); i++) {
//			if(!trelike && terninger.get(i) == 3) {
//		          trelike = true; 
//		       } else if(!tolike && terninger.get(i) == 2) {
//		          tolike = true;
//		       }
//		}
//		
//		if(trelike && tolike) {
//			sum = 1;
//		}
//		return sum;
		for (int i = 0; i < terningene.getAntallTerninger()-1; i++) {
			ArrayList<Terning> terninger = terningene.getTerningSett();
			switch (terningene.getAntallTerninger()) {
			
			case terninger.indexOf():
				
				break;
			
			default:
				break;
			}
		}
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
