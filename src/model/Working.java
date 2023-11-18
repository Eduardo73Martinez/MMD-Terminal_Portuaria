package model;

public class Working implements BuqueState {

	private Departing faseSiguiente;

	@Override
	public void siguiente(Buque buque) {
		buque.setFase(this.faseSiguiente);
	}
}
