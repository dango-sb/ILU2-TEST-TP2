package controleur;

import personnages.Gaulois;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	
	ControlPrendreEtal cpe;
	ControlVerifierIdentite cvi;
	
	@BeforeEach
	void setUp() throws Exception {
		
		Village village = new Village("Vi",10,2);
		Chef chef = new Chef("Chef",1,village);
		Gaulois gaulois1 = new Gaulois("Obelix", 5);
		village.ajouterHabitant(gaulois1);
		Gaulois gaulois2 = new Gaulois("Bonemine", 3);
		village.setChef(chef);
		cvi = new ControlVerifierIdentite(village);
		cpe = new ControlPrendreEtal(cvi,village);
		
	}

	@Test
	void testResteEtals() {
		assertTrue(cpe.resteEtals());
		cpe.prendreEtal("Obelix", "fleur", 5);
		cpe.prendreEtal("Obelix", "chaise", 3);
		assertFalse(cpe.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		int numeroEtal = cpe.prendreEtal("Obelix", "fleur", 5);
		assertTrue(numeroEtal == 0); 
	}

	@Test
	void testVerifierIdentite() {
		assertFalse(cpe.verifierIdentite("Bonemine"));
		assertTrue(cpe.verifierIdentite("Obelix"));
	}

}
