package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	ControlVerifierIdentite cvi;
	Village village;
	Chef chef;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Vi", 10, 10);
		chef = new Chef("Chef", 1, village);
		village.setChef(chef);

		cvi = new ControlVerifierIdentite(village);
	}


	@Test
	void testVerifierIdentite() {
		Gaulois gaulois1 = new Gaulois("Bonemine", 3);
		
		assertFalse(cvi.verifierIdentite("Bonemine"));
		
		village.ajouterHabitant(gaulois1);
		
		assertTrue(cvi.verifierIdentite("Bonemine"));
		
		assertTrue(cvi.verifierIdentite("Chef"));
		
	}

}
