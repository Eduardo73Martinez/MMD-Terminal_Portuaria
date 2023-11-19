package model;

public class Departing implements BuqueState {

	private Outbound faseSiguiente;

	public Departing(Outbound fase) {
		this.faseSiguiente = fase;
	}

	@Override
	public Outbound siguiente() {
//		this.faseSiguiente = (Outbound) fase;
		return this.faseSiguiente;
	}
}
