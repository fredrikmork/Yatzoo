package no.hvl.dat109;

import java.util.Arrays;

/**
 * @author Perminow
 *
 */
public class ResultatBlokk {

	private int[][] resultatTabell;

	public ResultatBlokk() {
		resultatTabell = new int[4][13];
	}

	/**
	 * legger til et runde resultat i resultatblokkens tabell over alle resultat
	 */
	public void leggTilSpiller(int spiller) {
		resultatTabell[spiller][0] = spiller;
	}

	public void leggTilRundeRes(int spiller, int runde, int res) {
		resultatTabell[spiller][runde] = res;
	}

	public int[] visResultat() {

		int[] spillerOgResultat;
		int spiller = 0;
		int resultat = 0;
		int hittilStorst = 0;
		for (int i = 0; i < resultatTabell[0].length; i++) {
			resultat = resultatTabell[i][13];
			if (hittilStorst == 0 || resultat > hittilStorst) {
				hittilStorst = resultat;
				spiller = i;
			}
		}
		spillerOgResultat = new int[2];
		spillerOgResultat[0] = spiller;
		spillerOgResultat[1] = resultat;
		return spillerOgResultat;

	}

	public int[][] getResultatTabell() {
		return resultatTabell;
	}

	public void setResultatTabell(int[][] resultatTabell) {
		this.resultatTabell = resultatTabell;
	}

	@Override
	public String toString() {
		String tilString = "\tSpiller1| Spiller2| Spiller3| Spiller4| Spiller5|";
		for(int i = 0; i < resultatTabell.length; i++) {
			for(int j = 0; i < resultatTabell[i][0]; j++) {
			tilString += "\n " + YatzooSpillet.rundeNavn(i) + ": " + resultatTabell[i][j];
			}
		}
		return tilString;
	}

}
