package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder questionVilageois = new StringBuilder();
					int force;
					questionVilageois.append("Bienvenue villageois " + nomVisiteur + " .\n");
					questionVilageois.append("Quelle est votre force ?\n");
					force = Clavier.entrerEntier(questionVilageois.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		int forceDruide;
		int forceMax = 0;
		int forceMin = 1;
		question.append("Bienvenue druide " + nomVisiteur + " .\n");
		question.append("Quelle est votre force ? \n");
		forceDruide = Clavier.entrerEntier(question.toString());
		while (forceMax<forceMin) {
			
			forceMax = Clavier.entrerEntier("Quelle est la force de potion la\n"
					+ "plus forte que vous produisez ?\n");
			forceMin = Clavier.entrerEntier("Quelle est la force de potion la\n"
					+ "plus fable que vous produisez ?\n");
			if (forceMax<forceMin) {
				System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, forceMax, forceMin);
	}
}
