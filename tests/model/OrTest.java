package model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;


public class OrTest {

	private Or	or;
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
		this.viaje1 	= spy(Viaje.class);
		this.viaje2 	= mock(Viaje.class);
		this.viaje3 	= spy(Viaje.class);
		viajes.add(viaje1);
		viajes.add(viaje2);
		viajes.add(viaje3);

		this.fecha1		= LocalDate.of(1,1,1);
		this.fecha2		= LocalDate.of(1,3,1);
		this.terminal1	= mock(Terminal.class);
		this.terminal2	= mock(Terminal.class);

		this.critFechaLlegada1 	= spy(new FechaLlegada(this.fecha1, this.viajes));
		this.critTerminalDestino1 	= spy(new TerminalDestino(this.terminal1, this.viajes));

		// SUT (System Under Test): objeto a testear
		this.or = new Or(this.critFechaLlegada1, this.critTerminalDestino1);
	}

	@Test
	void testConstructor() {
		assertNotNull(this.or);
	}

	@Test
	public void testOr2SimpleQuery() {
		//	Hay que usar HashSet para los tests?
		when(this.viaje1.getFechaDeLlegada()).thenReturn(fecha1);
		when(this.viaje2.getFechaDeLlegada()).thenReturn(fecha2);
		when(this.viaje3.getFechaDeLlegada()).thenReturn(fecha2);

		when(this.viaje1.getTerminalDestino()).thenReturn(terminal1);
		when(this.viaje2.getTerminalDestino()).thenReturn(terminal2);
		when(this.viaje3.getTerminalDestino()).thenReturn(terminal1);

		// viaje 1 tiene la fecha de llegada
		// viaje 1 y 3 tienen el destino

		assertFalse(or.filtrar().contains(viaje2));

		verify(critFechaLlegada1, times(1)).filtrar();
		verify(viaje1, times(1)).getFechaDeLlegada();
		verify(viaje3, times(1)).getTerminalDestino();
	}
}
