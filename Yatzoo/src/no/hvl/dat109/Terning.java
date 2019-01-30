package no.hvl.dat109;

import java.util.Random;

public class Terning {
		
		private String verdi;
		
		public Terning() {
			verdi="";
		}
		
		/**
		 * 
		 * @return Returnerer resultatet av trillingen
		 */
		public void resultat() {
			String resultat ="";
			int tall;
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

}
