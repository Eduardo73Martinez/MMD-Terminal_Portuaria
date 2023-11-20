package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTransporteTest {
	
	//Atributos generales
	EmpresaTransporte empresa1;
	Camion			  camion1;

	@BeforeEach
	void setUp() throws Exception {
		this.empresa1 = new EmpresaTransporte();
	}

	@Test
	void testGetCamiones() {
		this.empresa1.agregarCamion(camion1);
		assertTrue(empresa1.getCamiones().contains(camion1));
		this.empresa1.quitarCamion(camion1);
	}

}
