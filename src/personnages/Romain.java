package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean vainqueur = true;
	
	public Romain(String nom, int force) {
		assert force > 0: "La force du romain est toujours positive";
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public boolean estVainqueur() {
		return vainqueur;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "'" + texte + "'");
	}

	private String prendreParole() {
		return "Le romain" + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//	assert force >= 0: "la force d’un Romain est positive";
//	int forcePreCondition = force;		
//	force -= forceCoup;
//	if (force > 0) {
//		parler("Aie");
//	} else {
//		parler("J'abandonne...");
//	}
//	assert force <= forcePreCondition : "la force d’un Romain a diminué";
//}
	
public Equipement[] recevoirCoup(int forceCoup) {
	Equipement[] equipementEjecte = null;
	// précondition
	assert force > 0;
	int oldForce = force;
	forceCoup = calculResistanceEquipement(forceCoup);
	force -= forceCoup;
	if (force > 0) {
		parler("Aïe");
	} else {
		equipementEjecte = ejecterEquipement();
		parler("J'abandonne...");
	}
	// post condition la force a diminuée
	assert force < oldForce;
	return equipementEjecte;
}

private int calculResistanceEquipement(int forceCoup) {
	String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
	int resistanceEquipement = 0;
	if (nbEquipement != 0) {
		texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement; i++) {
			if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
				resistanceEquipement += 8;
			} else {
				System.out.println("Equipement casque");
				resistanceEquipement += 5;
			}
		}
		texte += resistanceEquipement + "!";
	}
	parler(texte);
	forceCoup -= resistanceEquipement;
	if (forceCoup <= 0) {
		forceCoup = 0;
		parler("Je suis plus fort que toi, tu ne peux pas gagner !");
		vainqueur = false;
	}
	return forceCoup;
}

private Equipement[] ejecterEquipement() {
	System.out.println("L'équipement de " + this.nom + "s'envole sous la force du coup.");
	Equipement[] equipementEjecte = new Equipement[nbEquipement];
	int nbEquipementEjecte = 0;
	for (int i = 0; i < nbEquipement; i++) {
		if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

private void parleEquipement(String equipement) {
	System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
}

public void sEquiper(Equipement equipement) {
	switch (nbEquipement) {
	case 0: {
		parleEquipement(equipement.toString());
		equipements[0] = equipement;
		nbEquipement += 1;
		break; 
	}
	case 1: {
		if (equipements[0] != equipement) {
			parleEquipement(equipement.toString());
			equipements[1] = equipement;
			nbEquipement += 1;
		} else {
			System.out.println("Le soldat " + nom + " possède déjà un " + equipement.toString() + " !");
		}
		break; 
	}
	default:
		System.out.println("Le soldat " + nom + " est déjà bien protégé !");
		break; 
	}
}
	
	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus",6);
		minus.parler("Bonjour");
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.recevoirCoup(11);
	    System.out.println("La force de " + minus.getNom() + " est de " + minus.getForce() + ".");
		minus.recevoirCoup(5);
	    System.out.println("La force de " + minus.getNom() + " est de " + minus.getForce() + ".");


	}

}
