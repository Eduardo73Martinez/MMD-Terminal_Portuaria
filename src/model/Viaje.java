package model;

import java.time.LocalDate;
import java.util.List;

/**
 * 
 * @author Martinez Eduardo
 *
 */
public class Viaje {
	private LocalDate fechaDeSalida;
	private CircuitoMaritimo recorrido;
	private Buque buque;
	private List<Tramo> tramos;
	private OrdenBasicaTP   orden;
	// suponemos que el viaje un recorrido de tramos de un circuito. Puede ser un
	// circuito completo si lo desea.

	public Viaje(LocalDate fechaDeSalida, 
			List<Tramo> tramos, 
			CircuitoMaritimo circuito, 
			Buque buque, OrdenBasicaTP orden) {
		this.fechaDeSalida = fechaDeSalida;
		this.tramos = tramos;
		this.recorrido = circuito;
		this.buque = buque;
		this.orden = orden;
		//this.validarViaje(tramos);
	}

	public LocalDate getFechaDeSalida() {
		// TODO Auto-generated method stub
		return this.fechaDeSalida;
	}

	public LocalDate getFechaDeLlegada() {
		// TODO Auto-generated method stub
		int diasDeViaje = this.tramos.stream().mapToInt(s -> s.getTiempo()).sum();
		return this.fechaDeSalida.plusDays(diasDeViaje);
	}

	public Terminal getTerminalDestino() throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		try {
			return this.tramos.get(tramos.size() - 1).getOrigen();
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("No hay terminal destino en el viaje");
		}
	}

	public Terminal getTerminalOrigen() throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		try {
			return this.tramos.get(0).getOrigen();
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("No hay terminal origen en el viaje");
		} 
	}

	public void validarViaje(List<Tramo> tramos) throws TramoExceptions {
		if (!this.recorrido.getTramos().containsAll(tramos)) {
			throw new TramoExceptions("El viaje completo no está en el circuito dado");
		}
	}

	public double getCosto() {
		return this.tramos.stream().mapToDouble(s -> s.getPrecio()).sum();
	}
	public OrdenBasicaTP getOrden() {
		return this.orden;
	}
	

}
