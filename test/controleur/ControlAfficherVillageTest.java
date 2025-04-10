package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	ControlAfficherVillage cav;
	Village village;
	Chef chef;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Vi", 10, 10);
		chef = new Chef("Chef", 1, village);
		village.setChef(chef);
		cav = new ControlAfficherVillage(village);
	}

	@Test
	void testDonnerNomsVillageois() {
		Gaulois gaulois1 = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(gaulois1);
		Druide druide1 = new Druide("Obelix", 3, 0, 2);
		village.ajouterHabitant(druide1);
		String[] noms = {"Chef", "Bonemine", "le druide Obelix"};
		for (int i = 0;i<3;i++) {
			assertEquals(noms[i], cav.donnerNomsVillageois()[i]);
		}
		
		Druide druide2 = new Druide("Aaron", 3, 0, 2);
		village.ajouterHabitant(druide2);
		
		assertNotEquals(noms.length, cav.donnerNomsVillageois().length);

	}

	@Test
	void testDonnerNomVillage() {
		assertEquals("Vi", cav.donnerNomVillage());
		assertNotEquals("AbcdVille", cav.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		assertTrue(cav.donnerNbEtals()==10);
	}

}
