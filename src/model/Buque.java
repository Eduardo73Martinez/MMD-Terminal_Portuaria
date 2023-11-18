package model;

import java.util.ArrayList;
import java.util.List;

public class Buque {

	private BuqueState		fase;
	private List<Carga> 	cargas 	 = new ArrayList<Carga>();
	private Posicion		posicion;
	private GPS				gps;
	private Viaje			viaje;

	public Buque(BuqueState fase, GPS gps, Viaje viaje) {
		// TODO Auto-generated constructor stub
		this.fase = fase;
		this.viaje = viaje;
		this.gps = gps;
		this.posicion = this.gps.getPosicion();
	}

	private Posicion getPosicion() {
		// TODO Auto-generated method stub
		return this.posicion;
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

	public void cambiarFase(Buque b) {
		// TODO Auto-generated method stub
		this.fase.siguiente(b);
	}

	protected void setFase(BuqueState fase) {
		// TODO Auto-generated method stub
		this.fase = fase;
	}

}
