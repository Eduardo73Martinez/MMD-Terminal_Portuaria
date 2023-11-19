package model;

public class Inbound implements BuqueState {

	private Arrived faseSiguiente;

	public Inbound(Arrived fase) {
		this.faseSiguiente = fase;
	}

	@Override
	public Arrived siguiente() {
//		this.faseSiguiente = (Arrived) fase;
		return this.faseSiguiente;
	}
}
