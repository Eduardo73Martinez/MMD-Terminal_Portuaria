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
	private Terminal terminal1;
	private Terminal terminal2;
	private Terminal terminal3;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		Terminal terminal1 = mock(Terminal.class);
		Terminal terminal2 = mock(Terminal.class);
		Terminal terminal3 = mock(Terminal.class);
		
		tramo = new Tramo(terminal1, terminal2, 300, 4);
	}
	
	@Test
	void testConstructorTramo() {
		assertEquals(Tramo.class,tramo.getClass() );
	}

	/**
	 * Test method for {@link model.Tramo#getOrigen()}.
	 */
	@Test
	void testGetOrigen() {
		assertEquals(terminal1, tramo.getOrigen());
	}

	/**
	 * Test method for {@link model.Tramo#getDestino()}.
	 */
	@Test
	void testGetDestino() {
		assertEquals(terminal2, tramo.getDestino());
	}

	/**
	 * Test method for {@link model.Tramo#getTiempo()}.
	 */
	@Test
	void testGetTiempo() {
		assertEquals(4, tramo.getTiempo());
	}

	/**
	 * Test method for {@link model.Tramo#getPrecio()}.
	 */
	@Test
	void testGetPrecio() {
		assertEquals(300, tramo.getPrecio());
	}

	/**
	 * Test method for {@link model.Tramo#setDestino(model.Terminal)}.
	 */
	@Test
	void testSetDestino() {
		tramo.setDestino(terminal3);
		assertEquals(terminal3, tramo.getDestino());
	}

	/**
	 * Test method for {@link model.Tramo#setOrigen(model.Terminal)}.
	 */
	@Test
	void testSetOrigen() {
		tramo.setOrigen(terminal3);
		assertEquals(terminal3, tramo.getOrigen());
	}

}
