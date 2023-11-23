package model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AlmacenamientoExcedenteTest {

	private AlmacenamientoExcedente	excedente;

	private float		costoDiarioExc;
	private LocalDate	inicioAlmac;
	private LocalDate	finalAlmac;

	
	@BeforeEach
	public void setUp() {
		// DOC (Depended-On-Component): nuestros doubles
		this.costoDiarioExc	= 50;
		this.inicioAlmac	= LocalDate.now();
		this.finalAlmac		= this.inicioAlmac.plusDays(1);

		// SUT (System Under Test): objeto a testear
		this.excedente = new AlmacenamientoExcedente(this.inicioAlmac);
	}

	@Test
	void testConstructor() {
		assertNotNull(this.excedente);
	}

	@Test
	public void testCostoTotal() {
		int dias = this.inicioAlmac.until(this.finalAlmac).getDays();
		this.excedente.registrarFechaFinalAlmacenamiento(this.finalAlmac);
		assertEquals(this.costoDiarioExc*dias, excedente.costoTotal());
	}
}
