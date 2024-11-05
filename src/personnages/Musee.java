package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200] ;
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		if (nbTrophee < 200) {
			trophees[nbTrophee] = new Trophee(gaulois, equipement);
			nbTrophee ++;	
		}
	}

	public String extraireInstructionsOCaml(){
		String text = "let musee = [\n";
		for (int i = 0; i < nbTrophee; i++){
			text += "\"" + trophees[i].donnerNom() + "\", \"" + trophees[i].getEquipement() + "\"";
			if (i != nbTrophee - 1) {
				text += ";\n";
			}
		}
		text += "\n]";
		return text;
	}
}
