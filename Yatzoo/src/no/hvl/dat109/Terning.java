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
		public String getDyr() {
			return verdi;
		}

		public void setDyr(String verdi) {
			this.verdi = verdi;
		}

}
