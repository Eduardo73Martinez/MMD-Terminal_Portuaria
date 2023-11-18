package model;

public class Inbound implements BuqueState {

	private Arrived faseSiguiente;

	@Override
	public void siguiente(Buque buque) {
		buque.setFase(this.faseSiguiente);
	}
}
