package model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PesadoTest {

	private Pesado	pesado;

	private float		costo;
	private Carga		container;

	
	@BeforeEach
	public void setUp() {
		// DOC (Depended-On-Component): nuestros doubles
		this.costo	= 50;
		this.container 		= mock(Carga.class);

		// SUT (System Under Test): objeto a testear
		this.pesado = new Pesado(this.container);
	}

	@Test
	void testConstructor() {
		assertNotNull(this.pesado);
	}

	@Test
	public void testCostoTotal() {
		assertEquals(this.costo, pesado.costoTotal());
	}
}
