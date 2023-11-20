package model;

/**
 *  @author Eduardo Martinez
 */

import java.util.Date;

public class Factura {
	private Date fecha;
	private String cliente;
	private OrdenBasicaTP orden;

	public Factura(Date fecha, String cliente, OrdenBasicaTP orden) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.orden = orden;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public OrdenBasicaTP getOrden() {
		return orden;
	}

	public void getMontoTotal() {
		// TODO Auto-generated method stub
		this.orden.getMontoTotal();
	}

}
