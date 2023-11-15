/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.CircuitoMartimo;
import model.Naviera;
import model.Terminal;
import model.Viaje;

/**
 * @author Martinez Eduardo
 * 
 * Observacion: este test fue creado usando TDD las clases en las cuales se implementa 
 * mockito son clases que aun no fueron implementadas, no asi otras como por ejemplo viaje 
 * que ya fue creada por otro colega.
 *
 */
class TestNaviera {

	private Naviera naviera;
	
	//colecciones que maneja la naviera
	
	private ArrayList<Viaje> viajes = new ArrayList<>();
	private ArrayList<Buque> buques = new ArrayList<>();
	private ArrayList<CircuitoMartimo> circuitos = new ArrayList<>();
	
	// agregamos las clases para usarlas en las colecciones
	//viajes
	private Viaje viaje1;
	private Viaje viaje2;
	private Viaje viaje3;
	
	//buques
	private Buque buque1;
	private Buque buque2;
	private Buque buque3;
	
	//circuitos
	private CircuitoMartimo circuito1;
	private CircuitoMartimo circuito2;
	private CircuitoMartimo circuito3;
	
	
	//terminal 
	private Terminal terminal;
	
	
	@BeforeEach
	void setUp() throws Exception {
		// instancio una clase que tengo disponible
		viaje1 = new Viaje();
		viaje2 = new Viaje();
		viaje3 = new Viaje();
		
		// agrego al array
		viajes.add(viaje1);
		viajes.add(viaje2);
		
		//creo un mock para buque que no tengo disponible aun
		buque1 = mock(Buque.class);
		buque2 = mock(Buque.class);
		buque3 = mock(Buque.class);
		
		// agrego al array
		buques.add(buque1);
		buques.add(buque2);
		
		// instancio una clase que implemento yo
		circuito1 = new CircuitoMartimo();
		circuito2 = new CircuitoMartimo();
		circuito3 = new CircuitoMartimo();
		
		//agrego al array
		circuitos.add(circuito1);
		circuitos.add(circuito2);
		
		
		//creo un clase mock para terminal 
		terminal = mock(Terminal.class);
		
		//instancio naviera con los array generados
		naviera = new Naviera (circuitos, viajes, buques);
		
	}

	@Test
	void testConstructorNaviera() {
		assertEquals(naviera.getClass(), Naviera.class);
	}

	@Test
	void testAgregarCircuitoMaritimo() {
		naviera.agregarCircuito(circuito3);
		assertEquals(naviera.getCircuitos().size(), 3);
	}

	@Test
	void testQuitarCircuitoMaritimo() {
		naviera.quitarCircuito(circuito1);
		assertEquals(naviera.getCircuitos().size(), 1);
	}

	@Test
	void testAgregarBuque() {
		naviera.agregarBuque(buque3);
		assertEquals(naviera.getBuques().size(), 3);
	}

	@Test
	void testQuitarBuque() {
		naviera.quitarBuque(buque2);
		assertEquals(naviera.getBuques().size(), 1);
	}

	@Test
	void testAgregarViaje() {
		naviera.agregarViaje(viaje3);
		assertEquals(naviera.getViajes().size(), 3);
	}

	@Test
	void testQuitarViaje() {
		naviera.quitarViaje(viaje2);
		assertEquals(naviera.getViajes().size(), 1);
	}

	@Test
	void testCronogramaDeViajes() {
		viajes.add(viaje3);
		when(terminal.cronogramaSalidaViajes()).thenReturn(viajes);
		naviera.cronograma(terminal);
		verify(terminal).cronogramaSalidaViajes();
	}
	
	
	// getters
	@Test
	void testgetBuques() {
		int cantidadBuques = naviera.getBuques().size();
		assertEquals(cantidadBuques, 2);
	}
	
	@Test
	void testGetViajes() {
		int cantidadDeViajes = naviera.getViajes().size();
		assertEquals(cantidadDeViajes, 2);
	}
	@Test
	void testGetCircuitos() {
		int cantidadDeCircuitos = naviera.getCircuitos().size();
		assertEquals(cantidadDeCircuitos, 2);
	}

}
