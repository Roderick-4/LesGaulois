package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
    private int nbVillageois = 0;
	
	
    public Village(String nom, int nbVillageoisMaximum) {
        this.nom = nom;
        villageois = new Gaulois[nbVillageoisMaximum];
   }
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getNom() {
		return nom;
	}
	
	public Gaulois trouverHabitant(int perso) {
    	return villageois[perso];
   }
	
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois += 1;
		}
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + villageois[0].getNom() +" vivent les legendaires gaulois :");
		for (int i = 1; i < nbVillageois;) {
			System.out.println("- " + villageois[i].getNom());
			i++;
			}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irr�ductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 30 out of bounds for length 30
//		premiere case du tableau == 0, donc dans un tableau a 30 elt, la derniere case a le num 29
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		village.ajouterHabitant(abraracourcix);
		Gaulois asterix = new Gaulois("asterix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		Gaulois [nom=asterix, force=8]
//		renvoie le gaulois dans la 2eme case, donc asterix
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	   }
}
