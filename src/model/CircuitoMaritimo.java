/**
 * 
 */
package model;

import static org.mockito.ArgumentMatchers.same;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Martinez Eduardo
 *
 */
public class CircuitoMaritimo {
	private List<Tramo> tramos;

	public CircuitoMaritimo(Tramo inicio, Tramo fin) {
		this.validarOrigenesDiferentes(inicio, fin);
		this.validarDireccionRecorrido(inicio, fin);
		this.validarDireccionRecorrido(fin, inicio);
		this.tramos = Arrays.asList(inicio, fin);
		// si o si cuando se instancia un circuito se agregan dos tramos.
	}

	/**
	 * Requerimentos minimos necesarios:
	 * 
	 * 1) el tramo anterior deben pertenecer a la coleccion de tramos.
	 * 2) el tramoAnterior y tramoSiguiente dados son correlativos en el circuito
	 * (que no quiere decir que estan ordenados en la coleccion) 3) el tramo nuevo
	 * tiene en su terminal de origen una terminal nueva.
	 */
	public void agregarTramoLuegoDe(Tramo nuevoTramo, Tramo tramoAnterior) {

		this.validarTramoNuevo(nuevoTramo);
		this.validarExistencia(tramoAnterior);

		int indiceTAnterior = this.tramos.indexOf(tramoAnterior);

		if (this.esUltimoTramo(tramoAnterior)) {
			nuevoTramo.setDestino(this.tramos.get(0).getOrigen());
		} else {
			nuevoTramo.setDestino(this.tramos.get(indiceTAnterior + 1).getOrigen());
		}
		this.tramos.get(indiceTAnterior).setDestino(nuevoTramo.getOrigen());
		this.tramos.add(indiceTAnterior + 1, nuevoTramo);

	}

	private boolean esUltimoTramo(Tramo tramo) {
		// TODO Auto-generated method stub
		return this.tramos.get(this.tramos.size() - 1).equals(tramo);
	}

	private void validarDireccionRecorrido(Tramo tramo1, Tramo tramo2)  throws TramoExceptions{
		// TODO Auto-generated method stub
		if (!tramo1.getDestino().equals(tramo2.getOrigen())) {
			throw new TramoExceptions("El tramo1 no se dirige al tramo2 ");
		}
	}

	private void validarOrigenesDiferentes(Tramo tramo1, Tramo tramo2) throws TramoExceptions{
		// TODO Auto-generated method stub
		if (tramo1.getOrigen().equals(tramo2.getOrigen())) {
			throw new TramoExceptions("Los origenes de ambos terminales son iguales");
		}

	}

	public List<Tramo> getTramos() {
		// TODO Auto-generated method stub
		return this.tramos;
	}

	public void quitarTramo(Tramo tramoNavegacion) {
		// TODO Auto-generated method stub
		this.tramos.remove(tramoNavegacion);

	}

	public void validarTramoNuevo(Tramo nuevoTramo)  throws TramoExceptions{
		// TODO Auto-generated method stub
		if (this.tramos.contains(nuevoTramo)) {
			throw new TramoExceptions("El tramo ya existe en el circuito ");
		}
	}

	public void validarExistencia(Tramo tramo) throws TramoExceptions{
		if (!this.tramos.contains(tramo)) {
			throw new TramoExceptions("El tramo dado no existe en el circuito");
		}
	}

	public void validarTerminalEnCircuito(Terminal terminalAValidar)  throws TramoExceptions {
		if (!this.perteneceAlCircuito(terminalAValidar)) {
			throw new TramoExceptions("La terminal dada no pertenece al circuito");
		}
	}

	public boolean perteneceAlCircuito(Terminal terminal) {
		// TODO Auto-generated method stub
		return this.tramos.stream().anyMatch(s -> s.getOrigen() == terminal);
	}

	public double tiempoTotalDelCircuito() {
		return this.tramos.stream().mapToDouble(s -> s.getTiempo()).sum();
	}

	public double precioTotal() {
		// TODO Auto-generated method stub
		return this.tramos.stream().mapToDouble(s -> s.getPrecio()).sum();
	}

	public double precioTotalEntre(Terminal teminalOrigen, Terminal teminalDestino) {

		Optional<Tramo> tramoOrigen = this.tramos.stream().filter(t -> t.getOrigen().equals(teminalOrigen)).findFirst();

		this.validarTerminalEnCircuito(teminalOrigen);
		this.validarTerminalEnCircuito(teminalDestino);
		ArrayList<Tramo> tramosRecorridos;
		// Tengo el tramo origen
		// Recorro los siguientes tramos y acumulo precio
		// Encuentro el tramo con el destino y corto
		// Retorno el precio acumulado
		return (Double) null; 
	}

	public double tiempoTotalEntre(Terminal origen, Terminal destino) {
		// TODO Auto-generated method stub
		// Tengo el tramo origen
		// Recorro los siguientes tramos y acumulo tiempo
		// Encuentro el tramo con el destino y corto
		// Retorno el tiempo acumulado
		return (Double) null;
	}

	public Integer nroTerminalesTotalEntre(Terminal origen, Terminal destino) {
		// TODO Auto-generated method stub
		// Tengo el tramo origen
		// Recorro los siguientes tramos y acumulo cantidad de terminales vistas
		// Encuentro el tramo con el destino y corto
		// Retorno el nro de terminales vistas acumuladas
		return null;
	}

}
