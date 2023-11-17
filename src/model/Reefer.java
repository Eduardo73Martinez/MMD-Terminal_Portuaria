/**
 * 
 */
package model;

/**
 * @author Martinez Eduardo
 *
 */
public class Reefer extends Container {
	private double consumo; // el consumo asumimos que tiene en unidades de kw/h

	public Reefer(double ancho, double largo, double alto, double peso, double consumo) {
		// TODO Auto-generated constructor stub
		this.ancho = ancho;
		this.largo = largo;
		this.alto = alto;
		this.peso = peso; 
		this.consumo = consumo;
	}

	public double getConsumo() {
		// TODO Auto-generated method stub
		return this.consumo;
	}
	
	
}
