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
		   villageois[this.nbVillageois] = gaulois;
		   this.nbVillageois += 1;
	   }
	
	public void afficherVillageois() {
		   System.out.println("Dans le village du chef Abraracourcix vivent les legendaires gaulois :");
		   for (int i=0; i<nbVillageois; i++) {
			   System.out.println("-" + villageois[i].getNom());
		   }
	   }

	public static void main(String[] args) {
			Village village = new Village("Village des Irreductibles", 30);
		   
		    Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		    village.setChef(abraracourcix);
		    
		    village.trouverHabitant(0);
		   
		    Gaulois asterix;
		    asterix = new Gaulois("Asterix",8);
		    village.ajouterHabitant(asterix);
		    
		    Gaulois obelix;
		    obelix = new Gaulois("Obelix",25);
		    village.ajouterHabitant(obelix);
		    
		    village.afficherVillageois();
	   }
}
