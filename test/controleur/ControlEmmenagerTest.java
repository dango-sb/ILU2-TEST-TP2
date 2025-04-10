package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;




class ControlEmmenagerTest {
	ControlEmmenager cm;
	ControlAfficherVillage caff;
	
	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Vi",10,10);
		Chef chef = new Chef("Chef",1,village);
		village.setChef(chef);
		cm = new ControlEmmenager(village);
		caff = new ControlAfficherVillage(village);
		
		
	}

	@Test
	void testIsHabitant() {
		assertFalse(cm.isHabitant("Gaulois"));
		cm.ajouterGaulois("Gaulois",3);
		assertTrue(cm.isHabitant("Gaulois"));
	}

	@Test
	void testAjouterDruide() {
		cm.ajouterDruide("Druide",2,1,5);
		String[] villageois = caff.donnerNomsVillageois();
		assertTrue(villageois[1].contains("Druide"));	}

	@Test
	void testAjouterGaulois() {
		cm.ajouterGaulois("Gaulois",3);
		String[] villageois = caff.donnerNomsVillageois();
		assertEquals(villageois[1], "Gaulois");
	}

}
