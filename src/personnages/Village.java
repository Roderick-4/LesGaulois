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
	
	public void trouverHabitant(int a) {
    	System.out.println(villageois[a].getNom());
   }
	
	public void ajouterHabitant(Gaulois gaulois) {
		   villageois[this.nbVillageois] = gaulois;
		   this.nbVillageois += 1;
	   }
	
	public void afficherVillageois() {
		   System.out.println("Dans le village du chef Abraracourcix vivent les l�gendaires gaulois :");
		   for (int i=0; i<nbVillageois; i++) {
			   System.out.println("-" + villageois[i].getNom());
		   }
	   }

	    public static void main(String[] args) {
		    Village village;
		    village = new Village("Village des Irr�ductibles", 30);
		   
		    Chef abraracourcix;
		    abraracourcix = new Chef("Abraracourcix", 6, village);
		   
		    Gaulois asterix;
		    asterix = new Gaulois("Ast�rix",8);
		    village.ajouterHabitant(asterix);
		    //village.trouverHabitant(0);
		    
		    Gaulois obelix;
		    obelix = new Gaulois("Ob�lix",25);
		    village.ajouterHabitant(obelix);
		    
		    village.afficherVillageois();
	   }
}
