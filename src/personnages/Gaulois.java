package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];


	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public Equipement[] getTrophees() {
		return trophees;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "'" + texte + "'");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + ":";
	}

	public String toString() {
		return "Gaulois [nom=" + nom + ", force =" + force + ", effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(int effetPotion) {
		this.effetPotion = effetPotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois decuplee.");
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		Equipement[] loot = romain.recevoirCoup((force / 3) * effetPotion);
//		for (int i = 0; i < loot.length && loot[i] != null; i++) {
//			trophees[nbTrophees] = loot[i];
//			nbTrophees++;
//		}
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] degat = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; degat != null && i < degat.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = degat[i];
		}
	}
	
	public void faireUneDonnation(Musee musee) {
		String texte = "je donne au musee tous mes trophees :";
		for (int i=0;i<nbTrophees;i++) {
			texte += "\n-" + trophees[i];
			musee.donnerTrophees(new Gaulois(nom,force),trophees[i]);
		}
		parler(texte);
	}


	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		minus.parler("Yo");
		minus.recevoirCoup(asterix.force);
		asterix.boirePotion(5);
	}

}
