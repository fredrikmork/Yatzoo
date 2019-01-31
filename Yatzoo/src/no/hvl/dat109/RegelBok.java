package no.hvl.dat109;

public class RegelBok {

	private TerningSett terningene;

	/**
	 * 
	 * @param terningenbgere
	 *            som arraylist
	 * @return sum av antall løver i kastet
	 */
	public int love(TerningSett terningene) {
		int sum = 0;
		for (Terning t : terningene.getTerningSett()) {
			if (t.getDyr().equals("love")) {
				sum += 1;
			}
		}
		return sum;
	}

	/**
	 * 
	 * @param terningene
	 *            som arraylist
	 * @return sum av antall slanger i kastet
	 */
	public int slange(TerningSett terningene) {
		int sum = 0;
		for (Terning t : terningene.getTerningSett()) {
			if (t.getDyr().equals("slange")) {
				sum += 1;
			}
		}
		return sum;
	}

	/**
	 * 
	 * @param terningene
	 *            som arraylist
	 * @return sum av antall panda i kastet
	 */
	public int panda(TerningSett terningene) {
		int sum = 0;
		for (Terning t : terningene.getTerningSett()) {
			if (t.getDyr().equals("panda")) {
				sum += 1;
			}
		}
		return sum;
	}

	/**
	 * 
	 * @param terningene
	 *            som arraylist
	 * @return sum av antall gris i kastet
	 */
	public int gris(TerningSett terningene) {
		int sum = 0;
		for (Terning t : terningene.getTerningSett()) {
			if (t.getDyr().equals("gris")) {
				sum += 1;
			}
		}
		return sum;
	}

	/**
	 * 
	 * @param terningene
	 *            som arraylist
	 * @return sum av antall elefant i kastet
	 */
	public int elefant(TerningSett terningene) {
		int sum = 0;
		for (Terning t : terningene.getTerningSett()) {
			if (t.getDyr().equals("elefant")) {
				sum += 1;
			}
		}
		return sum;
	}

	/**
	 * 
	 * @param terningene
	 *            som arraylist
	 * @return sum av antall hvaler i kastet
	 */
	public int hval(TerningSett terningene) {
		int sum = 0;
		for (Terning t : terningene.getTerningSett()) {
			if (t.getDyr().equals("hval")) {
				sum += 1;
			}
		}
		return sum;
	}

	public int treLike(TerningSett terningene) {
		int sum = 0;

		return sum;
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
