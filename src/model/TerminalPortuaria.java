package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TerminalPortuaria implements Terminal {

	private boolean buqueCerca;
	
	public void envio(Shipper shipper, Carga carga, Viaje viaje, Camion camion, Chofer chofer) {
		// TODO Auto-generated method stub
		
	}

	public void recepcion(Consignee consignee, Carga carga, Viaje viaje, Camion camion, Chofer chofer) {
		// TODO Auto-generated method stub
		
	}

	public void asignarTurno(ICliente cliente) {
		// TODO Auto-generated method stub
		
	}

	public void registrarEmpresa(EmpresaTransporte empresaTransporte) {
		// TODO Auto-generated method stub
		
	}

	public List<Viaje> filtrar() {
		// TODO Auto-generated method stub
		return null;
		
	}

	public CircuitoMaritimo elMejorCircuito(Terminal terminal) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPrioridad(IOrden orden) {
		// TODO Auto-generated method stub
		
	}
	
	public void validarLlegada(Camion camion) {
		// TODO Auto-generated method stub
		
	}

	public float tiempoHasta(Terminal terminal) {
		// TODO Auto-generated method stub
		return 0;
	}

	public LocalDate proximaPartidaHasta(Terminal terminal) {
		// TODO Auto-generated method stub
		return null;
	}

	public void contratar(ServicioContratable servicio, OrdenBasicaTP orden) {
		// TODO Auto-generated method stub
		
	}

	public List<Viaje> cronogramaSalidaViajes() {
		// TODO Auto-generated method stub
		return null;
	}


}
