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
	// suponemos que el viaje un recorrido de tramos de un circuito. Puede ser un
	// circuito completo si lo desea.

	public Viaje(LocalDate fechaDeSalida, List<Tramo> tramos, CircuitoMaritimo circuito, Buque buque) {
		this.fechaDeSalida = fechaDeSalida;
		this.tramos = tramos;
		this.recorrido = circuito;
		this.buque = buque;
		this.validarViaje(tramos);
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

	public Terminal getTerminalDestino() throws ArrayIndexOutOfBoundsException {
		// TODO Auto-generated method stub
		try {
			return this.tramos.get(tramos.size() - 1).getOrigen();
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("No hay terminal destino en el viaje");
		}
	}

	public Terminal getTerminalOrigen() throws ArrayIndexOutOfBoundsException {
		// TODO Auto-generated method stub
		try {
			return this.tramos.get(0).getOrigen();
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("No hay terminal origen en el viaje");
		}
	}

	public void validarViaje(List<Tramo> tramos) {
		if (!this.recorrido.getTramos().containsAll(tramos)) {
			throw new TramoExceptions("El viaje completo no está en el circuito dado");
		}
	}

	public double getCosto() {
		return this.tramos.stream().mapToDouble(s -> s.getPrecio()).sum();
	}

}
