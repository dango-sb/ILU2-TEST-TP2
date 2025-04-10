package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	ControlAfficherMarche cam;
	Village village;
	Chef chef;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Vi", 10, 10);
		chef = new Chef("Chef", 1, village);
		village.setChef(chef);

		cam = new ControlAfficherMarche(village);
	}

	@Test
	void testDonnerInfosMarche() {
		Gaulois gaulois1 = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(gaulois1);
		village.installerVendeur(gaulois1, "fleur", 5);
		
		Gaulois gaulois2 = new Gaulois("John", 3);
		village.ajouterHabitant(gaulois2);
		village.installerVendeur(gaulois2, "dynamite", 77);
		
		String[] etatValide = {"Bonemine", "5", "fleur", "John", "77", "dynamite"};
		String[] etatTest = cam.donnerInfosMarche();
		for (int i = 0; i < 6; i++) {
			assertEquals(etatValide[i], etatTest[i]);
		}
		
		Gaulois gaulois3 = new Gaulois("Bob", 3);
		village.ajouterHabitant(gaulois3);
		village.installerVendeur(gaulois3, "happiness", 1);
		
		etatTest = cam.donnerInfosMarche();
		assertNotEquals(etatTest.length, etatValide.length);
	}

}
