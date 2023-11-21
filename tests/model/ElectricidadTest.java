package model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ElectricidadTest {

	private Electricidad	electricidad;

	private float			costoKWh;
	private LocalDate		inicioConexionElec;
	private LocalDate		finalConexionElec;
	private Reefer			reefer;

	
	@BeforeEach
	public void setUp() {
		// DOC (Depended-On-Component): nuestros doubles
		this.inicioConexionElec 	= LocalDate.now();
		this.finalConexionElec		= inicioConexionElec.plusDays(1);
		this.reefer 				= mock(Reefer.class);
		this.costoKWh 				= 2;
		
		when(this.reefer.getConsumo()).thenReturn(1.0);

		// SUT (System Under Test): objeto a testear
		this.electricidad = new Electricidad(this.reefer, this.inicioConexionElec, this.finalConexionElec, this.costoKWh);
	}

	@Test
	void testConstructor() {
		assertNotNull(this.electricidad);
	}

	@Test
	public void testCostoTotal() {
		int horas = this.inicioConexionElec.until(this.finalConexionElec).getDays()*24;
		assertEquals(this.costoKWh*this.reefer.getConsumo()*horas, electricidad.costoTotal());
	}
}
