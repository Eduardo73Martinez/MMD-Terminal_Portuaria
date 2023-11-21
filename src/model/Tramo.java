/**
 * 
 */
package model;

/**
 * @author Martinez Eduardo
 *
 */
public class Tramo {
	private Terminal terminalOrigen; 
	private Terminal terminalDestino;
	private double precio;
	private int tiempo; 
	// el tiempo lo medelo como un double pueden ser meses, horas, dias,etc. 
	// yo lo pensé como si fuesen dias.

	public Tramo(Terminal origen, Terminal destino, double precio, int tiempo) {
		// TODO Auto-generated constructor stub
		this.terminalOrigen = origen;
		this.terminalDestino = destino;
		this.precio = precio;
		this.tiempo = tiempo; 
	}

	public Terminal getOrigen() {
		// TODO Auto-generated method stub
		return this.terminalOrigen;
	}

	public Terminal getDestino() {
		// TODO Auto-generated method stub
		return this.terminalDestino;
	}

	public int getTiempo() {
		// TODO Auto-generated method stub
		return this.tiempo;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setDestino(Terminal destino) {
		// TODO Auto-generated method stub
		this.terminalDestino = destino;
		
	}
	public void setOrigen(Terminal origen) {
		// TODO Auto-generated method stub
		this.terminalOrigen = origen;
	}

}
