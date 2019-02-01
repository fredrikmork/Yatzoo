package no.hvl.dat109;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class YatzooSpillet {
	private static final int  MAXTERNINGER = 5;
	private ArrayList<Spiller> spillere;
	private ResultatBlokk resultatBlokk;
	private TerningSett terningSett;
	private RegelBok regelBok;

	/**
	 * standar konstruktor
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
	 * metoden som starter spillet hvis det er første runde blir spillere bedt om å
	 * legge inn hvor mange spillere som skal spille og etter det blir de spurt om å
	 * skrive inn alle spillere sitt navn dette er lokken som omfatter hele spillet.
	 * 
	 * @param boolean
	 *            om det er et nytt spill, eller om metoden kjores mens et spil
	 *            foregår har med å feilmeldinger aa gjore.
	 */
	public void startSpill(boolean newGame) {
		for (int runde = 0; runde < 12; runde++) {
			int antallSpillereTilInt = 0;
			if (runde == 1) {
				try {
					boolean rettInput = false;
					if (newGame) {
						JOptionPane.showMessageDialog(null, "new Game");
					}
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
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "vennligst skriv et tall..");
					startSpill(false);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "vennligst skriv noe...");
					startSpill(false);
				}
				for (int antallSpillere = 0; antallSpillere < antallSpillereTilInt; antallSpillere++) {
					int spillerNummer = antallSpillere + 1;
					String melding = "skriv spiller" + spillerNummer + " sitt navn";
					String SpillerNavnInput = JOptionPane.showInputDialog(null, melding);
					Spiller spiller = new Spiller(SpillerNavnInput);
					this.leggTilSpiller(spiller);
				}
				spillRunde();
			} else {
				for (int antallSpillere = 0; antallSpillere < antallSpillereTilInt; antallSpillere++) {
					spillRunde();
				}
			}
		}
	}

	/**
	 * spiller trekk venter på input fra spiller for aa kaste terning og beholde osv
	 * mye greier i denne metode, maa refraktorere det til flere minder metoder for 
	 * aa faa mer orden
	 * @param spiller, Spiller som skal gjre trekket.
	 */
	public void spillTrekk(Spiller spiller) {
		this.terningSett = new TerningSett(5);
		JOptionPane.showMessageDialog(null, spiller.getNavn() + " sin tur!");
		kastTerninger(spiller);
		JOptionPane.showMessageDialog(null, "runde Resultat: " + spiller.getBehold().toString());
	}
	
	
	public void kastTerninger(Spiller spiller) {
		boolean fornoyd = false;
		int kast = 0;
		while (!fornoyd && kast < 3) {
			JOptionPane.showMessageDialog(null, "Trill terninger!");
			TerningSett trillet = terningSett.trillTerninger(this.terningSett);
			JOptionPane.showMessageDialog(null, "Resultat: " + trillet.toString());
			kast++;
			
			leggTilSide(spiller, trillet);
			if(spiller.getAntallBehold() == 5) {
				fornoyd = true;
			}
			
			JOptionPane.showMessageDialog(null, "terninger du beholder: " + spiller.getBehold().toString());
			int resterendeTerninger = MAXTERNINGER - spiller.getBehold().getTerningSett().size();
			this.terningSett = new TerningSett(resterendeTerninger);
			
			if(kast == 3) {
				continue;
			}
			int omTrill = JOptionPane.showConfirmDialog(null, "trille igjen?", "trille igjen?",
					JOptionPane.YES_NO_OPTION);
			if (omTrill != 0) {
				fornoyd = true;
			}
		}
	}

	public void leggTilSide(Spiller spiller, TerningSett trillet) {
		if(trillet.getTerningSett().size() <= 1) {
			spiller.getBehold().leggTilTerning(trillet.getTerningSett().get(0));
			return;
		}
		String beholde = JOptionPane.showInputDialog(null,
				"skriv inn tallet paa terningene " + "du vil beholde" + trillet.toString());
		if (beholde.isEmpty() || beholde.equals("")) {
			return;
		}
		String[] beholdeArray = beholde.split("");
		System.out.println(beholdeArray.toString());

		for (int i = 0; i < beholdeArray.length; i++) {
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
	 */
	public void spillRunde() {
		int runder = spillere.size();
		for (int i = 0; i < runder; i++) {
			for (Spiller s : spillere) {
				spillTrekk(s);
			}
		}

	}

	/**
	 * finner spillerene som vant ved hjelp av resultatBlokken
	 * 
	 * @return Spiller: spilleren som vant
	 */
	public Spiller spillerVant() {
		Spiller vinner;
		int[] resultater = (resultatBlokk.visResultat());
		if (resultater[0] == 1) {
			vinner = spillere.get(0);
		}
		if (resultater[0] == 2) {
			vinner = spillere.get(1);
		}
		if (resultater[0] == 3) {
			vinner = spillere.get(2);
		}
		if (resultater[0] == 4) {
			vinner = spillere.get(3);
		} else {
			vinner = spillere.get(4);
		}

		return vinner;

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
