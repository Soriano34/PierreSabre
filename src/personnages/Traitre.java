package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private int niveauTraitrise = 0;

	public Traitre(String seigneur, String nom, String boissonPreferee, int argent) {
		super(seigneur, nom, boissonPreferee, argent);
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître mon niveau de traîtrise est : " + niveauTraitrise);
	}

	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < 3) {
			int argentActuel = commercant.getArgent();
			int argentRanconner = argentActuel * 2 / 10;
			commercant.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			niveauTraitrise++;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer! Dnne moi " + argentRanconner
					+ " sous ou gare à toi!");
			commercant.parler("Tout de suite grand" + getNom() + " .");
		} else {
			parler("Mince je ne peux pmus rançonner personne sinon un samouraï risque de me démasquer! ");
		}
	}

	public void faireLeGentil() {
		if (nbConnaissance<1) {
			parler("Je ne peux pas faire ami ami avec personne car je ne connais personne ! Snif");}
		else {
			Random random = new Random();
			int indexAmi= random.nextInt(nbConnaissance);
			Humain ami = memoire[indexAmi];
			int don = getArgent()/20;
		    String nomAmi = ami.getNom();
		    parler("Il faut absolument remonter ma côte de confiance. Je vais faire ami ami avec" +nomAmi+" .");
		    parler("Bonjour l'ami ! "+nomAmi+ " Je voudrais vous aider en vous donnant " + don + " sous.");
		    ami.gagnerArgent(don);
		    perdreArgent(don);
		    ami.parler("Merci "+getNom()+". Vous êtes quelqu'un de bien.");
		    if (niveauTraitrise>0) niveauTraitrise--;
		}
	}
}
