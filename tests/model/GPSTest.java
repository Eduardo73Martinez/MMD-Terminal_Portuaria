package model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GPSTest {

	private GPS				gps;
	
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
		this.time1 = 200000;

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
	}

	@Test
	void testConstructor() {
		assertNotNull(this.gps);
	}

	@Test
	public void testGetPosicion() {
		this.gps.cancel();
		assertEquals(this.posicion1, this.gps.getPosicion());
//		this.gps.wait(2); // FIXME acá tiene que dejar pasar X tiempo
//		assertNotEquals(posicion1, this.gps.getPosicion());
	}
	
	@Test
	public void testSetTimer() {
		this.time2 = this.time1 + 1;
		assertEquals(this.time1, this.gps.getPeriodo());
		this.gps.setPeriodo(this.time2);
		assertEquals(this.time2, this.gps.getPeriodo());
	}
}
