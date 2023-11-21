package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTransporteTest {
	
	//Atributos generales
	EmpresaTransporte empresa1;
	Camion			  camion1;
	Chofer			  chofer1;

	//DOC
	@BeforeEach
	void setUp() throws Exception {
	
	//SUT
	this.empresa1 = new EmpresaTransporte();

	}

	@Test
	void testConsructor() {
		assertNotNull(empresa1);
	}
	
	@Test
	void testGetCamiones() {
		assertTrue(empresa1.getCamiones().isEmpty());
	}

	@Test
	void testAgregarCamion() {
		empresa1.agregarCamion(camion1);
		assertTrue(empresa1.getCamiones().contains(camion1));
	}
	
	@Test
	void testQuitarCamion() {
		empresa1.agregarCamion(camion1);
		empresa1.quitarCamion(camion1);
		assertFalse(empresa1.getCamiones().contains(camion1));
	}
	
	@Test
	void testGetChoferes() {
		assertTrue(empresa1.getChoferes().isEmpty());
	}

	@Test
	void testAgregarChofer() {
		empresa1.agregarChofer(chofer1);
		assertTrue(empresa1.getChoferes().contains(chofer1));
	}
	
	@Test
	void testQuitarchofer() {
		empresa1.agregarChofer(chofer1);
		empresa1.quitarChofer(chofer1);
		assertFalse(empresa1.getChoferes().contains(chofer1));
	}
	
}
