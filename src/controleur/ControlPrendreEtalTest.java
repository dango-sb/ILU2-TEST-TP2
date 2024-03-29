package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le villae des irréductibles", 10, 2);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
		Gaulois gaulois1 = new Gaulois("Venty", 7);
		village.installerVendeur(gaulois1, "fleurs", 10);
		assertTrue(controlPrendreEtal.resteEtals());
		Gaulois gaulois2 = new Gaulois("Rodd", 7);
		village.installerVendeur(gaulois2, "hot wheels", 4);
		assertFalse(controlPrendreEtal.resteEtals());
	}
	
	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		Gaulois gaulois = new Gaulois("Venty", 7);
		village.ajouterHabitant(gaulois);
		int indiceEtal = controlPrendreEtal.prendreEtal("Venty","fleurs",7);
		assertNotNull(village.rechercherVendeursProduit("fleurs"));
		assertTrue(indiceEtal<2);
	}
	
	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		Gaulois gaulois = new Gaulois("Venty", 7);
		village.ajouterHabitant(gaulois);
		assertTrue(controlPrendreEtal.verifierIdentite("Venty"));
		assertFalse(controlPrendreEtal.verifierIdentite("Joseph Jostar"));
	}
}
