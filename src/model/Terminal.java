package model;

import java.util.List;

public interface Terminal {
	public List<Viaje> cronogramaSalidaViajes();

	public Boolean hayBuqueCerca();

	public void recibirPreavisoPor(Buque buque);

	public Posicion getPosicion();

	public void recibirEmail(Email email);
}
