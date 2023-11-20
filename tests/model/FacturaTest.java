/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Martinez Eduardo 
 *
 */
import java.util.Date;
class FacturaTest {

	/**
	 * @throws java.lang.Exception
	 */
	private Factura factura;
	private Factura factura2;
	private String cliente;
	private Date fechaFactura = new Date();
	private OrdenExportacion ordenExportacion;
	private OrdenImportacion ordenImportacion;
	
	@BeforeEach
	void setUp() throws Exception {
		ordenExportacion = mock(OrdenExportacion.class);
		ordenImportacion = mock(OrdenImportacion.class);
		cliente = "Nombre cliente";
		factura = new Factura(fechaFactura, cliente, ordenImportacion);
		factura2 = new Factura(fechaFactura, cliente, ordenExportacion);
	}

	@Test
	void testConstructor() {
		assertEquals(factura.getClass(), Factura.class);
	}
	@Test
	void getFechaTest() {
		assertEquals(factura.getFecha(), fechaFactura);
	}
	@Test
	void getMontoTest() {
		when(ordenImportacion.getMontoTotal()).thenReturn(400.0);
		when(ordenExportacion.getMontoTotal()).thenReturn(600.0);
		factura.getMontoTotal();
		factura2.getMontoTotal();
		verify(ordenImportacion).getMontoTotal();
		verify(ordenExportacion).getMontoTotal();
	}
	@Test
	void getOrdentest() {
		assertEquals(factura.getOrden(), ordenImportacion);
		assertEquals(factura2.getOrden(), ordenExportacion);
	}
	@Test
	void getClientetest() {
		assertEquals(factura.getCliente(), cliente);
		assertEquals(factura2.getCliente(), cliente);
	}
	

}
