package model;

public class Departing implements BuqueState {

	private Outbound faseSiguiente;

	@Override
	public void siguiente(Buque buque) {
		buque.setFase(this.faseSiguiente);
	}
}
