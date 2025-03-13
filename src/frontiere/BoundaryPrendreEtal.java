package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu) {
			System.out.println("Je suis désolée " + nomVendeur + " mais il faut être un "
					+ "habitant de notre village pour commercer ici");
		}
		else {
			System.out.println("Bonjour " + nomVendeur + " ,je vais "
					+ "regarder si je peux vous trouver un étal");
			boolean etalDispo = controlPrendreEtal.resteEtals();
			
			if(!etalDispo) {
				System.out.println("Désolée " + nomVendeur + " je n'ai plus"
						+ " d'étal qui ne soit pas déjà occupé.");
			}
			else {
				this.installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		String produit = Clavier.entrerChaine("C'est parfait, il me reste un étal pour vous!\n"
				+ "Il me faudrait quelques renseignements:\n"
				+ "Quel produit souhaitez-vous vendre?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal!=-1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'etal n" + numeroEtal);
		}
	}
}
