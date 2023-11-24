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
	private OrdenBasicaTP orden;
	// suponemos que el viaje un recorrido de tramos de un circuito. Puede ser un
	// circuito completo si lo desea.

	public Viaje(LocalDate fechaDeSalida, CircuitoMaritimo circuito, Buque buque, OrdenBasicaTP orden) {
		this.fechaDeSalida = fechaDeSalida;
		this.recorrido = circuito;
		this.buque = buque;
		this.orden = orden;
		// this.validarViaje(tramos);
	}

	public LocalDate getFechaDeSalida() {
		// TODO Auto-generated method stub
		return this.fechaDeSalida;
	}

	public LocalDate getFechaDeLlegada() {
		// TODO Auto-generated method stub
		int diasDeViaje = this.recorrido.tiempoTotalDelCircuito();
		return this.fechaDeSalida.plusDays(diasDeViaje);
	}

	public Terminal getTerminalDestino() throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return this.recorrido.getTerminalDestino();
	}

	public Terminal getTerminalOrigen() {
		// TODO Auto-generated method stub
		return this.recorrido.getTerminalOrigen();
	}

	public void validarViaje(List<Tramo> tramos) throws TramoExceptions {
		if (!this.todosLosTramosPertencenAlCircuito(tramos)) {
			throw new TramoExceptions("El viaje completo no está en el circuito dado");
		}
	}

	public boolean todosLosTramosPertencenAlCircuito(List<Tramo> tramos) {
		return this.recorrido.getTramos().containsAll(tramos);
	}

	public double getCosto() {
		return this.recorrido.precioTotal();
	}

	public OrdenBasicaTP getOrden() {
		return this.orden;
	}

	public Tramo getTramo(int idxTramo) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return this.recorrido.getTramos().get(idxTramo);
	}

	public Buque getBuque() {
		// TODO Auto-generated method stub
		return this.buque;
	}

}
