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
	private Factura factura;

	public Email(String mensaje, Factura factura) {
		super();
		this.mensaje = mensaje;
		this.factura = factura;
	}

	public String getMensaje() {
		return mensaje;
	}

	public OrdenBasicaTP getOrden() {
		return this.factura.getOrden();
	}

	public Factura getFactura() {
		return factura;
	}

}
