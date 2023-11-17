package model;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;


public class PosicionTest {

	private Posicion 		posicion;

	private float 	latitud;
	private float 	longitud;

	private Posicion 				posicion1;
	private Posicion 				posicion2;

	@BeforeEach
	public void setUp() {
	// DOC (Depended-On-Component): nuestros doubles
		this.latitud 	= 6;
		this.longitud	= 3;

		this.posicion1 	= mock(Posicion.class);
		this.posicion2	= mock(Posicion.class);
		when(this.posicion1.getLatitud()).thenReturn((float) 4);
		when(this.posicion1.getLongitud()).thenReturn((float) 3);
		when(this.posicion2.getLatitud()).thenReturn((float) 2);
		when(this.posicion2.getLongitud()).thenReturn((float) 3);

	// SUT (System Under Test): objeto a testear
	posicion = new Posicion(latitud, longitud);
	}

	@Test
	void testConstructor() {
		assertNotNull(this.posicion);
	}

	@Test
	public void testGetLatitude() {
		assertEquals(this.latitud, this.posicion.getLatitud());
	}

	@Test
	public void testGetLongitude() {
		assertEquals(this.longitud, this.posicion.getLongitud());
	}
}
