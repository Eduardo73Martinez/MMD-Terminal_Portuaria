package model;

/**
 *  @author Eduardo Martinez
 */

import java.util.Date;

public class Factura {
	private Date fecha;
	private String cliente;
	private OrdenBasicaTP orden;
	private Viaje viaje;

	public Factura(Date fecha, String cliente, OrdenBasicaTP orden, Viaje viaje) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.orden = orden;
		this.viaje = viaje;
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

	public double getMontoTotal() {
		// TODO Auto-generated method stub
		return this.orden.getMontoTotal() + this.viaje.getCosto();
	}

}
