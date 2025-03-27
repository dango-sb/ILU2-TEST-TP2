package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef boss;
	@BeforeEach
	void init() {
		village = new Village("The Village", 10, 5);
		boss = new Chef("Pavel", 9, village);
		village.setChef(boss);
		Gaulois boris = new Gaulois("Boris", 5);
		village.ajouterHabitant(boris);
	}
	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite control = new ControlVerifierIdentite(village);
		assertTrue(control.verifierIdentite("Boris"));
		assertFalse(control.verifierIdentite("Sobaka"));
	}

}
