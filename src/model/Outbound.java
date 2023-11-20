package model;

public class Outbound implements BuqueState {

	private Inbound faseSiguiente;
	private float kmANuevaTerminal = 50; //Kms

	public Outbound() {}

	public void setSiguiente(Inbound fase) {
		this.faseSiguiente = fase;
	}

	@Override
	public Inbound siguiente(Buque b) {
//		this.faseSiguiente = (Inbound) fase;
		return this.faseSiguiente;
	}

	@Override
	public boolean hayPosibilidadDeCambio(Buque buque) {
		// TODO Auto-generated method stub
		return (buque.kmsProximaTerminal() != 0 &&
				buque.kmsProximaTerminal() > this.kmANuevaTerminal);
	}
}
