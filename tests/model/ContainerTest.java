/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Martinez Eduardo
 *
 */
class ContainerTest {
	private Reefer containerRefrigerado;

	@BeforeEach
	void setUp(){
		containerRefrigerado = new Reefer(8, 30 ,2, 7, 900);
	}

	@Test
	void testConsTructor() {
		assertEquals(containerRefrigerado.getClass(), Reefer.class);
	}
	@Test
	void testGetAncho() {
		assertEquals(containerRefrigerado.getAncho(), 8);
	}
	@Test
	void testGetLargo() {
		assertEquals(containerRefrigerado.getLargo(), 30);
	}
	@Test
	void testGetAlto() {
		assertEquals(containerRefrigerado.getAlto(), 2);
	}
	@Test
	void testGetPeso() {
		assertEquals(containerRefrigerado.getPeso(), 7);
	}
	@Test
	void testConsumoKWh() {
		assertEquals(containerRefrigerado.getConsumo(),900);
	}

}
