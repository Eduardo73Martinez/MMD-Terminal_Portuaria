package model;

public class Outbound implements BuqueState {

	private Inbound faseSiguiente;

	@Override
	public void siguiente(Buque buque) {
		buque.setFase(this.faseSiguiente);
	}
}
