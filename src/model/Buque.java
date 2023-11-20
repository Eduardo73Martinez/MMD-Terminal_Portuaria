package model;

import java.util.ArrayList;
import java.util.List;

public class Buque {

	private BuqueState		fase;
	private List<Carga> 	cargas 	 = new ArrayList<Carga>();
	private Posicion 		posicion;
	private GPS				gps;
	private Viaje			viaje;
	private int				tramoActual;
	private boolean permitirCambioFase = false;
 
	public Buque(BuqueState fase, Viaje viaje, GPS gps) {
		// TODO Auto-generated constructor stub
		this.fase = fase;
		this.viaje = viaje;
		this.tramoActual = 0;
		this.gps = gps;
		this.posicion = gps.getPosicion();
	}

	public Posicion getPosicion() {
		// TODO Auto-generated method stub
		return this.gps.getPosicion();
	}

	public void preavisoA(Terminal terminal) {
		// TODO Auto-generated method stub
		terminal.recibirPreavisoPor(this);
	}

	public float distanciaA(Terminal terminal) {
		// TODO Auto-generated method stub
		return this.distancia(this.getPosicion(), terminal.getPosicion());
	}

	public float distancia(Posicion p1, Posicion p2) {
		// Taken from: https://stackoverflow.com/questions/14431032/i-want-to-calculate-the-distance-between-two-points-in-java
		return (float) Math.hypot( (p1.getLatitud() - p2.getLatitud())
						 , (p1.getLongitud() - p2.getLongitud()) );
	}

	public BuqueState getFase() {
		// TODO Auto-generated method stub
		return this.fase;
	}

	private void cambiarFase() {
		// TODO Auto-generated method stub
		this.setPermitirCambioFase(true);
		this.recibir(this.fase.siguiente(this));
		this.setPermitirCambioFase(false);
	}

	private void setPermitirCambioFase(boolean b) {
		// TODO Auto-generated method stub
		this.permitirCambioFase = b;
	}

	private void setFase(BuqueState fase) {
		// TODO Auto-generated method stub
		this.fase = fase;
	}

	public void recibir(BuqueState fase) {
		// TODO Auto-generated method stub
		if (this.getPermitirCambioFase() ) {
			this.setFase(fase);
		}
	}

	public boolean getPermitirCambioFase() {
		// TODO Auto-generated method stub
		return this.permitirCambioFase;
	}
	
	public void update() {
		// TODO Auto-generated method stub
		if (this.fase.hayPosibilidadDeCambio(this)) {
			this.cambiarFase();
			this.tramoActual++;
		}
	}

	public float kmsProximaTerminal() {
		// TODO Auto-generated method stub
		return this.distanciaA(this.viaje.getProximaTerminal());
	}

	public boolean hayOrdenDeDepart() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean hayOrdenDeWorking() {
		// TODO Auto-generated method stub
		return true;
	}

	public void enviarEmailA(Terminal terminal) {
		// TODO Auto-generated method stub
		terminal.recibirEmail(new Email("Llegando" ,this.viaje.getOrden()));
	} 
}
