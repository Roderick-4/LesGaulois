package personnages;

public class Trophee {
	private int force;
	private String nom;
	private Gaulois gaulois = new Gaulois(nom,force);
	private Equipement [] equipement = new Equipement[100];
	
	public Trophee(Gaulois gaulois, Equipement[] equipement){
		this.gaulois = gaulois;
		this.equipement = equipement;
	}
	
	public Gaulois getGaulois() {
		return this.gaulois;
	}
	
	public Equipement[] getEquipement() {
		return this.equipement;
	}
	
	public String donnerNom(Gaulois gaulois) {
		return gaulois.getNom();
	}
}
