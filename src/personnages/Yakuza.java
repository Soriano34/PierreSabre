package personnages;

public class Yakuza extends Humain {
	private int reputation = 0;
	private String clan;

	public Yakuza(String nom, String clan, int argent) {
		super(nom, "whisky", argent);
		this.clan = clan;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ",, si tu tiens à la vie donne moi ta bourse ");
		int moneyDeVictime = victime.getArgent();
		victime.seFaireExtorquer();
		gagnerArgent(moneyDeVictime);
		reputation++;
		parler("J'ai piqué les " + moneyDeVictime + " sous de " + victime.getNom() + ", ce qui me fait " + getArgent()
				+ " dans ma poche. HIHIHAHAHAHHAHA");
	}

	public int getReputation() {
		return reputation;
	}

	public int perdre() {
		parler("J'ai perdu mon duel et mes " + getArgent() + " sous, snif... J'ai déshonoré le clan de "+clan+" .");
		int maThune=getArgent();
		perdreArgent(getArgent());
		reputation--;
		return maThune;
	}

	public void gagner(int gain) {
		parler("Ce ronin pensait vraiment battre "+getNom()+"du clan de "+clan
				+ "? Je l'ai dépouillé de ses "+gain+" sous.");
		gagnerArgent(gain);
		reputation++;
	}
		

}
