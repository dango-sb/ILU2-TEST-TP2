package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	ControlLibererEtal cle;
	ControlTrouverEtalVendeur ctev;
	Village village;
	Chef chef;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Vi", 10, 10);
		chef = new Chef("Chef", 1, village);
		village.setChef(chef);
		ctev = new ControlTrouverEtalVendeur(village);
		cle = new ControlLibererEtal(ctev);
	}

	@Test
	void testIsVendeur() {
		Gaulois gaulois1 = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(gaulois1);
		village.installerVendeur(gaulois1, "fleur", 5);
		Gaulois gaulois2 = new Gaulois("Obelix", 3);
		village.ajouterHabitant(gaulois2);
		assertFalse(cle.isVendeur("NonExistant"));
		assertTrue(cle.isVendeur("Bonemine"));
		assertFalse(cle.isVendeur("Obelix"));
	}

	@Test
	void testLibererEtal() {
		Gaulois gaulois1 = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(gaulois1);
		village.installerVendeur(gaulois1, "fleur", 5);
		String[] donnesEtal = {"true","Bonemine", "fleur", "5", "0"};
		String[] don = cle.libererEtal("Bonemine");
		
		for (int i = 0; i<5;i++) {
			assertEquals(don[i], donnesEtal[i]);
		}
		
		Gaulois gaulois2 = new Gaulois("Obelix", 3);
		village.ajouterHabitant(gaulois2);
		assertNull(cle.libererEtal("Obelix"));
		//assertNull(cle.libererEtal("Bonemine"));
	}

}
