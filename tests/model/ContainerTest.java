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
	private Tanque tanque;
	private Dry seco;

	@BeforeEach
	void setUp(){
		containerRefrigerado = new Reefer(8, 30 ,2, 7, 900);
		tanque = new Tanque(0, 0, 0, 0); 	// solo testeo el constructor 
		seco = new Dry(0,0,0,0);			// solo testeo el constructor
	}

	@Test
	void testConsTructor() {
		assertEquals(containerRefrigerado.getClass(), Reefer.class);
		assertEquals(tanque.getClass(), Tanque.class);
		assertEquals(seco.getClass(), Dry.class);
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
