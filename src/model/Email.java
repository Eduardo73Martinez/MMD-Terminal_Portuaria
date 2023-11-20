/**
 * 
 */
package model;

/**
 * @author Martinez Eduardo
 *
 */
public class Email {
	private String mensaje;
	private OrdenBasicaTP orden;

	public Email(String mensaje, OrdenBasicaTP orden) {
		super();
		this.mensaje = mensaje;
		this.orden = orden;
	}

	public String getMensaje() {
		return mensaje;
	}

	public OrdenBasicaTP getOrden() {
		return orden;
	}

}
