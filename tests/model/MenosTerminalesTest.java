package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenosTerminalesTest {

	private MenosTerminales				menosTerminales;
	
	private Terminal			origen;
	private Terminal			destino;
	
	private Integer				nroTerminales;
	private Integer				nroTerminales1;
	private Integer				nroTerminales2;

	private List<CircuitoMaritimo> 	circuitos = new ArrayList<CircuitoMaritimo>();
	private CircuitoMaritimo		circuito1;
	private CircuitoMaritimo		circuito2;
	private CircuitoMaritimo		circuito3;
	
	
	@BeforeEach
	public void setUp() {
		// DOC (Depended-On-Component): nuestros doubles
		this.origen 	= mock(Terminal.class);
		this.destino 	= mock(Terminal.class);
		
		this.nroTerminales 		= 2;
		this.nroTerminales1		= 3;
		this.nroTerminales2		= 4;
		
		this.circuito1 	= mock(CircuitoMaritimo.class);
		this.circuito2 	= mock(CircuitoMaritimo.class);
		this.circuito3 	= mock(CircuitoMaritimo.class);
		this.circuitos.add(circuito1);
		this.circuitos.add(circuito2);
		this.circuitos.add(circuito3);

		when(this.circuito1.nroTerminalesTotalEntre(origen, destino)).thenReturn(nroTerminales);
		when(this.circuito2.nroTerminalesTotalEntre(origen, destino)).thenReturn(nroTerminales1);
		when(this.circuito3.nroTerminalesTotalEntre(origen, destino)).thenReturn(nroTerminales2);

		// SUT (System Under Test): objeto a testear
		this.menosTerminales = new MenosTerminales();
	}

	@Test
	void testConstructor() {
		assertNotNull(this.menosTerminales);
	}

	@Test
	public void testElMejor() {
		assertEquals(circuito1, this.menosTerminales.elMejor(this.circuitos, this.origen, this.destino));
	}
}