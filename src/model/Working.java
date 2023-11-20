package model;

public class Working implements BuqueState {

	private Departing faseSiguiente;

	public Working(Departing fase) {
		this.faseSiguiente = fase;
	}

	@Override
	public Departing siguiente() {
//		this.faseSiguiente = (Departing) fase;
		return this.faseSiguiente;
	}
}
