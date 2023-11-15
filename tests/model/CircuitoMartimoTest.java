/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Martinez Eduardo
 *
 */
class CircuitoMartimoTest {

	/**
	 * @throws java.lang.Exception
	 */
	private CircuitoMartimo circuito;
	private Tramo tramoNavegacion1;
	private Tramo tramoNavegacion2;
	private Tramo tramoNavegacion3;
	private Tramo tramoNavegacion4;
	
	private ArrayList<Tramo> tramosDeCircuito = new ArrayList<>();
	
	
	// agrego una terminal para testear la validacion al agregar los tramos 
	
	private Terminal teminalOrigen1;
	private Terminal teminalOrigen2;
	private Terminal teminalDestino1;
	private Terminal teminalDestino2;
	
	@BeforeEach
	void setUp() throws Exception {
		tramoNavegacion1 = mock(Tramo.class);
		tramoNavegacion2 = mock(Tramo.class);
		tramoNavegacion3 = mock(Tramo.class);
		tramoNavegacion4 = mock(Tramo.class);
		
		tramosDeCircuito.add(tramoNavegacion1);
		tramosDeCircuito.add(tramoNavegacion2);
		tramosDeCircuito.add(tramoNavegacion3);
		
		// terminales
		teminalOrigen1 = mock(Terminal.class);
		teminalOrigen2 = mock(Terminal.class);
		teminalDestino1 = mock(Terminal.class);
		teminalDestino2 = mock(Terminal.class);
		
		circuito = new CircuitoMartimo();
	}

	@Test
	void circuitoMartimoTest() {
		assertEquals(circuito.getClass(), CircuitoMartimoTest.class);
	}
	@Test
	void agregarTramoALaListaDeTramosDelCircuito() {
		circuito.agregarTramo(tramoNavegacion4);
		assertEquals(circuito.getTramos().size(),4);
	}
	@Test
	void quitarTramoALaListaDeTramosDelCircuito() {
		circuito.quitarTramo(tramoNavegacion3);
		assertEquals(circuito.getTramos().size(),2);
	}
	@Test
	void getTramos() {
		int cantidadDeCircuitos = circuito.getTramos().size();
		assertEquals(cantidadDeCircuitos, 3);
	}
	@Test
	void validarAgregarTramoALaListaDeTramosDelCircuito() {
		// tramo a agregar
		when(tramoNavegacion4.getOrigen()).thenReturn(teminalOrigen2);
		when(tramoNavegacion4.getDestino()).thenReturn(teminalDestino2);
		
		circuito.validarAgregarTramo(tramoNavegacion4); 
		
		verify(tramoNavegacion4).getOrigen();
		verify(tramoNavegacion4).getDestino();
	}
	

}
