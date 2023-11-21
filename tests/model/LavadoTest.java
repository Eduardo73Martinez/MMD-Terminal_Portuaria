package model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LavadoTest {

	private Lavado	lavado;

	private float		costoFijoSup;
	private float       porcentajeRelativo;
	private Carga		container;

	
	@BeforeEach
	public void setUp() {
		// DOC (Depended-On-Component): nuestros doubles
		this.costoFijoSup	= 50;
		this.porcentajeRelativo = 80;
		this.container 		= mock(Carga.class);

		// SUT (System Under Test): objeto a testear
		this.lavado = new Lavado(this.container);
	}

	@Test
	void testConstructor() {
		assertNotNull(this.lavado);
	}

	@Test
	public void testCostoTotal() {
		when(this.container.getAlto()).thenReturn(2.0);
		when(this.container.getAncho()).thenReturn(2.0);
		when(this.container.getLargo()).thenReturn(2.0);
		float volContainerInf = (float) (this.container.getAlto()*this.container.getAncho()*this.container.getLargo());
		assertEquals(this.costoFijoSup*this.porcentajeRelativo, lavado.costoTotal());

		when(this.container.getAlto()).thenReturn(20.0);
		when(this.container.getAncho()).thenReturn(20.0);
		when(this.container.getLargo()).thenReturn(20.0);
		float volContainerSup = (float) (this.container.getAlto()*this.container.getAncho()*this.container.getLargo());
		assertEquals(this.costoFijoSup, lavado.costoTotal());
	}
}
