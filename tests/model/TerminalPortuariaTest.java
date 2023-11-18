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
	private EmpresaTransporte 	empresaTransporte1;
	private List<Viaje>       	viajes;
	private Terminal          	terminal1;
	private CircuitoMaritimo  	circuito1;
    private IOrden			  	orden1;
    private ServicioContratable servicio1;
    private OrdenBasicaTP		orden2;
	
	// Setup (definición de SUT y DOC)
	@BeforeEach
	//DOC
	public void setUp() {
		this.shipper1   		= mock(Shipper.class);
		this.consignee1 		= mock(Consignee.class);
		this.carga1     		= mock(Carga.class);
		this.viaje1   			= mock(Viaje.class);
		this.viaje2   			= mock(Viaje.class);
		this.viaje3   			= mock(Viaje.class);
		this.camion1   			= mock(Camion.class);
		this.chofer1   			= mock(Chofer.class);
		this.cliente1   		= mock(ICliente.class);
		this.empresaTransporte1 = mock(EmpresaTransporte.class);
		this.terminal1  		= mock(Terminal.class);
		this.circuito1  		= mock(CircuitoMaritimo.class);
		this.orden1	    		= mock(IOrden.class);
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
  	void testRegistrarEmpresa() {
  		terminalPortuaria.registrarEmpresa(empresaTransporte1);

  	}
  	
  	@Test
  	void testFiltrar() {
  		terminalPortuaria.filtrar();

  	}

  	void testElMejorCircuito() {
  		terminalPortuaria.elMejorCircuito(terminal1);
  		
  	}

  	void testSetPrioridad() {
  		terminalPortuaria.setPrioridad(orden1);
  		
  	}  	
  	
  	void testValidarLlegada() {
  		terminalPortuaria.validarLlegada(camion1);
  		
  	}
  	
  	void testTiempoHasta() {
  		terminalPortuaria.tiempoHasta(terminal1);
  		
  	}
  	
  	void testProximaPartidaHasta() {
  		terminalPortuaria.proximaPartidaHasta(terminal1);
  		
  	}
  	
  	void testContratar() {
  		terminalPortuaria.contratar(servicio1, orden2);
  		
  	}
  	
  	void testCronogramaSalidaViajes() {
  		terminalPortuaria.cronogramaSalidaViajes();
  		
  	}
}
