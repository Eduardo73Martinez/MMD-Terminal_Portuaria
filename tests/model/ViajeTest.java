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
	private LocalDate fechaSalida = LocalDate.now();
	private Tramo t1 = mock(Tramo.class);
	private Tramo t2 = mock(Tramo.class);
	private Tramo t3 = mock(Tramo.class);
	private ArrayList<Tramo> tramos = new ArrayList<>();
	private Terminal terminal1 = mock(Terminal.class);
	private Terminal terminal2 = mock(Terminal.class);
	private ArrayList<Tramo> tramos2 = new ArrayList<>();
	private OrdenBasicaTP orden = mock(OrdenBasicaTP.class);

	@BeforeEach
	void setUp() throws Exception {
		buque1 = mock(Buque.class);
		circuito1 = mock(CircuitoMaritimo.class);
		tramos.add(t1);
		tramos.add(t2);
		tramos.add(t3);
		viaje = new Viaje(fechaSalida, circuito1, buque1, orden);
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
		when(circuito1.tiempoTotalDelCircuito()).thenReturn(45);
		
		viaje.getFechaDeLlegada();
		
		verify(circuito1).tiempoTotalDelCircuito();
		
	}

	@Test
	void testGetTerminalDestino() {
		when(circuito1.getTerminalDestino()).thenReturn(terminal2);
		
		viaje.getTerminalDestino();
		
		verify(circuito1).getTerminalDestino();
	}

	@Test
	void testGetTerminalOrigen() {
		when(circuito1.getTerminalOrigen()).thenReturn(terminal1);
		
		viaje.getTerminalOrigen();
		
		verify(circuito1).getTerminalOrigen();
		
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
		when(circuito1.precioTotal()).thenReturn(1000.0);
	
		
		viaje.getCosto();
		
		verify(circuito1).precioTotal();
	
	}

	@Test
	void getOrdenTest() {

		assertEquals(orden, viaje.getOrden());

	}

	@Test
	void getIndexTramosTest() {
		when(circuito1.getTramos()).thenReturn(tramos);
		
		viaje.getTramo(0);
		
		verify(circuito1).getTramos();
		
		assertThrows(IndexOutOfBoundsException.class, ()->{viaje.getTramo(5);});
		
	}

	@Test 
	void todosLosTramosPertencenAlCircuitoTest() {
		when(circuito1.getTramos()).thenReturn(tramos);
		assertTrue(viaje.todosLosTramosPertencenAlCircuito(tramos));
	}

	@Test
	void getBuqueTest() {
		assertEquals(buque1, viaje.getBuque());
	}

}
