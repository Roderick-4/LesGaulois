package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
//	private String texte;
	
	private boolean invariantSatisfait(int force) {
		return force>0;
	}

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert invariantSatisfait(force): "Invariant creation";
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "'" + texte + "'");
	}

	private String prendreParole() {
		return "Le romain" + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		int avant = force;
		force -= forceCoup;
		assert invariantSatisfait(force): "Invariant fin recevoir coup";
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert invariantSatisfait(force): "Invariant fin recevoir coup";
		assert force < avant : "La force du romain doit avoir diminue"; // Postcondition
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le romain " + nom + "est deja bien protege !");
			break;
		case 1:
			if (nbEquipement == 0) {
				System.out.println("Le romain " + nom + " s'equipe avec un " + equipement + ".");
				nbEquipement += 1;
			}
			else if (nbEquipement == 2) {
				System.out.println("Le romain " + nom + " est deja bien protege ! ");
			}
			else {
				System.out.println("Le romain " + nom + " possede deja un " + equipement + ".");
			}
			break;
			
		case 0 :
			if (nbEquipement < 2) {
				System.out.println("Le romain " + nom + " s'equipe avec un " + equipement + ".");
				nbEquipement += 1;
			}
			else if (nbEquipement == 2) {
				System.out.println("Le romain " + nom + " est deja bien protege ! ");
			}
			else {
				System.out.println("Le romain " + nom + " possede deja un " + equipement + ".");
			}
			break;
		default:
			break;
		}
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
