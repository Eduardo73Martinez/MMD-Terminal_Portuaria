package model;

import java.util.ArrayList;
import java.util.List;

public class Naviera {
	private ArrayList<CircuitoMaritimo> circuitos;
	private ArrayList<Viaje> viajes;
	private ArrayList<Buque> buques;

	public Naviera(ArrayList<CircuitoMaritimo> circuitos, ArrayList<Viaje> viajes, ArrayList<Buque> buques) {
		// TODO Auto-generated constructor stub
		this.circuitos = circuitos;
		this.viajes = viajes;
		this.buques = buques;
	}

	public void agregarCircuito(CircuitoMaritimo circuito) {
		// TODO Auto-generated method stub
		this.circuitos.add(circuito);
		
	}

	public ArrayList<CircuitoMaritimo> getCircuitos() {
		// TODO Auto-generated method stub
		return this.circuitos;
	}

	public void agregarBuque(Buque buque) {
		// TODO Auto-generated method stub
		this.buques.add(buque);
		
	}

	public ArrayList<Buque> getBuques() {
		// TODO Auto-generated method stub
		return this.buques;
	}

	public void quitarCircuito(CircuitoMaritimo circuito) {
		// TODO Auto-generated method stub
		this.circuitos.remove(circuito);
	}

	public void quitarBuque(Buque buque) {
		// TODO Auto-generated method stub
		this.buques.remove(buque);
		
	}

	public void agregarViaje(Viaje viaje) {
		// TODO Auto-generated method stub
		this.viajes.add(viaje);
	}

	public void quitarViaje(Viaje viaje) {
		// TODO Auto-generated method stub
		this.viajes.remove(viaje);
	}

	public ArrayList<Viaje> getViajes() {
		// TODO Auto-generated method stub
		return this.viajes;
	}

	public List<Viaje> cronograma(Terminal terminal) {
		// TODO Auto-generated method stub
		return terminal.cronogramaSalidaViajes();
	}


}
