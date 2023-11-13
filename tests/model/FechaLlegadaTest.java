package model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FechaLlegadaTest {

	private FechaLlegada	fechaLlegada;
	private List<Viaje> 	viajes = new ArrayList<Viaje>();
	private LocalDate		fecha;

	private LocalDate		fecha1;
	private LocalDate		fecha2;
	private Viaje			viaje1;
	private Viaje			viaje2;
	private Viaje			viaje3;
	
	
	@BeforeEach
	public void setUp() {
		// DOC (Depended-On-Component): nuestros doubles
		this.fecha 		= LocalDate.now();
		this.fecha1		= fecha.plusDays(1);
		this.fecha2		= fecha1.plusDays(1);
		this.viaje1 	= mock(Viaje.class);
		this.viaje2 	= mock(Viaje.class);
		this.viaje3 	= mock(Viaje.class);
		
		this.viajes.add(viaje1);
		this.viajes.add(viaje2);
		this.viajes.add(viaje3);
		when(this.viaje1.getFechaDeLlegada()).thenReturn(fecha);
		when(this.viaje2.getFechaDeLlegada()).thenReturn(fecha1);
		when(this.viaje3.getFechaDeLlegada()).thenReturn(fecha2);

		// SUT (System Under Test): objeto a testear
		this.fechaLlegada = new FechaLlegada(fecha, this.viajes);
	}

	@Test
	void testConstructor() {
		assertNotNull(this.fechaLlegada);
	}

	@Test
	public void testFiltrar() {
		List<Viaje> viajesEsperados = Arrays.asList(viaje1);
		assertEquals(viajesEsperados, this.fechaLlegada.filtrar());
	}
}
