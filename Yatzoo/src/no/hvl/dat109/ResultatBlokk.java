package no.hvl.dat109;

import java.util.Arrays;

/**
 * @author Perminow
 *
 */
public class ResultatBlokk {

	private int[][] resultatTabell;
	
	public ResultatBlokk() {
		resultatTabell = new int[5][13];
	}
	/**
	 * gaar igjennom resultatTabellen og summerer totalpoengene for hver spiller 
	 * og putter dem nederst i tabellen slik at man kan se hvor mye poeng hver spiller har faatt.¨
	 * brukes videre til aa finne vinner i finnVinner metoden i YatzooSpillet.
	 */
	public void totalResultat() {
		int sum = 0;
		for (int row = 0; row < resultatTabell.length; row++) {
			sum = 0;
			for (int col = 0; col < resultatTabell[row].length; col++) {
				sum += resultatTabell[row][col];
			}
			resultatTabell[row][12]=sum;
		}
	}

	/**
	 * legger til et runde resultat i resultatblokkens tabell over alle resultat
	 */
	public void leggTilSpiller(int spiller) {
		resultatTabell[spiller][0] = spiller;
	}
	/**
	 * legger til et resultat fra en runde inn i resultatTabellen.
	 * @param spiller, int spiller. indexen til spilleren som faar poeng
	 * @param runde, int runde hvilke runde det gjelder
	 * @param res, int res: resultatet som spilleren skal ha paa gitt runde.
	 */
	public void leggTilRundeRes(int spiller, int runde, int res) {
		resultatTabell[spiller][runde] = res;
	}

	public int[][] getResultatTabell() {
		return resultatTabell;
	}

	public void setResultatTabell(int[][] resultatTabell) {
		this.resultatTabell = resultatTabell;
	}
	/**
	 * toString metode som omgjør en spesifikk rad i tabellen
	 * til en string med en 
	 * en oversiktlig form for aa vise resultater.
	 * @param runde hvilke runde som det gjelder
	 * @return String, den stringen som blir skapt av metoden.
	 */
	public String toString(int runde) {
		String tilString = "";
		for (int row = 0; row < resultatTabell.length; row++) {
			tilString += "\t\t" + resultatTabell[row][runde-1] + "\t";
		}
		return tilString;
	}

}
