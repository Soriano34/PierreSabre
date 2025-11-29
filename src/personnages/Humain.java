package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	private Humain[] memoire= new Humain[30];
	private int nbConnaissance=0;
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	private void memoriser(Humain humain) {
		if (nbConnaissance<30) {
			memoire[nbConnaissance]=humain;
			nbConnaissance++;
		}
		else {
			for (int i = 0; i < 29; i++) {
				memoire[i]=memoire[i+1];
			}
			memoire[29]=humain;
		}
	}
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	public String getNom() {
		return nom;
	}
	public void listerConnaissance() {
		String liste= "Je connais beaucoup de monde dont :";
		for (int i = 0; i < nbConnaissance; i++) {
			liste+=memoire[i].getNom();
			if (i<nbConnaissance-1) {
				liste+=" ,";
			}}
			parler(liste);
		
	}
	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
		
	}
	public String getBoissonFavorite() {
		return boissonFavorite;
	}
	public void direBonjour() {
		parler("Bonjour ! je m'appelle "+ nom + " et j'aime boire du "+boissonFavorite);
	}
	public void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}
	public void boire() {
		parler("Mmmm, un bon verre de "+ boissonFavorite+ " ! GLOUPS!");
	}
	
	public int getArgent() {
		return argent;
	}
	public void gagnerArgent(int gain) {
		argent+=gain;
	}
	public void perdreArgent(int perte) {
		argent-=perte;
	}
	public void acheter(String bien, int prix) {
		if (prix<=argent) {
			parler("J'ai acheté "+ bien+" pour "+ prix+ " €");
			perdreArgent(prix);
		} else {
			parler("Je n'ai pas assez d'argent pour acheter "+ bien + ".Il me reste que "+argent+" :'(");
		}
	}
		





}
