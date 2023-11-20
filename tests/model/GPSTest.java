package model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GPSTest {

	private GPS				gps;
	private GPS				gps1;
	
	private Posicion		posicion1 = new Posicion(2, 3);
	private Posicion		posicion2 = new Posicion(2, 5);
	
	private Buque			buque;
	private Outbound		stateOutbound;
	private Inbound			stateInbound;
	private Arrived			stateArrived;
	private Working			stateWorking;
	private Departing		stateDeparting;

	private Viaje			viaje;

	private long			time1; //FIXME
	private long			time2; //FIXME
	
	@BeforeEach
	public void setUp() {
		// DOC (Depended-On-Component): nuestros doubles
		this.time1 = 2;

		this.stateOutbound  = spy(new Outbound());
		this.stateDeparting	= spy(new Departing(stateOutbound));
		this.stateWorking	= spy(new Working(stateDeparting));
		this.stateArrived	= spy(new Arrived(stateWorking));
		this.stateInbound	= spy(new Inbound(stateArrived));
		this.stateOutbound.setSiguiente(stateInbound);

		this.viaje 	= mock(Viaje.class);
		this.buque 	= mock(Buque.class);
		when(this.buque.getPosicion()).thenReturn(this.posicion1);

		// SUT (System Under Test): objeto a testear
		this.gps = new GPS(this.time1, this.buque);
		this.gps1 = new GPS(this.time1, this.posicion1);
	}

	@Test
	void testConstructor() {
		assertNotNull(this.gps);
		assertNotNull(this.gps1);
	}

	@Test
	public void testGetPosicion() {
		assertEquals(this.posicion1, this.gps.getPosicion());
	}

	@Test
	public void testSetBuque() {
		assertEquals(this.buque, this.gps.getBuque());
		assertEquals(null, this.gps1.getBuque());
		this.gps1.setBuque(this.buque);
		assertEquals(this.buque, this.gps1.getBuque());
	}

	@Test
	public void testActivar() throws InterruptedException {
		this.gps.activar();
		Thread.sleep(time1);
//		wait(this.time1); // Esperar para que cambie
		assertNotEquals(this.posicion1, this.gps.getPosicion());
	}

	@Test
	public void testSetTimer() {
		this.time2 = this.time1 + 1;
		assertEquals(this.time1, this.gps.getPeriodo());
		this.gps.setPeriodo(this.time2);
		assertEquals(this.time2, this.gps.getPeriodo());
	}
}
