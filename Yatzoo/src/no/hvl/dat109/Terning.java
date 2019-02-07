package no.hvl.dat109;

import java.util.Random;
/**
 * 
 * @author Perminow
 *
 */
public class Terning {
		
		private String verdi;
		/**
		 * tom konstruktor
		 */
		public Terning() {
			verdi="";
		}
		
		/**
		 * 
		 *regner ut paa bakgrunn av et tilfeldig tall
		 *hva resultatet av et terningkast blir.
		 *Deretter settes resultatet til verdien terningen vister.
		 *bruker Java.Util.Random for tilfeldig tall.
		 * 
		 */
		public void resultat() {
			int tall;
			String resultat = "";
			Random random = new Random();
			tall = (random.nextInt(6));
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
			default:
				resultat= "feil";
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
