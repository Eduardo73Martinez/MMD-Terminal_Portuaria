package model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GPSTest {

	private GPS			gps;
	
	private Posicion		posicion1 = new Posicion(2, 3);
	private Posicion		posicion2 = new Posicion(2, 5);
	
	private Terminal		terminal;
	private long			timer1; //FIXME
	private long			timer2; //FIXME
	
	@BeforeEach
	public void setUp() {
		// DOC (Depended-On-Component): nuestros doubles
		this.timer1 = 2;
//		when(this.gps.getPosicion()).thenReturn(posicion1);

		// SUT (System Under Test): objeto a testear
		this.gps = new GPS(this.timer1, posicion1);
	}

	@Test
	void testConstructor() {
		assertNotNull(this.gps);
	}

	@Test
	public void testGetPosicion() {
		assertEquals(posicion1, this.gps.getPosicion());
//		this.gps.wait(2); // FIXME acá tiene que dejar pasar X tiempo
//		assertNotEquals(posicion1, this.gps.getPosicion());
	}
	
	@Test
	public void testSetTimer() {
		this.timer2 = this.timer1 + 1;
		assertEquals(this.timer1, this.gps.getPeriodo());
		this.gps.setPeriodo(timer2);
		assertEquals(this.timer2, this.gps.getPeriodo());
	}
}
