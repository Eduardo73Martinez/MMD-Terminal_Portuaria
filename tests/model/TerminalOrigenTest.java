package model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TerminalOrigenTest {

	private TerminalOrigen	terminalOrigen;
	private List<Viaje> 	viajes = new ArrayList<Viaje>();
	private Terminal		terminal;

	private Terminal		terminal1;
	private Terminal		terminal2;
	private Viaje			viaje1;
	private Viaje			viaje2;
	private Viaje			viaje3;
	
	
	@BeforeEach
	public void setUp() {
		// DOC (Depended-On-Component): nuestros doubles
		this.terminal 	= mock(Terminal.class);
		this.terminal1	= mock(Terminal.class);
		this.terminal2	= mock(Terminal.class);
		this.viaje1 	= mock(Viaje.class);
		this.viaje2 	= mock(Viaje.class);
		this.viaje3 	= mock(Viaje.class);
		
		this.viajes.add(viaje1);
		this.viajes.add(viaje2);
		this.viajes.add(viaje3);
		when(this.viaje1.getTerminalOrigen()).thenReturn(terminal);
		when(this.viaje2.getTerminalOrigen()).thenReturn(terminal1);
		when(this.viaje3.getTerminalOrigen()).thenReturn(terminal2);

		// SUT (System Under Test): objeto a testear
		this.terminalOrigen = new TerminalOrigen(terminal, this.viajes);
	}

	@Test
	void testConstructor() {
		assertNotNull(this.terminalOrigen);
	}

	@Test
	public void testFiltrar() {
		List<Viaje> viajesEsperados = Arrays.asList(viaje1);
		assertEquals(viajesEsperados, this.terminalOrigen.filtrar());
	}
}
