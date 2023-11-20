package model;

public class Arrived implements BuqueState {

	private Working faseSiguiente;

	public Arrived(Working fase) {
		this.faseSiguiente = fase;
	}

	@Override
	public Working siguiente() {
//		this.faseSiguiente = (Working) fase;
		return this.faseSiguiente;
	}
}
