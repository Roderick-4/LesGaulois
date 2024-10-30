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
		//précondition
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
		
		//post condition (la force a diminuée)
		assert force < oldForce;
		return equipementEjecte;
	}
//	public Equipement[] recevoirCoup(int forceCoup) {
//	    Equipement[] equipementEjecte = null;
//	    assert force > 0 : "La force doit être positive avant de recevoir un coup";
//	    int oldForce = force;
//	    int forceCoupInitial = forceCoup; 
//	    forceCoup = calculResistanceEquipement(forceCoup); 
//	    
//	    if (forceCoup + 8 == forceCoupInitial) {
//			equipementEjecte = ejecterEquipement();
//
//		} else if (forceCoup + 5 == forceCoupInitial) {
//			equipementEjecte = ejecterEquipement();
//
//		}
//	    if (forceCoup < 0) {
//	        forceCoup = 0;
//	    }
//	    force -= forceCoup;
//	    if (force < 0) {
//	        force = 0;
//	    }
//	    if (force > 0) {
//	        parler("Aie");
//	    } else {
//	        parler("J'abandonne...");
//	    }
//	    assert force <= oldForce : "La force ne peut pas augmenter après un coup";
//	    return equipementEjecte;
//	}
	
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


//	public void sEquiper(Equipement stuff) {
//		switch (nbEquipement) {
//		case 0:
//			equipements[nbEquipement] = stuff;
//			nbEquipement++;
//			System.out.println("Le soldat " + getNom() + " s'équipe avec un " + stuff.toString());
//			
//			if (equipements[nbEquipement] != null && equipements[nbEquipement].equals(Equipement.BOUCLIER)) {
//				force += 8;
//			} else if (equipements[nbEquipement] != null && equipements[nbEquipement].equals(Equipement.CASQUE)) {
//				force += 5;
//			}
//			
//			break;
//		case 1:
//			if (equipements[0] == stuff) {
//				System.out.println("Le soldat " + getNom() + " possède dèja un " + stuff.toString());
//			} else {
//				equipements[nbEquipement] = stuff;
//				nbEquipement++;
//				System.out.println("Le soldat " + getNom() + " s'équipe avec un " + stuff.toString());
//				
//				if (equipements[nbEquipement].equals(Equipement.BOUCLIER)) {
//					force += 8;
//				} else if (equipements[nbEquipement].equals(Equipement.CASQUE)) {
//					force += 5;
//				}
//			}
//			break;
//		default:
//			System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
//			break;
//		}
//	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0 : 
			ajouterEquipement(equipement);
			break;
		case 1: 
            if (equipements[0] == equipement) { 
                System.out.println("Le soldat " + nom + " possède déjà un " + equipement.getNom() + " !");
            } else { 
            	ajouterEquipement(equipement);
            }
            break;
        case 2:  //Le romain possède déjà 2 équipements
            System.out.println("Le soldat " + nom + " est déjà bien protégé !");
            break;	
		}
	}
	
	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s’équipe avec un " + equipement.getNom() + " !");
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
	
//	private int calculResistanceEquipement(int forceCoup) {
//	String texte;
//	texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup + "donc ma nouvelle force devient ";
//	if (nbEquipement != 0) {
//		
//		for (int i = 0; i < nbEquipement; i++) {
//			if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
//				if (forceCoup > 8) {
//					force -= 8;
//					forceCoup -= 8;
//				} else  {
//					force -= forceCoup;
//				}
//			} else {
//				System.out.println("Equipement casque");
//				if (forceCoup > 5) {
//					force -= 5;
//					forceCoup -= 5;
//				} else  {
//					force -= forceCoup;
//				}
//			}
//		}
//		
//	}
//	parler(texte);
//	return forceCoup;
//}

	
//	private Equipement[] ejecterEquipement() {
//		Equipement[] equipementEjecte = new Equipement[nbEquipement];
//		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
//		int nbEquipementEjecte = 0;
//		for (int i = 0; i < nbEquipement; i++) {
//			if (equipements[i] != null) {
//				equipementEjecte[nbEquipementEjecte] = equipements[i];
//				nbEquipementEjecte++;
//				equipements[i] = null;
//			}
//		}
//		return equipementEjecte;
//	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				equipements[i] = null;
				nbEquipementEjecte++;
			}
		}
		nbEquipement = 0; 
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
