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
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerGaulois(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		question.append("Bienvenu villageois " + nomVisiteur + ".");
		question.append("Quelle est votre force?");
		int forceGaulois = Clavier.entrerEntier(question.toString());
		controlEmmenager.ajouterGaulois(nomVisiteur, forceGaulois);
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		question.append("Beinvenu druide " + nomVisiteur + ".");
		question.append("Quelle est votre force?");
		int forceDruide = Clavier.entrerEntier(question.toString());
		int effetPotionMax = 0;
		int effetPotionMin = 1;
		while (effetPotionMax<effetPotionMin) {
			effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion plus faible que vous produisez?");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion plus forte que vous produisez?");
			if (effetPotionMax<effetPotionMin) {
				System.out.println("Attention Druide, vous vous etes trompe entre le minimum et le maximum");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
