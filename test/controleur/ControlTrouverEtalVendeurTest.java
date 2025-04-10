package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;


class ControlTrouverEtalVendeurTest {

	ControlTrouverEtalVendeur ctev;
	Village village;
	Chef chef;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Vi", 10, 10);
		chef = new Chef("Chef", 1, village);
		village.setChef(chef);

		ctev = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testTrouverEtalVendeur() {
		Gaulois gaulois1 = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(gaulois1);
		village.installerVendeur(gaulois1, "fleur", 5);
		Gaulois gaulois2 = new Gaulois("Obelix", 3);
		village.ajouterHabitant(gaulois2);
		assertNull(ctev.trouverEtalVendeur("NonExistant"));
		assertNotNull(ctev.trouverEtalVendeur("Bonemine"));
		assertNull(ctev.trouverEtalVendeur("Obelix"));
	}
}
