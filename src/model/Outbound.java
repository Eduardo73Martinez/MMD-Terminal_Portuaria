package model;

public class Outbound implements BuqueState {

	private Inbound faseSiguiente;

	public Outbound() {}

	public void setSiguiente(Inbound fase) {
		this.faseSiguiente = fase;
	}

	@Override
	public Inbound siguiente() {
//		this.faseSiguiente = (Inbound) fase;
		return this.faseSiguiente;
	}
}
