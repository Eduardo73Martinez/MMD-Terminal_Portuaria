/**
 * 
 */
package model;

import static org.mockito.ArgumentMatchers.same;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




/**
 * @author Martinez Eduardo
 *
 */
public class CircuitoMaritimo {
	private ArrayList<Tramo> tramos;

	/**
	 * Requerimentos minimos necesarios:
	 * 
	 * 1) los tramos anterior y siguiente deben pertenecer a la coleccion de tramos
	 * 2) el tramoAnterior y tramoSiguiente dados son correlativos en el circuito
	 * (que no quiere decir que estan ordenados en la coleccion) 3) el tramo nuevo
	 * tiene en su terminal de origen una terminal nueva.
	 */
	public void agregarTramoEntre(Tramo nuevoTramo, Tramo tramoAnterior, Tramo tramoSiguiente) {

		this.validarTramoEntre(nuevoTramo, tramoAnterior, tramoSiguiente); // verifica los requerimentos.
		// los sacamos del array para actualizarlos
		this.quitarTramo(tramoAnterior);
		this.quitarTramo(tramoSiguiente);

		// los actualizamos con las nuevas terminales
		tramoAnterior.setDestino(nuevoTramo.getOrigen());
		nuevoTramo.setDestino(tramoSiguiente.getOrigen());
		tramoSiguiente.setOrigen(nuevoTramo.getDestino());

		// los agregamos a la coleccion
		this.tramos.add(tramoAnterior);
		this.tramos.add(nuevoTramo);
		this.tramos.add(tramoSiguiente);
	} 

	public CircuitoMaritimo(ArrayList<Tramo> tramos) {
		super();
		this.tramos = tramos;
	}

	public ArrayList<Tramo> getTramos() {
		// TODO Auto-generated method stub
		return this.tramos;
	}

	public void quitarTramo(Tramo tramoNavegacion) {
		// TODO Auto-generated method stub
		this.tramos.remove(tramoNavegacion);

	}

	public void validarTramoEntre(Tramo nuevoTramo, Tramo tramoAnterior, Tramo tramoSiguiente) {
		// TODO Auto-generated method stub
		if (!this.tramos.contains(tramoAnterior) && !this.tramos.contains(tramoSiguiente)) {
			throw new Error("Alguno de los tramos dados no pertenece al circuito");
		}
		if (tramoAnterior.getDestino() != tramoSiguiente.getOrigen()) {
			throw new Error("Los tramos dados no son correlativos");
		}

	}

	public double tiempoTotalDelCircuito() {
		return this.tramos.stream().mapToDouble(s -> s.getTiempo()).sum();

	}

	public double precioTotal() {
		// TODO Auto-generated method stub
		return this.tramos.stream().mapToDouble(s -> s.getPrecio()).sum();
	}

	public double precioTotalEntre(Terminal origen, Terminal destino) {
		// TODO Auto-generated method stub
		Optional<Tramo> tramoOrigen =  this.tramos.stream()
				.filter(t -> t.getOrigen().equals(origen))
				.findFirst();
		// Tengo el tramo origen
		// Recorro los siguientes tramos y acumulo precio
		// Encuentro el tramo con el destino y corto
		// Retorno el precio acumulado
		return null;
	}

	public double tiempoTotalEntre(Terminal origen, Terminal destino) {
		// TODO Auto-generated method stub
		// Tengo el tramo origen
		// Recorro los siguientes tramos y acumulo tiempo
		// Encuentro el tramo con el destino y corto
		// Retorno el tiempo acumulado
		return null;
	}

}
