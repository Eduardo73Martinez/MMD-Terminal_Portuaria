package model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Inactive;

import java.util.ArrayList;
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
	private GPS				gps;
	private Viaje			viaje;

	private Terminal		terminal1;
	private Terminal		terminal2;
	private Posicion		posicion2 = new Posicion(2, 4);
	private Posicion		posicion3 = new Posicion(2, 60);
	
	private Carga			carga1;
	private Carga			carga2;
	private Carga			carga3;
	private Email 			email;
	private OrdenBasicaTP 	orden = mock(OrdenBasicaTP.class);
	
	
	@BeforeEach
	public void setUp() {
		// DOC (Depended-On-Component): nuestros doubles

		this.terminal1 		= mock(Terminal.class);
		this.terminal2 		= mock(Terminal.class);
		this.viaje			= mock(Viaje.class);
		this.gps			= spy(new GPS(1, posicion1));
		this.email 			= mock(Email.class);

		this.stateOutbound  = spy(new Outbound());
		this.stateDeparting	= spy(new Departing(stateOutbound));
		this.stateWorking	= spy(new Working(stateDeparting));
		this.stateArrived	= spy(new Arrived(stateWorking));
		this.stateInbound	= spy(new Inbound(stateArrived));
		this.stateOutbound.setSiguiente(stateInbound);

		this.carga1 		= mock(Carga.class);
		this.carga2 		= mock(Carga.class);
		this.carga3 		= mock(Carga.class);
		this.cargas.add(carga1);
		this.cargas.add(carga2);
		this.cargas.add(carga3);

		when(this.terminal1.getPosicion()).thenReturn(this.posicion1);
		when(this.viaje.getProximaTerminal()).thenReturn(this.terminal1);

		// SUT (System Under Test): objeto a testear
		this.buque = new Buque(stateInbound, viaje, gps);
	}

	@Test
	void testConstructor() {
		assertNotNull(this.buque);
	}

	@Test
	public void testPreavisoA() {
		assertFalse(this.terminal1.hayBuqueCerca());
		this.buque.preavisoA(this.terminal1);
		assertTrue(this.terminal1.hayBuqueCerca());
	}

	@Test
	public void testDistanciaA() {
		when(this.terminal1.getPosicion()).thenReturn(posicion2);
		// Posible solucion a las posiciones random del buque.
		Posicion posicionBuque = this.buque.getPosicion();
		Posicion posicionTerminal = this.terminal1.getPosicion();
		float distanciaEsperada = (float) Math.hypot( (posicionBuque.getLatitud() - posicionTerminal.getLatitud())
				 , (posicionBuque.getLongitud() - posicionTerminal.getLongitud()) );
		assertEquals(distanciaEsperada, this.buque.distanciaA(this.terminal1));
	}
	
	@Test
	void testCambiarFaseCiclo() throws InterruptedException {
		assertEquals(stateInbound, buque.getFase());
		// Cambiar posicion del buque
		this.buque.update();
		assertEquals(stateArrived, buque.getFase());
		// Cambiar posicion del buque
		this.buque.update();
		assertEquals(stateWorking, buque.getFase());
		// Cambiar posicion del buque
		this.buque.update();
		assertEquals(stateDeparting, buque.getFase());
		// Cambiar posicion del buque
		when(this.terminal1.getPosicion()).thenReturn(this.posicion2);
		this.buque.update();
		assertEquals(stateOutbound, buque.getFase());
		// Cambiar posicion del buque
		when(this.terminal1.getPosicion()).thenReturn(this.posicion3);
		this.buque.update();
		assertEquals(stateInbound, buque.getFase());
	}

	@Test
	void enviarEmailTest() {
		when(viaje.getOrden()).thenReturn(orden);
		buque.enviarEmailA(terminal1);
		verify(viaje).getOrden();
	}
}
