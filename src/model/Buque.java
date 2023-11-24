package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Buque {

	private BuqueState		fase;
	private List<Carga> 	cargas 	 = new ArrayList<Carga>();
	private GPS				gps; 
	private Viaje			viaje;
	private int				tramoActual;
 
	public Buque(BuqueState fase, Viaje viaje, GPS gps) {
		// TODO Auto-generated constructor stub
		this.fase = fase;
		this.viaje = viaje;
		this.tramoActual = 0;
		this.gps = gps;
	}

	public Posicion getPosicion() {
		// TODO Auto-generated method stub
		return this.gps.getPosicion();
	}

	public void preavisoA(Terminal terminal) {
		// TODO Auto-generated method stub
		terminal.recibirPreaviso(this);
	}

	public float distanciaA(Terminal terminal) {
		// TODO Auto-generated method stub
		return this.distancia(this.getPosicion(), terminal.getPosicion());
	}

	private float distancia(Posicion p1, Posicion p2) {
		// Taken from: https://stackoverflow.com/questions/14431032/i-want-to-calculate-the-distance-between-two-points-in-java
		return (float) Math.hypot( (p1.getLatitud() - p2.getLatitud())
						 , (p1.getLongitud() - p2.getLongitud()) );
	}

	public BuqueState getFase() {
		// TODO Auto-generated method stub
		return this.fase; 
	}

	void setFase(BuqueState fase) {
		// TODO Auto-generated method stub
		this.fase = fase;
	}

	public void update() {
		// TODO Auto-generated method stub
		this.fase.gestionarCambio(this);
	}
	
	public boolean enUltimoTramo() {
		// TODO Auto-generated method stub
		return this.viaje.getTerminalDestino().equals(this.getProximaTerminal());
	}
	
	void siguienteTramo() {
		// TODO Auto-generated method stub
		this.tramoActual++;
	}

	public float kmsProximaTerminal() {
		// TODO Auto-generated method stub
		return this.distanciaA(this.getProximaTerminal());
	}

	public Terminal getProximaTerminal() {
		// TODO Auto-generated method stub
		return this.viaje.getTramo(this.tramoActual).getDestino();
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
		Factura factura = new Factura(new Date(), "receptor", viaje.getOrden(), this.viaje);
		terminal.recibirEmail(new Email("Llegando" ,factura));
	}

}
