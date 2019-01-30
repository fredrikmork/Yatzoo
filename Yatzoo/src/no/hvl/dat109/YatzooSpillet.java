package no.hvl.dat109;

import java.util.ArrayList;

public class YatzooSpillet {
	private ArrayList<Spiller> spillere;
	private ResultatBlokk resultatBlokk;
	private TerningSett terningSett;
	private RegelBok regelBok;

	
	/**
	 * standar konstruktor
	 */
	public YatzooSpillet() {
		terningSett = new TerningSett(5);
		resultatBlokk = new ResultatBlokk();
		regelBok = new RegelBok();

	}
	
	/**
	 * spiller trekk venter på input fra spiller for aa kaste terning og beholde osv
	 * @param spiller Spiller som skal gjøre trekket.
	 */
	public void spillTrekk(Spiller spiller) {
		boolean fornoyd = false;
		//trenger maate aa faa et input som sier om spiller triller, saann at ikke spillTrekk()
		//bare fortsetter aa trille. har midlertidig valgtAaTrille tenkt som en boolean som 
		//sier om en spiller triller :)
		while (!fornoyd) {
			if (spiller.isValgtAaTrille()) {
				terningSett.trillTerninger(terningSett.getTerningSett().size() - 
						spiller.getBehold().getTerningSett().size());
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
	 * @return Spiller: spilleren som vant
	 */
	public Spiller spillerVant() {
		Spiller vinner;
		int[] resultater = (resultatBlokk.visResultat());
		if(resultater[0] == 1) {
			vinner = spillere.get(0);
		}
		if(resultater[0] == 2) {
			vinner = spillere.get(1);
		}
		if(resultater[0] == 3) {
			vinner = spillere.get(2);
		}
		if(resultater[0] == 4) {
			vinner = spillere.get(3);
		}
		else {
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
