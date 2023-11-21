package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CamionTest {

	//Atributos generales
	Camion camion1;
	Chofer chofer1;
	Turno  turno1;
	Carga  carga1;
	
	@BeforeEach
	void setUp() throws Exception {
	// DOC
		
	//SUT
		this.camion1 = new Camion();
	}

	@Test
	void testConstructor() {
		assertNotNull(camion1);
	}
	
	@Test
	void testGetChofer() {
		assertNull(camion1.getChofer());
	}
	
	@Test
	void testSetChofer() {
		camion1.setChofer(chofer1);
		assertEquals(chofer1, camion1.getChofer());
	}

	@Test
	void testGetTurno() {
		assertNull(camion1.getTurno());
	}
	
	@Test
	void testSetTurno() {
		camion1.setTurno(turno1);
		assertEquals(turno1, camion1.getTurno());
	}
	
	@Test
	void testGetCargas() {
		assertTrue(camion1.getCargas().isEmpty());
	}

	@Test
	void testAgregarCarga() {
		camion1.agregarCarga(carga1);
		assertTrue(camion1.getCargas().contains(carga1));
	}
	
	@Test
	void testQuitarcarga() {
		camion1.agregarCarga(carga1);
		camion1.quitarCarga(carga1);
		assertFalse(camion1.getCargas().contains(carga1));
	}
	
}
