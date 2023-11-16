/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Martinez Eduardo
 *
 */
class TramoTest {
	private Tramo tramo;
	private Terminal terminal1 = mock(Terminal.class);
	private Terminal terminal2 = mock(Terminal.class);
	private Terminal terminal3;
	/**
	 * instancio como una clase mock a las terminales  antes del setUp 
	 * porque en el getter los comparo y si lo instancio antes de cada test se generan 
	 * diferentes objetos y no los puedo comparar.
	 * @throws Exception
	 */

	@BeforeEach
	void setUp() throws Exception {
		Terminal terminal3 = mock(Terminal.class);

		tramo = new Tramo(terminal1, terminal2, 300, 4);
	}

	@Test
	void testConstructorTramo() {
		assertEquals(Tramo.class, tramo.getClass());
	}

	@Test
	void testGetOrigen() {
		assertEquals(terminal1, tramo.getOrigen());
	}

	@Test
	void testGetDestino() {
		assertEquals(terminal2, tramo.getDestino());
	}

	@Test
	void testGetTiempo() {
		assertEquals(4, tramo.getTiempo());
	}

	@Test
	void testGetPrecio() {
		assertEquals(300, tramo.getPrecio());
	}

	@Test
	void testSetDestino() {
		tramo.setDestino(terminal3);
		assertEquals(terminal3, tramo.getDestino());
	}

	@Test
	void testSetOrigen() {
		tramo.setOrigen(terminal3);
		assertEquals(terminal3, tramo.getOrigen());
	}

}
