/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Martinez Eduardo
 *
 */
class ViajeTest {
	private Buque buques;
	private CircuitoMaritimo circuito1;
	private Buque buque1;
	private Viaje viaje;
	private LocalDate fechaSalida = mock(LocalDate.class);;
	private Tramo t1 = mock(Tramo.class);
	private Tramo t2 = mock(Tramo.class);
	private Tramo t3 = mock(Tramo.class);
	private ArrayList<Tramo> tramos = new ArrayList<>();
	private Terminal terminal1 = mock(Terminal.class);
	private Terminal terminal2 = mock(Terminal.class);
	private Terminal terminal3 = mock(Terminal.class);
	private ArrayList<Tramo> tramos2 = new ArrayList<>();
	private OrdenBasicaTP orden = mock(OrdenBasicaTP.class);

	@BeforeEach
	void setUp() throws Exception {
		buque1 = mock(Buque.class);
		circuito1 = mock(CircuitoMaritimo.class);
		tramos.add(t1);
		tramos.add(t2);
		tramos.add(t3);
		viaje = new Viaje(fechaSalida, tramos, circuito1, buque1, orden);
	}

	@Test
	void testViaje() {
		assertEquals(viaje.getClass(), Viaje.class);
	}

	@Test
	void testGetFechaDeSalida() {
		assertEquals(fechaSalida, viaje.getFechaDeSalida());
	}

	@Test
	void testGetFechaDeLlegada() {
		when(t1.getTiempo()).thenReturn(10);
		when(t2.getTiempo()).thenReturn(9);
		when(t3.getTiempo()).thenReturn(3);
		
		viaje.getFechaDeLlegada();
		
		verify(t1).getTiempo();
		verify(t2).getTiempo();
		verify(t3).getTiempo();
	}

	@Test
	void testGetTerminalDestino() {
		when(t1.getDestino()).thenReturn(terminal1);
		when(t2.getDestino()).thenReturn(terminal2);
		when(t3.getDestino()).thenReturn(terminal3);
		
		viaje.getTerminalDestino();
		
		verify(t1, never()).getOrigen();
		verify(t2, never()).getOrigen();
		verify(t3).getOrigen();
		
		Viaje viaje2 = new Viaje(fechaSalida, tramos2, circuito1, buque1, orden);
		
		assertThrows(IndexOutOfBoundsException.class, ()->{viaje2.getTerminalDestino();});
	}

	@Test
	void testGetTerminalOrigen() {
		when(t1.getOrigen()).thenReturn(terminal1);
		when(t2.getOrigen()).thenReturn(terminal2);
		when(t3.getOrigen()).thenReturn(terminal3);
		
		viaje.getTerminalOrigen();
		
		verify(t1).getOrigen();
		verify(t2, never()).getOrigen();
		verify(t3, never()).getOrigen();
		
		Viaje viaje2 = new Viaje(fechaSalida, tramos2, circuito1, buque1, orden);
		
		assertThrows(IndexOutOfBoundsException.class, ()->{viaje2.getTerminalOrigen();});
		
	}

	@Test
	void testValidarViaje() {
		when(circuito1.getTramos()).thenReturn(tramos);
		
		assertDoesNotThrow(()->{viaje.validarViaje(tramos);});
		
		when(circuito1.getTramos()).thenReturn(tramos2);
		
		assertThrows(TramoExceptions.class, ()->{viaje.validarViaje(tramos);});
	}

	@Test 
	void getCostoTest() {
		when(t1.getPrecio()).thenReturn(1000.0);
		when(t2.getPrecio()).thenReturn(9000.0);
		when(t3.getPrecio()).thenReturn(30.0);
		
		viaje.getCosto();
		
		verify(t1).getPrecio();
		verify(t2).getPrecio();
		verify(t3).getPrecio();
	}

	@Test
	void getOrdenTest() {

		assertEquals(orden, viaje.getOrden());

	}

	@Test
	void getTramosTest() {
		assertEquals(tramos, viaje.getTramos());
	}

	@Test
	void getIndexTramosTest() {

		assertThrows(IndexOutOfBoundsException.class, () -> {
			viaje.getTramo(4);
		});
		assertEquals(t1, viaje.getTramo(0));
	}

	@Test 
	void todosLosTramosPertencenAlCircuitoTest() {
		when(circuito1.getTramos()).thenReturn(tramos);
		assertTrue(viaje.todosLosTramosPertencenAlCircuito(tramos));
	}

}
