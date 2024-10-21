package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert force > 0; //Invariant
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
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
	
	public Equipement[] recevoirCoup(int forceCoup) {
	    Equipement[] equipementEjecte = null;
	    assert force > 0 : "La force doit être positive avant de recevoir un coup";
	    int oldForce = force;
	    int forceCoupInitial = forceCoup; 
	    forceCoup = calculResistanceEquipement(forceCoup); 
	    
	    if (forceCoup < forceCoupInitial) {
	        forceCoup = 0;
	    }
		equipementEjecte = ejecterEquipement();

	    force -= forceCoup;
	    if (force < 0) {
	        force = 0;
	    }
	    if (force > 0) {
	        parler("Aie");
	    } else {
	        parler("J'abandonne...");
	    }
	    assert force <= oldForce : "La force ne peut pas augmenter après un coup";
	    return equipementEjecte;
	}
	
//	public Equipement[] recevoirCoup(int forceCoup) {
//		Equipement[] equipementEjecte = null;
//		// précondition
//		assert force > 0;
//		int oldForce = force;
//		forceCoup = calculResistanceEquipement(forceCoup);
//		force -= forceCoup;
//		if (force == 0) {
//			parler("Aïe");
//		} else {
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//		}
//		// post condition la force a diminuée
//		assert force < oldForce;
//		return equipementEjecte;
//	}


	public void sEquiper(Equipement stuff) {
		switch (nbEquipement) {
		case 0:
			equipements[nbEquipement] = stuff;
			nbEquipement++;
			System.out.println("Le soldat " + getNom() + " s'équipe avec un " + stuff.toString());
			break;
		case 1:
			if (equipements[0] == stuff) {
				System.out.println("Le soldat " + getNom() + " possède dèja un " + stuff.toString());
			} else {
				equipements[nbEquipement] = stuff;
				nbEquipement++;
				System.out.println("Le soldat " + getNom() + " s'équipe avec un " + stuff.toString());
			}
			break;
		default:
			System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
			break;
		}
	}

	
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
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
			texte = +resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
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
