package model;

public class Posicion {

	public float	latitud;
	public float	longitud;
	
	public Posicion(float latitud, float longitud) {
		// TODO Auto-generated constructor stub
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public float getLatitud() 	{ return this.latitud; }
	public float getLongitud() { return this.longitud; }
	
}
