package model;

import java.util.Timer;

public class GPS {

	private Posicion	posicion;
	private float		timer;// = new Timer() // TODO

	public GPS() {}
	
	public GPS(float timer) { // FIXME
		// TODO Auto-generated constructor stub
		this.timer = timer;
	}

	public GPS(float timer, Posicion posicion) { // Solo para testear posicion
		// TODO Auto-generated constructor stub
		this.timer = timer;
		this.posicion = posicion;
	}

	public Posicion getPosicion() { return this.posicion; }
	private void setPosicion(Posicion newPosicion) { this.posicion = newPosicion; }
	
	public float getTimer() { return this.timer; }
	public void setTimer(float newTime) { this.timer = newTime; } //FIXME
}
