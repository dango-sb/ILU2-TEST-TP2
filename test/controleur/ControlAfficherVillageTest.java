package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef boss;
	@BeforeEach
	void init() {
		village = new Village("The Village", 10, 5);
		boss = new Chef("Pavel", 9, village);
		village.setChef(boss);
		Gaulois boris = new Gaulois("Boris", 5);
		Gaulois andrey = new Gaulois("Andrey", 2);
		village.ajouterHabitant(andrey);
		village.ajouterHabitant(boris);
	}
	
	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage control = new ControlAfficherVillage(village);

		assertNotEquals(0, control.donnerNomsVillageois().length);
		assertEquals(3, control.donnerNomsVillageois().length);
		Gaulois kostya = new Gaulois("Kostya", 7);
		village.ajouterHabitant(kostya);
		assertEquals(4, control.donnerNomsVillageois().length);
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage control = new ControlAfficherVillage(village);
		assertTrue("The Village"==control.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage control = new ControlAfficherVillage(village);
		Gaulois kostya = new Gaulois("Kostya", 7);
		village.ajouterHabitant(kostya);
		village.installerVendeur(kostya, "fleurs", 1);
		assertEquals(5,control.donnerNbEtals());
		
	}

}
