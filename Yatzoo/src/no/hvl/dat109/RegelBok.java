package no.hvl.dat109;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class RegelBok {

	private TerningSett terningene;

	public RegelBok() {

	}
	
	/**
	 * Poeng for et gitt dyr.
	 * 
	 * @param TerningSett
	 *            terningene, String dyr
	 * @return sum av antall dyr i terningkastet
	 * 
	 * @param TerningSett
	 *            terningene og String navnet paa dyret
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
	 * Finner n-like av terningkast.
	 * 
	 * @param Terningsett
	 *            terningene, int n, for 3,4 og 5 like.
	 * @return hvilket dyr som har n-like.
	 * 
	 * @param TerningsSett:
	 *            terningene
	 * @param int
	 *            n antall like terninger
	 * @return boolean, om det stemmer for terningkastet
	 */
	public boolean nLike(TerningSett terningene, int n) {
		ArrayList<Terning> terningListe = terningene.getTerningSett();
		int antall = 0;
		String s = "";
		terningListe.sort(Comparator(new Comparator<Terning>() {

			@Override
			public int compare(Terning t1, Terning t2) {
				return t1.getDyr().compareTo(t2.getDyr());
			}

		}));
		
		for (int i = 0; i < terningListe.size(); i++) {
			if (!terningListe.get(i).getDyr().equals(s)) {
				s = terningListe.get(i).getDyr();
				antall = 1;
			}
			else{
				antall++;
			}
		
		}
		return (antall >= n);
	}

	private Comparator<? super Terning> Comparator(Comparator<Terning> comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Sjekker terningsett listen om det er to par der, printer ut de parene
	 * 
	 * @param TerningSett
	 *            terningene
	 * @return
	 */
	public boolean toPar(TerningSett terningene) {
		ArrayList<Terning> terninger = terningene.getTerningSett();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int i = 0;
		for (Terning terning : terninger) {
			i = map.getOrDefault(terning.getDyr(), 0);
			i++;
			map.put(terning.getDyr(), i);

		}
		int par = 0;
		int antallLike= 0;
		for (Terning terning : terninger) {
			antallLike = map.getOrDefault(terning.getDyr(),0);
			if(antallLike >= 2) {
				par++;
				System.out.println("par: " + par);
			}
			
		}
		
		return(par==2);
	}

	/**
	 * Et par og 3 like i et terningsett
	 * 
	 * @param TerningSett
	 *            terningene.
	 * @return dyrene det gjelder for
	 */
	public boolean hus(TerningSett terningene) {
		ArrayList<Terning> terninger = terningene.getTerningSett();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		boolean toLike = false;
		boolean treLike = false;
		boolean hus = false;
		int i = 0;
		for (Terning terning : terninger) {
			i = map.getOrDefault(terning.getDyr(), 0);
			i++;
			map.put(terning.getDyr(), i);

		}
		for (Terning terning : terninger) {
			int antallLike = map.getOrDefault(terning.getDyr(), 0);
			if (antallLike == 2) {
				toLike = true;
			} else if (antallLike == 3) {
				treLike = true;
			}
		}

		hus = treLike && toLike;
		return hus;
	}

	/**
	 * Finner ut om alle terningene er unike.
	 * 
	 * @param TerningSett
	 *            terningene
	 * @return 1 poeng dersom det stemmer
	 */
	public int enAvHver(TerningSett terningene) {
		int sum = 0;
		long unike = terningene.getTerningSett().stream().distinct().count();
		if (unike == 6) {
			sum = 1;
		}
		return sum;
	}

}
