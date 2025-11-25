package histoire;

import personnages.Commercant;
import personnages.Humain;
import personnages.Ronin;
import personnages.Yakuza;

public class HistoireTP4 {
	public static void main(String[] args) {
		Humain prof = new Humain("Prof", "Kombucha",54 );
		prof.direBonjour();
		prof.acheter("une boisson", 12); /*12 euro la boisson abusé*/
		prof.boire();
		prof.acheter("un jeu", 2);
		prof.acheter("un kimono", 50);
		System.out.println("Partie 2 avec le commerçant");
		Commercant marco = new Commercant("Marco Verratti",20);
		marco.parler("Bonjour ! Je m'appelle Marco Verratti Milieu Du PSG et j'aime boire du thé.");
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire();
		System.out.println("PARTIE 2.2////////");
		Yakuza yakuLeNoir= new Yakuza("Yaku Le Noir","Warsong", 30);
		yakuLeNoir.direBonjour();
		yakuLeNoir.extorquer(marco);	
		System.out.println("PARTIE 2.3////////");
		Ronin roro = new Ronin("Roro", 60);
		roro.direBonjour();
		roro.donner(marco);
		System.out.println("PARTIE 3......////");
		roro.parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		roro.provoquer(yakuLeNoir);
	}
}
