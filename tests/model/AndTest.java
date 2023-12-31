package model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;


public class AndTest {

	private And	and;
	private FechaLlegada	critFechaLlegada1;
	private TerminalDestino	critTerminalDestino1;

	private LocalDate		fecha1;
	private LocalDate		fecha2;
	private Terminal		terminal1;
	private Terminal		terminal2;
	private Viaje			viaje1;
	private Viaje			viaje2;
	private Viaje			viaje3;
	private List<Viaje> 	viajes = new ArrayList<Viaje>();

	@BeforeEach
	public void setUp() {
	// DOC (Depended-On-Component): nuestros doubles
		this.viaje1 	= mock(Viaje.class);
		this.viaje2 	= mock(Viaje.class);
		this.viaje3 	= mock(Viaje.class);
		viajes.add(viaje1);
		viajes.add(viaje2);
		viajes.add(viaje3);

		this.fecha1		= LocalDate.of(1,1,1);
		this.fecha2		= LocalDate.of(1,3,1);
		this.terminal1	= mock(Terminal.class);
		this.terminal2	= mock(Terminal.class);

		this.critFechaLlegada1 		= spy(new FechaLlegada(this.fecha1));
		this.critTerminalDestino1 	= spy(new TerminalDestino(this.terminal1));

		// SUT (System Under Test): objeto a testear
		this.and = new And(this.critFechaLlegada1, this.critTerminalDestino1);
	}

	@Test
	void testConstructor() {
		assertNotNull(this.and);
	}

	@Test
	public void testAnd2SimpleQuery() {
		//	Hay que usar HashSet para los tests?
		when(this.viaje1.getFechaDeLlegada()).thenReturn(fecha1);
		when(this.viaje2.getFechaDeLlegada()).thenReturn(fecha2);
		when(this.viaje3.getFechaDeLlegada()).thenReturn(fecha2);

		when(this.viaje1.getTerminalDestino()).thenReturn(terminal1);
		when(this.viaje2.getTerminalDestino()).thenReturn(terminal2);
		when(this.viaje3.getTerminalDestino()).thenReturn(terminal1);

		// solo viaje 1 tiene la fecha de llegada y el destino

		assertTrue(and.filtrar(viajes).contains(viaje1));
		assertFalse(and.filtrar(viajes).contains(viaje2));
		assertFalse(and.filtrar(viajes).contains(viaje3));
	}
}
