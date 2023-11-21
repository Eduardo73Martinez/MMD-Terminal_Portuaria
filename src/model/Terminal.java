package model;

import java.util.List;

public interface Terminal {

	public Posicion getPosicion();

	public void recibirEmail(Email email);

	public void recibirPreaviso(Buque buque);
	public List<Viaje> cronogramaSalidaViajes();

}
