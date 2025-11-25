package personnages;

public class Ronin extends Humain {
	private int honneur=1;
	public Ronin(String nom, int argent) {
		super(nom,"shochu",argent);

	}
	public void donner(Commercant benificiaire) {
		int thune = getArgent()/10;
		parler(benificiaire.getNom()+" prend ces "+thune+ " sous.");
		benificiaire.recevoir(thune);
		perdreArgent(thune);
	}
	
	public void provoquer(Yakuza adversaire) {
	int force=honneur*2;
	if (force>=adversaire.getReputation()){
		parler("Je t'ai eu petit yakusa!");
		int argentGagne=adversaire.perdre();
		gagnerArgent(argentGagne);
		honneur++;}
	else
		{
			honneur--;
			int argentPerdu=getArgent();
			adversaire.gagner(argentPerdu);
			perdreArgent(argentPerdu);
			parler("Oh non j'ai tout perdu à cause du duel");
		}
	}
	}

