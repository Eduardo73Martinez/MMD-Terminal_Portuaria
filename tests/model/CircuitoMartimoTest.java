/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.stubbing.answers.ThrowsException;

/**
 * @author Martinez Eduardo
 *
 */
class CircuitoMartimoTest {
	
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
		
		circuito = new CircuitoMartimo(tramosDeCircuito);
	}

	@Test
	void circuitoMartimoTest() {
		assertEquals(circuito.getClass(), CircuitoMartimo.class);
	}
	@Test
	void agregarTramoALaListaDeTramosDelCircuito() {
		// tramo anterior 
		when(tramoNavegacion1.getOrigen()).thenReturn(teminalOrigen1);
		when(tramoNavegacion1.getDestino()).thenReturn(teminalDestino1);
				
		//tramo siguiente 
		when(tramoNavegacion2.getOrigen()).thenReturn(teminalDestino1);
		when(tramoNavegacion2.getDestino()).thenReturn(teminalOrigen1);
				
		// tramo a agregar
		when(tramoNavegacion4.getOrigen()).thenReturn(teminalOrigen2);
		when(tramoNavegacion4.getDestino()).thenReturn(teminalDestino2);
				
				
		circuito.agregarTramoEntre( tramoNavegacion4,tramoNavegacion1 , tramoNavegacion2 ) ; 
				
		verify(tramoNavegacion4).getOrigen();
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
		// tramo anterior 
		when(tramoNavegacion1.getOrigen()).thenReturn(teminalOrigen1);
		when(tramoNavegacion1.getDestino()).thenReturn(teminalDestino1);
		
		//tramo siguiente 
		when(tramoNavegacion2.getOrigen()).thenReturn(teminalDestino1);
		when(tramoNavegacion2.getDestino()).thenReturn(teminalOrigen1);
		
		// tramo a agregar
		when(tramoNavegacion4.getOrigen()).thenReturn(teminalOrigen2);
		when(tramoNavegacion4.getDestino()).thenReturn(teminalDestino2);
		
		
		circuito.validarAgregarTramoEntre( tramoNavegacion4,tramoNavegacion1 , tramoNavegacion2 ) ; 
		
		verify(tramoNavegacion1).getDestino();
		verify(tramoNavegacion2).getOrigen();
	}
	@Test
	void getTiempoTotalDelRecorrido() {
		when(tramoNavegacion1.getTiempo()).thenReturn(300.0);
		when(tramoNavegacion2.getTiempo()).thenReturn(500.0);
		when(tramoNavegacion3.getTiempo()).thenReturn(10.0);
		
		circuito.tiempoTotalDelCircuito();
		
		verify(tramoNavegacion1).getTiempo();
		verify(tramoNavegacion2).getTiempo();
		verify(tramoNavegacion3).getTiempo();
		
	}
	@Test
	void excepcionAlAgregarUnTramo()  {
		// tramo anterior 
		when(tramoNavegacion1.getOrigen()).thenReturn(teminalOrigen1);
		when(tramoNavegacion1.getDestino()).thenReturn(teminalDestino1);
				
		//tramo siguiente 
		when(tramoNavegacion2.getOrigen()).thenReturn(teminalDestino1);
		when(tramoNavegacion2.getDestino()).thenReturn(teminalOrigen1);
				
		// tramo a agregar
		when(tramoNavegacion4.getOrigen()).thenReturn(teminalOrigen2);
		when(tramoNavegacion4.getDestino()).thenReturn(teminalDestino2);
				
		assertThrows(Error.class, ()->{circuito.validarAgregarTramoEntre( tramoNavegacion4,tramoNavegacion1 , tramoNavegacion2 );}
		);
		
		//assertEquals(error.getMessage(), "Los tramos dados no son correlativos");
	}

}
