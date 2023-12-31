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
class CircuitoMaritimoTest {
	
	private CircuitoMaritimo circuito;
	private Tramo tramoNavegacion1;
	private Tramo tramoNavegacion2;
	private Tramo tramoNavegacion3;
	
	// agrego una terminales para testear la validacion al agregar los tramos 
	
	private Terminal teminalOrigen1;
	private Terminal teminalOrigen2;
	private Terminal teminalDestino1;
	private Terminal teminalDestino2;
	private Terminal terminalDestinoNoAgregada;
	
	@BeforeEach
	void setUp() throws Exception {
		tramoNavegacion1 = mock(Tramo.class);
		tramoNavegacion2 = mock(Tramo.class);
		tramoNavegacion3 = mock(Tramo.class);
		
		// terminales
		teminalOrigen1 = mock(Terminal.class);
		teminalOrigen2 = mock(Terminal.class);
		teminalDestino1 = mock(Terminal.class);
		teminalDestino2 = mock(Terminal.class);
		terminalDestinoNoAgregada = mock(Terminal.class);
		circuito = new CircuitoMaritimo(tramoNavegacion1, tramoNavegacion2);
	}

	@Test
	void circuitoMartimoTest() {
		
		assertEquals(circuito.getClass(), CircuitoMaritimo.class);
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
		when(tramoNavegacion3.getOrigen()).thenReturn(teminalOrigen2);
		when(tramoNavegacion3.getDestino()).thenReturn(teminalDestino2);
				
				
		circuito.agregarTramoLuegoDe( tramoNavegacion3,tramoNavegacion2) ; 
				
		assertEquals(circuito.getTramos().size(),3);
	}
	@Test
	void quitarTramoALaListaDeTramosDelCircuito() {
		circuito.quitarTramo(tramoNavegacion3);
		assertEquals(circuito.getTramos().size(),2);
	}
	@Test
	void getTramosTest() {
		int cantidadDeCircuitos = circuito.getTramos().size();
		assertEquals(cantidadDeCircuitos, 2);
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
		when(tramoNavegacion3.getOrigen()).thenReturn(teminalOrigen2);
		when(tramoNavegacion3.getDestino()).thenReturn(teminalDestino2);
		
		
		circuito.validarTramoNuevo( tramoNavegacion3 ) ; 
		
		assertEquals(2, circuito.getTramos().size());
	}
	@Test
	void getTiempoTotalDelRecorridoTest() {
		when(tramoNavegacion1.getTiempo()).thenReturn(20);
		when(tramoNavegacion2.getTiempo()).thenReturn(10);
		
		circuito.tiempoTotalDelCircuito();
		
		verify(tramoNavegacion1).getTiempo();
		verify(tramoNavegacion2).getTiempo();
		
	}
	@Test
	void excepcionAlAgregarUnTramoTest()  {
		// tramo anterior 
		when(tramoNavegacion1.getOrigen()).thenReturn(teminalOrigen1);
		when(tramoNavegacion1.getDestino()).thenReturn(teminalDestino1);
				
		//tramo siguiente 
		when(tramoNavegacion2.getOrigen()).thenReturn(teminalDestino1);
		when(tramoNavegacion2.getDestino()).thenReturn(teminalOrigen1);
				
		//vamos a agregar el tramoNavegacion2 que ya esta en el circuito		
		assertThrows(TramoExceptions.class, ()->{circuito.validarTramoNuevo( tramoNavegacion1);}
		);
		
		//assertEquals(error.getMessage(), "El tramo ya existe en el circuito");
	}
	@Test
	void precioTotalDelCicuitoTest()  {
		// tramo anterior 
		when(tramoNavegacion1.getPrecio()).thenReturn(300.0);
		when(tramoNavegacion2.getPrecio()).thenReturn(400.0);
		//
		circuito.precioTotal();
		
		verify(tramoNavegacion1).getPrecio();
		verify(tramoNavegacion2).getPrecio();
	} 
	@Test
	void precioTotalEntreTerminalesTest()  {
		//Terminales
		when(tramoNavegacion1.getOrigen()).thenReturn(teminalOrigen1);
		when(tramoNavegacion2.getOrigen()).thenReturn(teminalOrigen2);
		when(tramoNavegacion3.getOrigen()).thenReturn(teminalDestino1);
		// tramo anterior 
		when(tramoNavegacion1.getPrecio()).thenReturn(300.0);
		when(tramoNavegacion2.getPrecio()).thenReturn(400.0);
		when(tramoNavegacion3.getPrecio()).thenReturn(1000.0);
				
		//
		circuito.precioTotalEntre(teminalOrigen1, teminalOrigen2);
		
		verify(tramoNavegacion1).getPrecio();
		verify(tramoNavegacion2).getPrecio();
		verify(tramoNavegacion3, never()).getPrecio();
	}
	@Test
	void validacionDeExistenciaDeTerminalesEnElCircuitoTest()  {
		// tramo anterior 
		when(tramoNavegacion1.getOrigen()).thenReturn(teminalOrigen2);
		when(tramoNavegacion2.getOrigen()).thenReturn(teminalOrigen2);
		when(tramoNavegacion3.getOrigen()).thenReturn(teminalOrigen1);
				
		//
		circuito.perteneceAlCircuito(teminalOrigen1);
		
		verify(tramoNavegacion1).getOrigen();
		verify(tramoNavegacion2).getOrigen();
		verify(tramoNavegacion3, never()).getOrigen();
	}
	@Test
	void esUltimoTramoTest()  {
		assertTrue(circuito.esUltimoTramo(tramoNavegacion2));
	}
	@Test
	void validacionExistenciaDeTramoTest()  {
		assertThrows(TramoExceptions.class, ()->{circuito.validarExistencia( tramoNavegacion3);}
				);
	}
	@Test
	void validarTerminalEnCircuitoTest() {
		// tramo anterior
		when(tramoNavegacion1.getOrigen()).thenReturn(teminalOrigen1);
		when(tramoNavegacion1.getDestino()).thenReturn(teminalDestino1);
				
		//tramo siguiente 
		when(tramoNavegacion2.getOrigen()).thenReturn(teminalDestino1);
		when(tramoNavegacion2.getDestino()).thenReturn(teminalOrigen1);
		//no error
		assertDoesNotThrow(()->{circuito.validarTerminalEnCircuito(teminalDestino1);});
		//error
		assertThrows(TramoExceptions.class, ()->{circuito.validarTerminalEnCircuito(terminalDestinoNoAgregada);}
				);
	}
	@Test
	void validarDireccionRecorridoTest() {
		// tramo anterior 
		when(tramoNavegacion1.getOrigen()).thenReturn(teminalOrigen1);
		when(tramoNavegacion1.getDestino()).thenReturn(teminalDestino2);
						
		//tramo siguiente 
		when(tramoNavegacion2.getOrigen()).thenReturn(teminalDestino1);
		when(tramoNavegacion2.getDestino()).thenReturn(teminalOrigen1);
		
		assertDoesNotThrow(()->{circuito.validarDireccionRecorrido(tramoNavegacion2,tramoNavegacion1);});
		assertThrows(TramoExceptions.class, ()->{circuito.validarDireccionRecorrido(tramoNavegacion1,tramoNavegacion2);}
				);
	}
	@Test
	void validarOrigenesDiferentesTest() {
		when(tramoNavegacion1.getOrigen()).thenReturn(teminalOrigen1);
		
		//tramo siguiente 
		when(tramoNavegacion2.getOrigen()).thenReturn(teminalOrigen1);
		
		assertThrows(TramoExceptions.class, ()->{circuito.validarOrigenesDiferentes(tramoNavegacion1,tramoNavegacion2);}
				);
		when(tramoNavegacion2.getOrigen()).thenReturn(teminalOrigen2);
		assertDoesNotThrow(()->{circuito.validarOrigenesDiferentes(tramoNavegacion2,tramoNavegacion1);});
	}
	@Test
	void tiempoTotalEntreTerminalesTest()  {
		//Terminales de los tramos
		when(tramoNavegacion1.getOrigen()).thenReturn(teminalOrigen1);
		when(tramoNavegacion2.getOrigen()).thenReturn(teminalOrigen2);
		when(tramoNavegacion3.getOrigen()).thenReturn(teminalDestino1);
		// tramo anterior 
		when(tramoNavegacion1.getTiempo()).thenReturn(50);
		when(tramoNavegacion2.getTiempo()).thenReturn(10);
		when(tramoNavegacion3.getTiempo()).thenReturn(20);
				
		//
		circuito.tiempoTotalEntre(teminalOrigen1, teminalOrigen2);
		
		verify(tramoNavegacion1).getTiempo();
		verify(tramoNavegacion2).getTiempo();
		verify(tramoNavegacion3, never()).getTiempo();
	}
	@Test
	void nroTotalEntreTerminalesTest()  {
		//Terminales de los tramos
		when(tramoNavegacion1.getOrigen()).thenReturn(teminalOrigen1);
		when(tramoNavegacion2.getOrigen()).thenReturn(teminalOrigen2);

		assertEquals(2, circuito.nroTerminalesTotalEntre(teminalOrigen1, teminalOrigen2));
	}
	@Test 
	void getTerminalOrigenTest() {
		when(tramoNavegacion1.getOrigen()).thenReturn(teminalOrigen1);
		when(tramoNavegacion2.getOrigen()).thenReturn(teminalOrigen2);
		when(tramoNavegacion3.getOrigen()).thenReturn(teminalDestino1);
		
		circuito.getTerminalOrigen();
		
		verify(tramoNavegacion1).getOrigen(); // solo llama al origen del primer tramo
		verify(tramoNavegacion2, never()).getOrigen();
		verify(tramoNavegacion3, never()).getOrigen();
	}
	@Test 
	void getTerminalDestinoTest() {
		when(tramoNavegacion1.getOrigen()).thenReturn(teminalOrigen1);
		when(tramoNavegacion2.getOrigen()).thenReturn(teminalOrigen2);
		when(tramoNavegacion3.getOrigen()).thenReturn(teminalDestino1);
		
		
		circuito.getTerminalDestino(); 
		
		verify(tramoNavegacion1, never()).getOrigen();
		verify(tramoNavegacion2).getOrigen();
		verify(tramoNavegacion3, never()).getOrigen();
	}


}
