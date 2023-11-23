/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
	private Factura factura;

	@BeforeEach
	void setUp() throws Exception {
		factura = mock(Factura.class);
		mensaje = "Llegando a destino";
		orden = mock(OrdenBasicaTP.class);
		email = new Email(mensaje, factura);

	}

	/**
	 * Test method for
	 * {@link model.Email#Email(java.lang.String, model.OrdenBasicaTP)}.
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
		when(factura.getOrden()).thenReturn(orden);
		assertEquals(email.getOrden(), orden);
	}

	@Test
	void testGetFactura() {
		assertEquals(email.getFactura(), factura);
	}

}
