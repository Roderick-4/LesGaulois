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
	
	public int getNbEquipement() {
	    return nbEquipement;
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


	public void sEquiper(Equipement equipement) {
	    switch (nbEquipement) {
	        case 2:
	            System.out.println("Le romain " + nom + " est déjà bien protégé !");
	            break;
	        case 1:
	            // Vérifier si le Romain possède déjà l'équipement qu'il veut ajouter
	            if (equipementsTab[0] == equipement) {
	                System.out.println("Le romain " + nom + " possède déjà un " + equipement + ".");
	            } else {
	                System.out.println("Le soldat s'équipe avec un " + equipement + " !");
	                equipementsTab[nbEquipement] = equipement;
	                nbEquipement++;
	            }
	            break;
	        case 0:
	            System.out.println("Le soldat s'équipe avec un " + equipement + " !");
	            equipementsTab[nbEquipement] = equipement;
	            nbEquipement++;
	            break;
	        default:
	            System.out.println("Erreur dans le nombre d'équipements.");
	            break;
	    }
	}

	
	private int calculResistanceEquipement(int forceCoup) {
	    texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
	    int resistanceEquipement = 0;

	    if (nbEquipement != 0) {
	        texte += "\nMais heureusement, grâce à mon équipement sa force est diminuée de ";

	        for (int i = 0; i < nbEquipement; i++) {
	            if (equipementsTab[i] != null && equipementsTab[i].equals(Equipement.BOUCLIER)) {
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
	    return forceCoup;
	}

	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'equipement de " + nom.toString() + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		
		for (int i = 0; i < nbEquipement; i++) {
			if (equipementsTab[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipementsTab[i];
	            nbEquipementEjecte++;
	            equipementsTab[i] = null;
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
	    System.out.println("Le nombre d'équipements de " + minus.getNom() + " est de " + minus.getNbEquipement() + ".");
		minus.recevoirCoup(5);
	    System.out.println("La force de " + minus.getNom() + " est de " + minus.getForce() + ".");


	}

}
