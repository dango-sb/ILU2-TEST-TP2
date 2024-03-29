package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean venderReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!venderReconnu) {
			System.out.println("Mais vous n'etes pas inscrit sur note marche aujoud'hui!");
		}
		else {
			String[] donnesEtal = controlLibererEtal.libererEtal(nomVendeur); 
			System.out.println("Vous avez vendu "+ donnesEtal[4]+ " sur " + donnesEtal[3]+ donnesEtal[2]+" .\n");
			System.out.println("En revoir "+ donnesEtal[1] + ", passez une bonne journée.\n");
			donnesEtal[1]= null;
			donnesEtal[2]= null; 
			donnesEtal[3]= null; 
			donnesEtal[4]= null; 
		}
	}

}
