package model.NavierasYCircuitos;

import java.util.ArrayList;
import java.util.List;

import model.Terminal;
import model.Viaje;

public class Naviera {
	private ArrayList<CircuitoMartimo> circuitos;
	private ArrayList<Viaje> viajes;
	private ArrayList<Buque> buques;

	public Naviera(ArrayList<CircuitoMartimo> circuitos, ArrayList<Viaje> viajes, ArrayList<Buque> buques) {
		// TODO Auto-generated constructor stub
		this.circuitos = circuitos;
		this.viajes = viajes;
		this.buques = buques;
	}

	public void agregarCircuito(CircuitoMartimo circuito) {
		// TODO Auto-generated method stub
		this.circuitos.add(circuito);
		
	}

	public ArrayList<CircuitoMartimo> getCircuitos() {
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

	public void quitarCircuito(CircuitoMartimo circuito) {
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
