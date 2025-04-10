package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean isHabitant = controlAcheterProduit.isHabitant(nomAcheteur);
		if (!isHabitant)
			System.out.println("Je suis désolée " + nomAcheteur + " mais il\n"
					+ " faut être un habitant de notre\n"
					+ " village pour commercer ici.");
		else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			if (!controlAcheterProduit.produitExiste(produit))
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			else {
				int numVendeur = Clavier.entrerEntier("Chez quel commerçant voulez-vous\r\n"
						+ "acheter des " + produit + " ?" + controlAcheterProduit.afficherVendeursProduit(produit))-1;
				String nomVendeur = controlAcheterProduit.getVendeur(numVendeur, produit).getNom();
				int nbAcheter = Clavier.entrerEntier(nomAcheteur + " se déplace jusqu'à l'étal\r\n"
						+ "du vendeur " + nomVendeur
						+ ". Bonjour " + nomAcheteur + ",\n"
						+ "Combien de " + produit + " voulez-vous "
						+ "acheter ?");
				int quantiteAchete = controlAcheterProduit.acheterProduit(numVendeur, produit, nbAcheter);
				
				if (nbAcheter == quantiteAchete)
					System.out.println(nomAcheteur + " achète " + String.valueOf(quantiteAchete) + " " + produit + " à " + nomVendeur);
				else if (quantiteAchete==0)
					System.out.println(nomAcheteur + " veut acheter " + String.valueOf(nbAcheter) + " " + produit
							+ ", malhereusement il n'y en a plus !");
				else
					System.out.println(nomAcheteur + " veut acheter " + String.valueOf(nbAcheter) + " " + produit 
							+ ", malhereusement " + nomVendeur + " n'en a plus que " + String.valueOf(quantiteAchete) + ". " + nomAcheteur + " acète tout le stock.");
			}
		}
	}
}
