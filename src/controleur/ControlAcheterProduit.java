package controleur;

import villagegaulois.Village;
import personnages.Gaulois;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isHabitant(String nomClient) {
		return controlVerifierIdentite.verifierIdentite(nomClient);
	}
	
	public boolean produitExiste(String nomProduit) {
		return village.rechercherVendeursProduit(nomProduit).length != 0;
	}
	
	public void afficherVendeursProduit(String nomProduit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(nomProduit);
		for(int i=0;i<vendeurs.length;i++)
			System.out.println("- " + String.valueOf(i+1) + vendeurs[i]);
	}
	
	public Gaulois getVendeur(int idVendeur, String nomProduit) {
		Gaulois vendeur = village.rechercherVendeursProduit(nomProduit)[idVendeur];
		return vendeur;
	}
	
	public int acheterProduit(int idVendeur, String nomProduit, int nbProduit) {
		 Gaulois vendeur = this.getVendeur(idVendeur, nomProduit);
		 int quantiteAchete = village.rechercherEtal(vendeur).acheterProduit(nbProduit);
		 return quantiteAchete;
	}
}
