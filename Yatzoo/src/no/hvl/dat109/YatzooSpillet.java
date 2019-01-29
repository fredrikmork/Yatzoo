package no.hvl.dat109;

import java.util.ArrayList;

public class YatzooSpillet {
	private ArrayList<Spiller> spillere;
	private ResultatBlokk resultatBlokk;
	private TerningSett terningSett;
	private RegelBok regelBok;

	public YatzooSpillet() {
		terningSett = new TerningSett(5);
		resultatBlokk = new ResultatBlokk();
		regelBok = new RegelBok();

	}

	public void spillTrekk(Spiller spiller) {
		boolean fornoyd = false;
		int trykk = 0;
		while (!fornoyd && trykk < 3) {
			if (spiller.trykk()) {
				terningSett.trillTerninger(terningSett.getTerningSett().size() - spiller.getBehold.size());
				trykk++;
			}
		}
	}

	public void spillRunde() {
		int runder = 12;
		for (int i = 0; i < runder; i++) {
			for (Spiller s : spillere) {
				spillTrekk(s);
			}
		}

	}

	public Spiller spillerVant() {
		return(regelBok.visResultat());
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
