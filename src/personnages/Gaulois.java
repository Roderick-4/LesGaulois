package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nb_trophees;
	private int effetPotion = 1;
	private Equipement trophees[] = new Equipement[100];


	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "'" + texte + "'");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + ":";
//	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}

	public String toString() {
		return "Gaulois [nom=" + nom + ", force =" + force + ", effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(int effetPotion) {
		this.effetPotion = effetPotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : " ;
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		//Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
//		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
//			this.trophees[nb_trophees] = trophees[i];
//			}
//		return;
//	}


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
