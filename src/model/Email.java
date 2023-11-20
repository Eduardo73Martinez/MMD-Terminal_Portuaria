/**
 * 
 */
package model;

/**
 * @author Martinez Eduardo
 *
 */
public class Email {
	private String Mensaje;
	private  OrdenImportacion orden;
	
	public Email(String mensaje, OrdenImportacion orden) {
		super();
		Mensaje = mensaje;
		this.orden = orden;
	}
	

}
