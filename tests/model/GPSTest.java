package model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GPSTest {

	private GPS			gps;
	
	private Posicion		posicion1 = new Posicion(2, 3);

	private Terminal		terminal;
	private Posicion		posicion2 = new Posicion(2, 5);
	
	private Carga			carga1;
	private Carga			carga2;
	private Carga			carga3;
	
	
	@BeforeEach
	public void setUp() {
		// DOC (Depended-On-Component): nuestros doubles
		this.carga1 		= mock(Carga.class);
		this.carga2 		= mock(Carga.class);
		this.carga3 		= mock(Carga.class);
		
		when(this.gps.getPosicion()).thenReturn(posicion1);

		// SUT (System Under Test): objeto a testear
		this.gps = new GPS();
	}

	@Test
	void testConstructor() {
		assertNotNull(this.gps);
	}

	@Test
	public void testGetPosicion() {
		assertEquals(posicion1, this.gps.getPosicion());
		this.gps.wait(2);
		assertEquals(posicion2, this.gps.getPosicion());
	}
}
