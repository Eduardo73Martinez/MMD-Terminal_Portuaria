/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author marti
 *
 */
class EmailTest {

	/**
	 * @throws java.lang.Exception
	 */
	private OrdenBasicaTP orden;
	
	private String mensaje;
	private Email email;
	
	@BeforeEach
	void setUp() throws Exception {
		mensaje = "Llegando a destino";
		orden = mock(OrdenBasicaTP.class);
		email = new Email(mensaje, orden);
		
	}

	/**
	 * Test method for {@link model.Email#Email(java.lang.String, model.OrdenBasicaTP)}.
	 */
	@Test
	void testEmail() {
		assertEquals(email.getClass(), Email.class);
	}

	/**
	 * Test method for {@link model.Email#getMensaje()}.
	 */
	@Test
	void testGetMensaje() {
		assertEquals(email.getMensaje(), "Llegando a destino");
	}

	/**
	 * Test method for {@link model.Email#getOrden()}.
	 */
	@Test
	void testGetOrden() {
		assertEquals(email.getOrden(), orden);
	}

}
