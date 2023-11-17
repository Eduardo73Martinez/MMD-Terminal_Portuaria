package model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BuqueTest {

	private Buque			buque;
	private Outbound		stateOutbound;
	private Inbound			stateInbound;
	private Arrived			stateArrived;
	private Working			stateWorking;
	private Departing		stateDeparting;
	
	private List<Carga> 	cargas 	  = new ArrayList<Carga>();
	private Posicion		posicion1 = new Posicion(2, 3);
	private GPS				gps 	  = new GPS(1);
	private Viaje			viaje;

	private Terminal		terminal;
	private Posicion		posicion2 = new Posicion(2, 5);
	
	private Carga			carga1;
	private Carga			carga2;
	private Carga			carga3;
	
	
	@BeforeEach
	public void setUp() {
		// DOC (Depended-On-Component): nuestros doubles
		this.terminal 	= spy(Terminal.class);
		this.carga1 	= mock(Carga.class);
		this.carga2 	= mock(Carga.class);
		this.carga3 	= mock(Carga.class);
		
		this.cargas.add(carga1);
		this.cargas.add(carga2);
		this.cargas.add(carga3);
//		when(this.carga1.getBuque()).thenReturn(terminal);

		// SUT (System Under Test): objeto a testear
		this.buque = new Buque(stateOutbound, gps, viaje);
	}

	@Test
	void testConstructor() {
		assertNotNull(this.buque);
	}

	@Test
	public void testPreavisoA() {
		assertFalse(this.terminal.hayBuqueCerca());
		this.buque.preavisoA(this.terminal);
		assertTrue(this.terminal.hayBuqueCerca());
	}

	@Test
	public void testDistanciaA() {
		float distanciaEsperada = 2;
		assertEquals(distanciaEsperada, this.buque.distanciaA(this.terminal));
	}
}