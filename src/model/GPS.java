package model;

import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.Random;

import java.util.TimerTask;

public class GPS extends TimerTask {

	private boolean 	reportar = false;
	private Buque 		buque;
	private Posicion 	posicion;
	private long 		periodo 	= 1;
	private Timer 		cronometro 	= new Timer(); 
	
	// variables para generar datos de la posición 
	private Random random = new Random();
	private List<Integer> diferenciales = Arrays.asList(1, -1, 0);

	public GPS(long periodo, Posicion posicion) {
		// TODO Auto-generated constructor stub
		this.periodo = periodo;
		this.posicion = posicion;
		this.cronometro.schedule(this, 0, this.getPeriodo());
	}

	public GPS(long periodo, Buque buque) {
		// TODO Auto-generated constructor stub
		this.periodo  = periodo;
		this.buque	  = buque;
		this.reportar = true;
		this.posicion = buque.getPosicion();
		this.cronometro.schedule(this, 0, this.getPeriodo());
	}


	public Posicion getPosicion() {
		return this.posicion;
	}

	private void setPosicion(Posicion newPosicion) {
		this.posicion = newPosicion;
	}

	public long getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(long periodoNuevo) {
		this.periodo = periodoNuevo;
		if (this.reportar) {
			this.buque.update(); // ¿hay que cambiar de fase?
		}
	} 

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.setPosicion(this.obtenerPosicion());		
	}

	public Posicion obtenerPosicion() {
		int dx = diferenciales.get(random.nextInt(diferenciales.size()));
		int dy = diferenciales.get(random.nextInt(diferenciales.size()));
		return (dx == 0 && dy == 0) ? posicion : new Posicion(posicion.getLatitud() + dx, posicion.getLongitud() + dy);
	}
}
