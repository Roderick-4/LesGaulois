package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipementsTab = new Equipement[2];
	private int nbEquipement = 0;
	private String texte;
	
	private boolean invariantSatisfait(int force) {
		return force>0;
	}

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force > 0; //Invariant
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

	private String prendreParole() {
		return "Le romain" + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		int avant = force;
//		force -= forceCoup;
//		assert invariantSatisfait(force): "Invariant fin recevoir coup";
//		if (force > 0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert invariantSatisfait(force): "Invariant fin recevoir coup";
//		assert force < avant : "La force du romain doit avoir diminue"; // Postcondition
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		assert force > 0; // Precondition
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		
		if (force > 0) {
			parler("Aie");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		
		if (force == 0) {
			parler("Aie");
			
			} else {
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
			}
		
		assert force < oldForce; // post condition la force a diminu�e
		return equipementEjecte;
	 }

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le romain " + nom + "est deja bien protege !");
			break;
		case 1:
			if (equipementsTab[0] == equipement) {
				System.out.println("Le romain " + nom + " s'equipe avec un " + equipement + ".");
				nbEquipement += 1;
			}
			else {
				System.out.println("Le soldat s'equipe avec un " + equipement + "!");
				equipementsTab[nbEquipement] = equipement;
				nbEquipement++;
			}
			break;
			
		case 0 :
			System.out.println("Le soldat s'equipe avec un " + equipement + "!");
			equipementsTab[nbEquipement] = equipement;
			nbEquipement++;
			break;
		default:
			break;
		}
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		
		if (nbEquipement != 0) {
		    texte += "\nMais heureusement, grace a mon equipement sa force est diminué de ";
		    
		    for (int i = 0; i < nbEquipement;) {
		        if ((equipementsTab[i] != null && equipementsTab[i].equals(Equipement.BOUCLIER)) == true) {
		            resistanceEquipement += 8;
		            
		        } else {
		            System.out.println("Equipement casque");
		            resistanceEquipement += 5;
		      }
		        i++;
		  }
		    texte += resistanceEquipement + "!";
	  }

	parler(texte);
	forceCoup -= resistanceEquipement;
	return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'equipement de " + nom.toString() + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		
		for (int i = 0; i < nbEquipement; i++) {
			if (equipementsTab[i] != null) {
				equipementEjecte[nbEquipementEjecte] =
				equipementsTab[i];
				nbEquipementEjecte++;
				equipementsTab[i] = null;
				}
		    }
		
		return equipementEjecte;
	 }

	
	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus",6);
		minus.parler("Bonjour");
		minus.recevoirCoup(7);
//		System.out.println(Equipement.CASQUE);
//		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}

}
