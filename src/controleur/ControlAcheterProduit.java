package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;


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
	
	public boolean verifierIdentite(String nomVendeur) {
		return village.trouverHabitant(nomVendeur)!=null;
	}
	
	public boolean produitPresente(String produit) {
		return village.rechercherVendeursProduit(produit) != null;
	}
	
	public Gaulois[] getVendeurs(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public void acheterProduit(String nomAcheteur, Gaulois vendeur, int quantiteDesiree, String produit) {
		Etal etal = village.rechercherEtal(vendeur);
		int quantiteAchetee = etal.acheterProduit(quantiteDesiree);
		if (quantiteAchetee==0) {
			System.out.println(nomAcheteur + " veut acheter " + String.valueOf(quantiteDesiree) + produit + ",\n"
					+ "malheureusement il n’y en a plus !");
		}
		else if (quantiteAchetee<quantiteDesiree) {
			System.out.println(nomAcheteur + " veut acheter " + String.valueOf(quantiteDesiree) + " " + produit
					+ " malheureusement "+ vendeur.getNom() +" n’en a"
					+ "plus que " + String.valueOf(quantiteAchetee) + ".\n" 
					+ nomAcheteur + " achete tout le stock de " + vendeur.getNom() +".");
		}
		else if (quantiteAchetee==quantiteDesiree) {
			System.out.println(nomAcheteur + " achete " + String.valueOf(quantiteDesiree) + produit + " a " + vendeur.getNom());
		}
	}
	//TODO a completer
}
