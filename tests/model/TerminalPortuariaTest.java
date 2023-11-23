package model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Modo ejemplo para importar Clases primitivas típicas
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TerminalPortuariaTest {
	
	// Atributos generales
	private TerminalPortuaria terminalPortuaria;
	
	private Shipper 		  	shipper1;
	private Consignee		  	consignee1;
	private Carga   		  	carga1;
	private Viaje             	viaje1;
	private Viaje             	viaje2;
	private Viaje             	viaje3;
	private Camion            	camion1;
	private Chofer            	chofer1;
	private ICliente       	  	cliente1;
	private EmpresaTransporte 	empresa1;
	private List<Viaje>       	viajes;
	private Terminal          	terminal1;
	private CircuitoMaritimo  	circuito1;
    private IOrden			  	prioridad1;
    private ServicioContratable servicio1;
    private OrdenBasicaTP		orden1;
    private Buque				buque1;
    private Naviera				naviera1;
	
	// Setup (definición de SUT y DOC)
	@BeforeEach
	//DOC
	public void setUp() {
//		this.shipper1   		= mock(Shipper.class);
//		this.consignee1 		= mock(Consignee.class);
//		this.carga1     		= mock(Carga.class);
//		this.viaje1   			= mock(Viaje.class);
//		this.viaje2   			= mock(Viaje.class);
//		this.viaje3   			= mock(Viaje.class);
//		this.camion1   			= mock(Camion.class);
//		this.chofer1   			= mock(Chofer.class);
//		this.cliente1   		= mock(ICliente.class);
//		this.empresa1 			= mock(EmpresaTransporte.class);
//		this.terminal1  		= mock(Terminal.class);
//		this.circuito1  		= mock(CircuitoMaritimo.class);
//		this.prioridad1	    	= mock(IOrden.class);
		this.viajes				= new ArrayList<Viaje>();
		
	//SUT	
		this.terminalPortuaria = new TerminalPortuaria();
	}
	
	// Métodos con ejercicios y verificación
	@Test
	void testConstructor() {
		assertNotNull(terminalPortuaria);
	}
	
	@Test
	void testGetBuqueCerca() {
		assertEquals(false, terminalPortuaria.getBuqueCerca());
	}
	
	@Test
	void testGetPosicion() {
//		no sé cómo testear
	}
	
	@Test
	void testRecibirPreaviso() {
		terminalPortuaria.recibirPreaviso(buque1);
		assertEquals(true, terminalPortuaria.getBuqueCerca());
	}
	
	@Test
	void testGetCamionesRegistrados() {
		terminalPortuaria.getCamionesRegistrados();
//		no sé cómo testear
	}
	
	@Test
	void testRegistrarCamion() {
		terminalPortuaria.registrarCamion(camion1);
//		no sé cómo testear
	}
	
	@Test
	void testQuitarCamion() {
		terminalPortuaria.quitarCamion(camion1);
//		no sé cómo testear
	}
	
	@Test
	void testGetChoferesRegistrados() {
		terminalPortuaria.getChoferesRegistrados();
//		no sé cómo testear
	}
	
	@Test
	void testRegistrarChofer() {
		terminalPortuaria.registrarChofer(chofer1);
//		no sé cómo testear
	}
	
	@Test
	void testQuitarChofer() {
		terminalPortuaria.quitarChofer(chofer1);
//		no sé cómo testear
	}
	
	@Test
	void testGetEmpresasRegistradas() {
		terminalPortuaria.getEmpresasRegistradas();
//		no sé cómo testear
	}
	
	@Test
	void testRegistrarEmpresa() {
		terminalPortuaria.registrarEmpresa(empresa1);
		assertTrue(terminalPortuaria.getEmpresasRegistradas().contains(empresa1));
	}
	
	@Test
	void testQuitarEmpresa() {
		terminalPortuaria.quitarEmpresa(empresa1);
//		no sé cómo testear
	}
	
	@Test
	void testGetConsignee() {
		terminalPortuaria.getConsignee();
//		no sé cómo testear
	}
	
	@Test
	void testRegistrarConsignee() {
		terminalPortuaria.registrarConsignee(consignee1);
//		no sé cómo testear
	}
	
	@Test
	void testQuitarConsignee() {
		terminalPortuaria.quitarConsignee(consignee1);
//		no sé cómo testear
	}
	
	@Test
	void testGetShippers() {
		terminalPortuaria.getShippers();
//		no sé cómo testear
	}
	
	@Test
	void testRegistrarShipper() {
		terminalPortuaria.registrarShipper(shipper1);
//		no sé cómo testear
	}
	
	@Test
	void testQuitarShipper() {
		terminalPortuaria.quitarShipper(shipper1);
//		no sé cómo testear
	}
	
	@Test
	void testGetCircuitos() {
		terminalPortuaria.getCircuitos();
//		no sé cómo testear
	}
	
	@Test
	void testRegistrarCircuito() {
		terminalPortuaria.registrarCircuito(circuito1);
//		no sé cómo testear
	}

	@Test
	void testQuitarCircuito() {
		terminalPortuaria.quitarCircuito(circuito1);
//		no sé cómo testear
	}
	
	@Test
	void testGetNavieras() {
		terminalPortuaria.getNavieras();
//		no sé cómo testear
	}
	
	@Test
	void testRegistrarNaviera() {
		terminalPortuaria.registrarNaviera(naviera1);
//		no sé cómo testear
	}
	
	@Test
	void testQuitarNaviera() {
		terminalPortuaria.quitarNaviera(naviera1);
//		no sé cómo testear
	}
	
  	@Test
  	void testEnvio() {
		terminalPortuaria.envio(shipper1, carga1, viaje1, camion1, chofer1);
		
	}
  	
  	@Test
  	void testRecepcion() {
		terminalPortuaria.recepcion(consignee1, carga1, viaje1, camion1, chofer1);
	
  	}
  	
  	@Test
  	void testAsignarTurno() {
  		terminalPortuaria.asignarTurno(shipper1);
  		terminalPortuaria.asignarTurno(consignee1);

  	}
  	
  	
  	@Test
  	void testFiltrar() {
  		terminalPortuaria.filtrar();

  	}
  	
  	void testElMejorCircuito() {
  		terminalPortuaria.elMejorCircuito(terminal1);
  		
  	}
  	@Test
  	void testSetPrioridad() {
  		terminalPortuaria.setPrioridad(prioridad1);
  		assertEquals(prioridad1, terminalPortuaria.getPrioridad());
  	}
  	@Test
  	void testGetPrioridad() {
  		terminalPortuaria.getPrioridad();
  		assertEquals(prioridad1, terminalPortuaria.getPrioridad());

  	}
  	
  	void testvalidarTransporteCarga() {
  		terminalPortuaria.validarTransporteCarga(orden1);
  		
  	}
  	
  	void testValidarTurno() {
  		terminalPortuaria.validarTurno(camion1);
  		
  	}
  	
  	void testValidarCamionYChofer() {
  		terminalPortuaria.validarCamionYChofer(camion1, chofer1);
  		
  	}
  	
  	void testTiempoHasta() {
  		terminalPortuaria.tiempoHasta(terminal1);
  		
  	}
  	
  	void testHayCircuitoCon() {
  		terminalPortuaria.hayCircuitoCon(terminal1);
  		
  	}
  	
  	void testProximaPartidaHasta() {
  		terminalPortuaria.proximaPartidaHasta(terminal1);
  		
  	}
  	
  	void testHayPartidasA() {
  		terminalPortuaria.hayPartidasA(terminal1);
  		
  	}
  	
  	void testContratar() {
  		terminalPortuaria.contratar(servicio1, orden1);
  		
  	}
  	
  	void testCronogramaSalidaViajes() {
  		terminalPortuaria.cronogramaSalidaViajes();
  		
  	}
}
