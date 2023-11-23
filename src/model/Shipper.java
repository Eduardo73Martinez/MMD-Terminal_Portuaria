package model;

import java.util.List;

public class Shipper implements ICliente {
	private ICliente clienteFiltro;
	private List<OrdenExportacion> ordenesDeInteres;

	@Override
	public void recibirEmail(Email email) {
		// TODO Auto-generated method stub
		if (this.ordenesDeInteres.contains(email.getFactura().getOrden())) {
			this.clienteFiltro.recibirEmail(email);
			// si la orden pertenece a las ordenes de exportacion de interes entonces la
			// envia al cliente. }
			// en caso contrario el cliente no la recibe.
		}
	}

}
