/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Martinez Eduardo
 *
 */
public class CircuitoMaritimo {
	private ArrayList<Tramo> tramos;

	public CircuitoMaritimo(Tramo inicio, Tramo fin) {
		// this.validarOrigenesDiferentes(inicio, fin);
		// this.validarDireccionRecorrido(inicio, fin);
		// this.validarDireccionRecorrido(fin, inicio);
		this.tramos = new ArrayList<>();
		this.tramos.add(inicio);
		this.tramos.add(fin);
		// si o si cuando se instancia un circuito se agregan dos tramos.
	}

	/**
	 * Requerimentos minimos necesarios:
	 * 
	 * 1) el tramo anterior deben pertenecer a la coleccion de tramos. 2) el
	 * tramoAnterior y tramoSiguiente dados son correlativos en el circuito 3) el
	 * tramo nuevo tiene en su terminal de origen una terminal nueva.
	 */
	public void agregarTramoLuegoDe(Tramo nuevoTramo, Tramo tramoAnterior) {

		this.validarTramoNuevo(nuevoTramo);
		this.validarExistencia(tramoAnterior);

		int indiceTAnterior = this.tramos.indexOf(tramoAnterior);

		if (this.esUltimoTramo(tramoAnterior)) {
			nuevoTramo.setDestino(this.tramos.get(0).getOrigen()); 
			// si es el último tramo le settea  el origen para que cierre el circuito nuevamente.
		} else {
			nuevoTramo.setDestino(this.tramos.get(indiceTAnterior).getDestino());
			//si no es el último se le settea como destino ,al tramo nuevo, el destino que ya estaba en el tramo anterior.
		}
		this.tramos.get(indiceTAnterior).setDestino(nuevoTramo.getOrigen()); // se le settea como destino al tramo anterior el nuevo tramo
		this.tramos.add(indiceTAnterior + 1, nuevoTramo); // se agrega el nuevo tramo como consecutivo del tramo anterior.
		//el array corre todos los indices.
	}

	public boolean esUltimoTramo(Tramo tramo) {
		// TODO Auto-generated method stub
		return this.tramos.get(this.tramos.size() - 1).equals(tramo);
	}

	public void validarDireccionRecorrido(Tramo tramo1, Tramo tramo2) throws TramoExceptions {
		// TODO Auto-generated method stub
		if (!tramo1.getDestino().equals(tramo2.getOrigen())) {
			throw new TramoExceptions("El tramo1 no se dirige al tramo2 ");
		}
	}

	public void validarOrigenesDiferentes(Tramo tramo1, Tramo tramo2) throws TramoExceptions {
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

	public void validarTramoNuevo(Tramo nuevoTramo) throws TramoExceptions {
		if (this.tramos.contains(nuevoTramo)) {
			throw new TramoExceptions("El tramo ya existe en el circuito ");
		}
	}

	public void validarExistencia(Tramo tramo) throws TramoExceptions {
		if (!this.tramos.contains(tramo)) {
			throw new TramoExceptions("El tramo dado no existe en el circuito");
		}
	}

	public void validarTerminalEnCircuito(Terminal terminalAValidar) throws TramoExceptions {
		if (!this.perteneceAlCircuito(terminalAValidar)) {
			throw new TramoExceptions("La terminal dada no pertenece al circuito");
		}
	}

	public boolean perteneceAlCircuito(Terminal terminal) {
		return this.tramos.stream().anyMatch(s -> s.getOrigen() == terminal);
	}

	public int tiempoTotalDelCircuito() {
		return this.tramos.stream().mapToInt(s -> s.getTiempo()).sum();
	}

	public double precioTotal() {
		return this.tramos.stream().mapToDouble(s -> s.getPrecio()).sum();
	}

	public double precioTotalEntre(Terminal teminalOrigen, Terminal teminalDestino) throws TramoExceptions {
		ArrayList<Tramo> tramosRecorridos = this.tramosRecorridosEntre(teminalOrigen, teminalDestino);
		return tramosRecorridos.stream().mapToDouble(s -> s.getPrecio()).sum();
	}

	public Tramo tramoConTerminal(Terminal terminal) throws NoSuchElementException {
		return this.tramos.stream().filter(t -> t.getOrigen().equals(terminal)).findFirst().orElseThrow();
	}

	public ArrayList<Tramo> tramosRecorridosEntre(Terminal teminalOrigen, Terminal teminalDestino)
			throws TramoExceptions {
		this.validarTerminalEnCircuito(teminalOrigen); // valido que exista la terminal origen
		this.validarTerminalEnCircuito(teminalDestino); // valido que exista la terminal destino
		Tramo tramoOrigen = this.tramoConTerminal(teminalOrigen); // Tengo el tramo con Terminal origen
		int itramoOrigen = this.tramos.indexOf(tramoOrigen); // obtengo su indice en la coleccion
		Tramo tramoDestino = this.tramoConTerminal(teminalDestino);// Encuentro el tramo con Terminal destino
		int itramoDestino = this.tramos.indexOf(tramoDestino); // obtengo su indice en la coleccion
		ArrayList<Tramo> tramosRecorridos = new ArrayList<>(); // creo una coleccion nueva para el recorrido neto
		int i = 0;
		for (Tramo t : this.tramos) {
			if (i >= itramoOrigen && i <= itramoDestino) {
				tramosRecorridos.add(t); // almaceno solo los tramos recorridos, los estoy filtrando por su idice.
			}
			i++; // actualizo el indice
		}
		return tramosRecorridos; // devuelvo los tramos recorridos
	}

	public double tiempoTotalEntre(Terminal origen, Terminal destino) throws TramoExceptions {
		ArrayList<Tramo> tramosRecorridos = this.tramosRecorridosEntre(origen, destino);
		return tramosRecorridos.stream().mapToDouble(s -> s.getTiempo()).sum();
	}

	public Integer nroTerminalesTotalEntre(Terminal origen, Terminal destino) throws TramoExceptions {
		ArrayList<Tramo> tramosRecorridos = this.tramosRecorridosEntre(origen, destino);
		return tramosRecorridos.size();
	}
	/**
	 * 
	 * @return Terminal 
	 * según el modelo del circuito no necesito de un bloque Try/catch  en estas 
	 * ultimas dos funciones getTerminalDestino()/getTerminalOrigen() porque siempre voy
	 * a tener una terminal de origen y otra de destino en el circuito
	 * si no fuera así deberia agregar una excepcion. La version anterior 
	 * la contenia.
	 */
	public Terminal getTerminalDestino()  {
		// TODO Auto-generated method stub
			return this.tramos.get(tramos.size() - 1).getOrigen();

	}

	public Terminal getTerminalOrigen()  {
		// TODO Auto-generated method stub
			return this.tramos.get(0).getOrigen();
			// si tenemos un circuito si o si tenemos una terminal.
	}
}