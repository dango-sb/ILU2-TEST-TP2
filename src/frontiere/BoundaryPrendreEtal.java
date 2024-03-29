package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;
import villagegaulois.Village;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println("Je suis desolee " + nomVendeur + " mais il faut etre un "
					+ "habitant de notre village pour commercer ici.");
		}
		
		
		else {
			System.out.println("Bonjour " + nomVendeur + " ,je vais "
					+ "regarder si je peux vous trouver un etal");
			boolean etalDisponible =  controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				System.out.println("Desolee " + nomVendeur + " je n'ai plus "				
						+ "d'étal qui ne soit pas deja occupé");
			}
			else {
				this.installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un etal pour vous !\n"
				+ "Il me faudrait quelques renseignements : \n"
				+ "Quel produit souhaitez-vous vendre ?");
		String produit = scan.next();
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vouz en vendre ?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal!=-1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installe a l'etal n°" + numeroEtal);
		}
	}
}
