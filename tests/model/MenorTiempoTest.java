package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenorTiempoTest {

	private MenorTiempo				menorPrecio;
	
	private Terminal			origen;
	private Terminal			destino;
	
	private double				tiempo;
	private double				tiempo1;
	private double				tiempo2;

	private List<CircuitoMaritimo> 	circuitos = new ArrayList<CircuitoMaritimo>();
	private CircuitoMaritimo		circuito1;
	private CircuitoMaritimo		circuito2;
	private CircuitoMaritimo		circuito3;
	
	
	@BeforeEach
	public void setUp() {
		// DOC (Depended-On-Component): nuestros doubles
		this.origen 	= mock(Terminal.class);
		this.destino 	= mock(Terminal.class);
		
		this.tiempo 		= 1;
		this.tiempo1		= 2;
		this.tiempo2		= 3;
		
		this.circuito1 	= mock(CircuitoMaritimo.class);
		this.circuito2 	= mock(CircuitoMaritimo.class);
		this.circuito3 	= mock(CircuitoMaritimo.class);
		this.circuitos.add(circuito1);
		this.circuitos.add(circuito2);
		this.circuitos.add(circuito3);

		when(this.circuito1.tiempoTotalEntre(origen, destino)).thenReturn(tiempo);
		when(this.circuito2.tiempoTotalEntre(origen, destino)).thenReturn(tiempo1);
		when(this.circuito3.tiempoTotalEntre(origen, destino)).thenReturn(tiempo2);

		// SUT (System Under Test): objeto a testear
		this.menorPrecio = new MenorTiempo();
	}

	@Test
	void testConstructor() {
		assertNotNull(this.menorPrecio);
	}

	@Test
	public void testElMejor() {
		assertEquals(circuito1, this.menorPrecio.elMejor(this.circuitos, this.origen, this.destino));
	}
}