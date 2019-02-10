package no.hvl.dat109;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 * 
 * @author Perminow
 *
 */
public class YatzooSpillet {
	private static final int MAXTERNINGER = 5;
	private ArrayList<Spiller> spillere;
	private ResultatBlokk resultatBlokk;
	private TerningSett terningSett;
	private RegelBok regelBok;

	/**
	 * standar konstruktor opretter et nytt YatzooSpill objekt.
	 */
	public YatzooSpillet() {
		spillere = new ArrayList<Spiller>();
		terningSett = new TerningSett(5);
		resultatBlokk = new ResultatBlokk();
		regelBok = new RegelBok();

	}

	/**
	 * legger til en spiller i listen med spillere til selve spillet
	 * 
	 * @param Spillerspiller
	 */
	public void leggTilSpiller(Spiller spiller) {
		spillere.add(spiller);
	}

	/**
	 * ber spillere skrive inn hvor mange spillere som skal spille spillet. Og for
	 * hver spiller ber spille spillerene skrive inn navnet sitt.
	 * 
	 * @return int antall spillere i aktivt spill.
	 */
	public int leggTilSpillereIAktivtSpill() {
		boolean rettInput = false;
		int antallSpillereTilInt = 0;
		try {
			while (!rettInput) {
				String inputAntallSpillere = JOptionPane.showInputDialog(null, "antall spilere(maks 5): ");
				antallSpillereTilInt = Integer.parseInt(inputAntallSpillere);
				if (antallSpillereTilInt > 5) {
					JOptionPane.showMessageDialog(null, "Maks 5 spillere");
				} else if (antallSpillereTilInt < 2) {
					JOptionPane.showMessageDialog(null, "Minst 2 spillere");
				} else {
					rettInput = true;
				}
			}

			// haandtering av feil input i input boksen
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "vennligst skriv et tall..");
			startSpill(false);
		}
		// iterere gjennon alle spillere som spiller i spillet og hver spiller
		// skriver sitt spillernavn
		for (int antallSpillere = 0; antallSpillere < antallSpillereTilInt; antallSpillere++) {
			String melding = "skriv spiller" + (antallSpillere + 1) + " sitt navn";
			String SpillerNavnInput = JOptionPane.showInputDialog(null, melding);
			Spiller spiller = new Spiller(SpillerNavnInput);
			leggTilSpiller(spiller);
		}
		return antallSpillereTilInt;
	}

	/**
	 * metoden som starter spillet hvis det er første runde blir spillere bedt om å
	 * legge inn hvor mange spillere som skal spille og etter det blir de spurt om å
	 * skrive inn alle spillere sitt navn dette er lokken som omfatter hele spillet.
	 * 
	 * @param boolean
	 *            om det er et nytt spill, eller om metoden kjores mens et spill
	 *            foregaar, har med å feilmeldinger aa gjore.
	 */
	public void startSpill(boolean newGame) {
		String rundeStr = "";
		for (int runde = 1; runde < 14; runde++) {
			if (runde == 1) {
				int antallSpillereTilInt = 0;
				if (newGame) {
					JOptionPane.showMessageDialog(null, "new Game");
					antallSpillereTilInt = leggTilSpillereIAktivtSpill();
					System.out.print("Spillere");
					for (Spiller s : spillere) {
						System.out.print("\t" + s.getNavn() + "|\t");
					}
					for(int i=0; i < 5 - spillere.size(); i++) {
						System.out.print("\t ingen spiller|\t");
					}
					System.out.print(" \n");
					rundeStr = rundeNavn(runde);
					JOptionPane.showMessageDialog(null, "vi spiller naa runde: " + rundeStr);
					spillRunde(runde);
					System.out.print(rundeNavn(runde));
					System.out.println(resultatBlokk.toString(runde));
				} else {
					antallSpillereTilInt = leggTilSpillereIAktivtSpill();
					System.out.print("Spillere");
					for (Spiller s : spillere) {
						System.out.print("\t" + s.getNavn() + "|\t");
					}
					for(int i=0; i < 5 - spillere.size(); i++) {
						System.out.print("\t ingen spiller|\t");
					}
					System.out.print(" \n");
					JOptionPane.showMessageDialog(null, "vi spiller naa runde: " + rundeStr);
					spillRunde(runde);
					System.out.print(rundeNavn(runde));
					System.out.println(resultatBlokk.toString(runde));
				}
			} else {
				rundeStr = rundeNavn(runde);
				if (runde != 13) {
					JOptionPane.showMessageDialog(null, "vi spiller naa runde: " + rundeStr);
					spillRunde(runde);
				} else {
					JOptionPane.showMessageDialog(null, "Viser naa: " + rundeStr);
					resultatBlokk.totalResultat();
					System.out.print(rundeNavn(runde));
					System.out.println(resultatBlokk.toString(runde));
					int[][] resultatTabellen = resultatBlokk.getResultatTabell();
					Spiller vinner = spillerVant();
					int vinnerScore = resultatTabellen[spillere.indexOf(vinner)][12];
					for(Spiller s: spillere) {
					if(!s.equals(vinner) && resultatTabellen[spillere.indexOf(s)][12] == vinnerScore){
						System.out.println("Det ble uavgjor mellom: "
					+ s.getNavn() + " og " + spillerVant().getNavn() + "begge hadde: " + vinnerScore + " poeng!"
					);
						return;
					}
					}
					System.out.println("vinneren er: " + spillerVant().getNavn() + "!!!!!!!!!");
					return;
					
				}
				System.out.print(rundeNavn(runde));
				System.out.println(resultatBlokk.toString(runde));
			}
		}
	}

	/**
	 * metoden bruker kastTerning hjelpemetoden for aa spille et Trekk for en
	 * spiller.
	 * 
	 * @param spiller,
	 *            Spiller som skal gjre trekket.
	 */
	public void spillTrekk(Spiller spiller) {
		this.terningSett = new TerningSett(5);
		JOptionPane.showMessageDialog(null, spiller.getNavn() + " sin tur!");
		kastTerninger(spiller);
		JOptionPane.showMessageDialog(null, "runde Resultat: " + spiller.getBehold().toString());
	}

	/**
	 * metoden kaster en terning og spilleren selv velger hvilke terninger som skal
	 * kastes og hvilke som skal beholdes. bruker JOPtionPane for input og output
	 * til vinduet.
	 * 
	 * @param spiller:
	 *            Spiller spiller som skal kaste terningen.
	 * 
	 */
	public void kastTerninger(Spiller spiller) {
		spiller.setBehold(new TerningSett());
		boolean fornoyd = false;
		int kast = 0;
		// while lokke som gaar saa lenge spilleren er fornoy med kastet eller frem til
		// spilleren
		// har kastet tre kast.
		while (!fornoyd && kast < 3) {
			JOptionPane.showMessageDialog(null, "Trill terninger!");
			// lager et nytt TerningSett av resultatet på terningsettet som bli trilt.
			TerningSett trillet = terningSett.trillTerninger(this.terningSett);
			JOptionPane.showMessageDialog(null, "Resultat: " + trillet.toString());
			// etter trillTerninger metoden er kalt vil kast variablen oke.
			kast++;
			if (kast == 3) {
				leggTilSide(spiller, trillet, true);
				continue;
			}

			leggTilSide(spiller, trillet, false);

			JOptionPane.showMessageDialog(null, "terninger du beholder: " + spiller.getBehold().toString());
			int resterendeTerninger = MAXTERNINGER - spiller.getBehold().getTerningSett().size();
			this.terningSett = new TerningSett(resterendeTerninger);

			if (spiller.getBehold().getAntallTerninger() == 5) {
				fornoyd = true;
				continue;
			}
		}
	}

	public boolean finnUnikVerdi(String string) {
		Set<String> funnetBokstaver = new HashSet<String>();
		for (String s : string.split("")) {
			if (funnetBokstaver.contains(s)) {
				return false;
			}
			funnetBokstaver.add(s);
		}
		return true;

	}

	/**
	 * leggtilside metoden tar et valgt antall terninger og putter i et terningsett
	 * for lagring
	 * 
	 * @param spiller
	 *            Spiller, som beholder terningene.
	 * @param trillet
	 *            TerningSett som spilleren skal velge hvilke terninger som skal
	 *            beholdes fra
	 * @param autoVelg
	 *            boolean autovel sier om leggTilside skal skje automatisk eller ved
	 *            at spilleren selv skal velge terningene.
	 * 
	 */
	public void leggTilSide(Spiller spiller, TerningSett trillet, boolean autoVelg) {

		if (autoVelg) {
			try {
				for (Terning t : trillet.getTerningSett()) {
					spiller.getBehold().leggTilTerning(t);
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
			return;
		}
		boolean riktigInput = false;
		String beholde = "";
		while (!riktigInput) {
			try {
				beholde = JOptionPane.showInputDialog(null,
						"skriv inn tallet paa terningene " + "du vil beholde" + trillet.toString());
				if (beholde.equals("")) {
					riktigInput = true;
				}
				Integer.parseInt(beholde);
				if (finnUnikVerdi(beholde)) {
					riktigInput = true;
				}
			} catch (NumberFormatException e) {
				continue;
			}
		}

		// hvis det ikke staar noe i input fielden vil ingen terninger bli lagt til i
		// spillerens behold Terningsett og metoden vil returnere og ikke kjore videre.
		// splitter inputstringen til en liste med hver enkelt karakter slik at det blir
		// mulig aa gaa gjennom alle tallene spilleren skrev den ville beholde.
		String[] beholdeArray = beholde.split("");

		// for hver charakter i beholdArray brukes det et switch statement for aa se
		// hvilke terning som spilleren ville beholde, slik at man sjekker det for hver
		// terning.
		for (int i = 0; i < beholdeArray.length; i++) {
			if (beholde.isEmpty() || beholde.equals("")) {
				continue;
			}
			int tallet = Integer.parseInt(beholdeArray[i]);
			switch (tallet) {
			case 1:
				spiller.getBehold().leggTilTerning(trillet.getTerningSett().get(0));
				break;
			case 2:
				spiller.getBehold().leggTilTerning(trillet.getTerningSett().get(1));
				break;
			case 3:
				spiller.getBehold().leggTilTerning(trillet.getTerningSett().get(2));
				break;
			case 4:
				spiller.getBehold().leggTilTerning(trillet.getTerningSett().get(3));
				break;
			case 5:
				spiller.getBehold().leggTilTerning(trillet.getTerningSett().get(4));
				break;
			}
		}
	}

	/**
	 * Spiller runder basert på hvor mange spillere som spiller spillet
	 * 
	 */
	public void spillRunde(int runde) {
		int index = 0;
		for (Spiller s : this.spillere) {
			if (s == null) {
				continue;
			}
			if (runde != 13) {
				spillTrekk(s);
			}
			giPoeng(s, runde, index);
			index++;
		}
	}

	/**
	 * finner ut hvor mye poeng en spiller skal få etter en runde er gjennomført og
	 * så gir denne spilleren riktig mengde poeng, og legger disse poengene inn i
	 * spilleren si kolonne i resultatTabellen til YatzooSpillet.
	 * 
	 * @param s,
	 *            Spiller s, den spilleren som skal faa poeng
	 * @param runde,
	 *            int runde hvilke runde vi er paa
	 * @param index
	 *            int index, spilleren sin index i resultatTabellen
	 */
	public void giPoeng(Spiller s, int runde, int index) {
		// naar vi skal sjekke nLike bruker jeg (runde - 4) siden det er felles for
		// baade 3 like og 4 like
		// naar runde er 7 som er 3 like vil poeng vaere 3 og antall like vaere 3 samme
		// for runde 8.
		// da er nLike 4.
		int nLike = runde - 4;
		// maa trekke fra en paa runde siden runde starter paa 1 og resultattabellen
		// starter paa 0.
		int tabellIndexRunde = runde - 1;
		if (runde < 7) {
			resultatBlokk.leggTilRundeRes(index, tabellIndexRunde, (regelBok.dyr(s.getBehold(), rundeNavn(runde))));
		} else {
			switch (runde) {
			case 7:
				if (regelBok.nLike(s.getBehold(), nLike)) {
					resultatBlokk.leggTilRundeRes(index, tabellIndexRunde, nLike);
				} else {
					resultatBlokk.leggTilRundeRes(index, tabellIndexRunde, 0);
				}
				break;
			case 8:
				if (regelBok.nLike(s.getBehold(), nLike)) {
					resultatBlokk.leggTilRundeRes(index, tabellIndexRunde, nLike);
				} else {
					resultatBlokk.leggTilRundeRes(index, tabellIndexRunde, 0);
				}
				break;
			case 9:
				if (regelBok.toPar(s.getBehold())) {
					resultatBlokk.leggTilRundeRes(index, tabellIndexRunde, 4);
				} else {
					resultatBlokk.leggTilRundeRes(index, tabellIndexRunde, 0);
				}
				break;
			case 10:
				if (regelBok.hus(s.getBehold())) {
					resultatBlokk.leggTilRundeRes(index, tabellIndexRunde, 5);
				} else {
					resultatBlokk.leggTilRundeRes(index, tabellIndexRunde, 0);
				}
				break;
			case 11:
				if (regelBok.enAvHver(s.getBehold())) {
					resultatBlokk.leggTilRundeRes(index, tabellIndexRunde, 5);
				}
				break;
			case 12:
				if (regelBok.nLike(s.getBehold(), 5)) {
					resultatBlokk.leggTilRundeRes(index, tabellIndexRunde, 10);
				}
				break;
			case 13:
				break;
			}
		}
	}

	/**
	 * finner spillerene som vant ved hjelp av resultatBlokken
	 * 
	 * @return Spiller: spilleren som vant
	 */
	public Spiller spillerVant() {
		Spiller spiller = null;
		int score = 0;
		int hittilStorst = 0;
		for (Spiller s : spillere) {
			score = resultatBlokk.getResultatTabell()[spillere.indexOf(s)][12];
			if (hittilStorst == 0 || score > hittilStorst) {
				hittilStorst = score;
				spiller = s;
			}
		}

		return spiller;

	}

	/**
	 * metode for aa finne ut hvilke runde i integer som hoerer til hvilket
	 * rundenavn
	 * 
	 * @param runde,
	 *            int runde nummer
	 * @return String navnet paa runden som er gitt i parameteret.
	 */
	public static String rundeNavn(int runde) {
		String rundeNavn = " ";
		switch (runde) {
		case 1:
			rundeNavn = "love";
			break;
		case 2:
			rundeNavn = "slange";
			break;
		case 3:
			rundeNavn = "panda";
			break;
		case 4:
			rundeNavn = "gris";
			break;
		case 5:
			rundeNavn = "elefant";
			break;
		case 6:
			rundeNavn = "hval";
			break;
		case 7:
			rundeNavn = "3like";
			break;
		case 8:
			rundeNavn = "4like";
			break;
		case 9:
			rundeNavn = "par ";
			break;
		case 10:
			rundeNavn = "hus ";
			break;
		case 11:
			rundeNavn = "ulike";
			break;
		case 12:
			rundeNavn = "YATZOO";
			break;
		case 13:
			rundeNavn = "Result:";
		}
		return rundeNavn;
	}

	public ArrayList<Spiller> getSpillere() {
		return spillere;
	}

	public void setSpillere(ArrayList<Spiller> spillere) {
		this.spillere = spillere;
	}

	public ResultatBlokk getResultatBlokk() {
		return resultatBlokk;
	}

	public void setResultatBlokk(ResultatBlokk resultatBlokk) {
		this.resultatBlokk = resultatBlokk;
	}

	public TerningSett getTerningSett() {
		return terningSett;
	}

	public void setTerningSett(TerningSett terningSett) {
		this.terningSett = terningSett;
	}

	public RegelBok getRegelBok() {
		return regelBok;
	}

	public void setRegelBok(RegelBok regelBok) {
		this.regelBok = regelBok;
	}

}
