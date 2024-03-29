package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis desole" + nomAcheteur
					+ "mais il faut etre un habitant "
					+ "de notre village pour commercer ici");
		}
		else {
			System.out.println("Quel produit voulez-vous acheter?");
			String produit = scan.next();
			if (!controlAcheterProduit.produitPresente(produit)) {
				System.out.println("Desole, personne ne vend ce produit au marche.");
			}
			else {
				StringBuilder question = new StringBuilder();
				question.append("Chez quel commercant  voulez-vous acheter des " + produit + "?\n");
				Gaulois[] vendeurs = controlAcheterProduit.getVendeurs(produit); 
				for (int i = 0; i<vendeurs.length; i++) {
					String stri = String.valueOf(i + 1);
					question.append(stri + " - " + vendeurs[i].getNom() + "\n");
				}
				int choixUtilisateur = 0;
				do {
					choixUtilisateur = Clavier.entrerEntier(question.toString()) - 1;
					if (choixUtilisateur>=vendeurs.length) {
						System.out.println("Vous devez entrer un chiffre entre 1 et " +  String.valueOf(vendeurs.length));
					}					
				} while (choixUtilisateur>=vendeurs.length || choixUtilisateur < 0);
				Gaulois vendeur = vendeurs[choixUtilisateur];
				System.out.println(nomAcheteur + " se deplace jusqu'a l'etal du vendeur " + vendeur.getNom());
				int quantite = Clavier.entrerEntier("Bonjour " + nomAcheteur + "\nCombien de " + produit + " voulez-vous acheter ?");
				controlAcheterProduit.acheterProduit(nomAcheteur, vendeur, quantite, produit);
			}
		}
	}
}
