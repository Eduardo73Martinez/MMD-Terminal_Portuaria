package model;

public class GPS {

	private Posicion	posicion;
	private float		timer = 1;

	public GPS() {}
	
	public GPS(float timer) {
		// TODO Auto-generated constructor stub
		this.timer = timer;
	}

	public Posicion getPosicion() { return this.posicion; }
	public void setPosicion(Posicion newPosicion) { this.posicion = newPosicion; }
	
	public float getTimer() { return this.timer; }
	public void setTimer(float newTimer) { this.timer = newTimer; }
}
