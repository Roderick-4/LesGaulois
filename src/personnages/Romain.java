package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "'" + texte + "'");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		assert force > 0;
		int avant = force;
		force -= forceCoup;

		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		
		assert force<avant;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (equipement) {
		case CASQUE :
			if (nbEquipement == 0) {
				System.out.println("Le romain " + nom + " s'�quipe avec un " + equipement + ".");
				nbEquipement += 1;
			}
			else if (nbEquipement == 2) {
				System.out.println("Le romain " + nom + " est d�j� bien prot�g� ! ");
			}
			else {
				System.out.println("Le romain " + nom + " poss�de d�j� un " + equipement + ".");
			}
			break;
			
		case BOUCLIER :
			if (nbEquipement < 2) {
				System.out.println("Le romain " + nom + " s'�quipe avec un " + equipement + ".");
				nbEquipement += 1;
			}
			else if (nbEquipement == 2) {
				System.out.println("Le romain " + nom + " est d�j� bien prot�g� ! ");
			}
			else {
				System.out.println("Le romain " + nom + " poss�de d�j� un " + equipement + ".");
			}
			break;
		}
	}
	
	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus",6);
		minus.parler("Bonjour");
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}

}
