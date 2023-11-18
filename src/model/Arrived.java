package model;

public class Arrived implements BuqueState {

	private Working faseSiguiente;

	@Override
	public void siguiente(Buque buque) {
		buque.setFase(this.faseSiguiente);
	}
}
