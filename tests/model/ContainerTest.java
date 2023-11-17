/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author Martinez Eduardo
 *
 */
class ContainerTest {
	private Reefer containerRefrigerado;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		containerRefrigerado = new containerRefrigerado(8, 30 ,2, 7, 900);
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
	void testGetPeso() {
		assertEquals(containerRefrigerado.getPeso(), 7);
	}
	@Test
	void testConsumoKWh() {
		assertEquals(containerRefrigerado.getConsumo(),900);
	}

}
