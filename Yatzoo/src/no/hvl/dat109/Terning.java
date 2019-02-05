package no.hvl.dat109;

import java.util.Comparator;
import java.util.Random;

public class Terning implements Comparator<Terning> {
		
		private String verdi;
		
		public Terning() {
			verdi="";
		}
		
		/**
		 * 
		 * triller terning og setter verdien av trillingen til den 
		 * terninger som ble trillet til det resultatet av trillingen ble :S
		 * 
		 */
		public void resultat() {
			int tall;
			String resultat = "";
			Random random = new Random();
			tall = (random.nextInt(5));
			switch(tall){
			
			case 0:
				resultat = "love";
				break;
			case 1:
				resultat = "slange";
				break;
			case 2:
				resultat="panda";
				break;
			case 3:
				resultat="gris";
				break;
			case 4:
				resultat="elefant";
				break;
			case 5:
				resultat="hval";
				break;
			
			}
			setDyr(resultat);
		}
		/**
		 * henter verdien som vises paa terningen
		 * @return String med dyret som terningen viser
		 */
		public String getDyr() {
			return verdi;
		}
		/**
		 * setter verdien en terning har, slik at man kan lagre
		 * en terning med en gitt verdi
		 * @param verdi String med dyrenavnet
		 */
		public void setDyr(String verdi) {
			this.verdi = verdi;
		}

		public int compare(Terning t1, Terning t2) {
			return t1.getDyr().compareTo(t2.getDyr());
		}

}
