package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlEmmenagerTest {
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
	void testIsHabitant() {
		ControlEmmenager control = new ControlEmmenager(village);
		Gaulois misha = new Gaulois("Misha", 5);
		assertTrue(control.isHabitant("Andrey"));
		assertFalse(control.isHabitant("Misha"));
	}

	@Test
	void testAjouterDruide() {
		ControlEmmenager control = new ControlEmmenager(village);
		assertFalse(control.isHabitant("Misha"));
		control.ajouterDruide("Misha", 5, 1, 7);
		assertTrue(control.isHabitant("Misha"));
	}

	@Test
	void testAjouterGaulois() {
		ControlEmmenager control = new ControlEmmenager(village);
		assertFalse(control.isHabitant("Misha"));
		control.ajouterGaulois("Misha", 5);
		assertTrue(control.isHabitant("Misha"));
		
	}

}
