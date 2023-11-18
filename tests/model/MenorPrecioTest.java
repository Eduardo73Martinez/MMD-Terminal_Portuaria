package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenorPrecioTest {

	private MenorPrecio				menorPrecio;
	
	private Terminal			origen;
	private Terminal			destino;
	
	private double				precio;
	private double				precio1;
	private double				precio2;

	private List<CircuitoMaritimo> 	circuitos = new ArrayList<CircuitoMaritimo>();
	private CircuitoMaritimo		circuito1;
	private CircuitoMaritimo		circuito2;
	private CircuitoMaritimo		circuito3;
	
	
	@BeforeEach
	public void setUp() {
		// DOC (Depended-On-Component): nuestros doubles
		this.origen 	= mock(Terminal.class);
		this.destino 	= mock(Terminal.class);
		
		this.precio 		= 1;
		this.precio1		= 2;
		this.precio2		= 3;
		
		this.circuito1 	= mock(CircuitoMaritimo.class);
		this.circuito2 	= mock(CircuitoMaritimo.class);
		this.circuito3 	= mock(CircuitoMaritimo.class);
		this.circuitos.add(circuito1);
		this.circuitos.add(circuito2);
		this.circuitos.add(circuito3);

		when(this.circuito1.precioTotalEntre(origen, destino)).thenReturn(precio);
		when(this.circuito2.precioTotalEntre(origen, destino)).thenReturn(precio1);
		when(this.circuito3.precioTotalEntre(origen, destino)).thenReturn(precio2);

		// SUT (System Under Test): objeto a testear
		this.menorPrecio = new MenorPrecio();
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