package model;

public class Departing implements BuqueState {

	private Outbound faseSiguiente;
	private float kmANuevaTerminal = 1; //Kms

	public Departing(Outbound fase) {
		this.faseSiguiente = fase;
	}

	@Override
	public Outbound siguiente(Buque b) {
//		this.faseSiguiente = (Outbound) fase;
		return this.faseSiguiente;
	}

	@Override
	public boolean hayPosibilidadDeCambio(Buque buque) {
		// TODO Auto-generated method stub
		return (buque.kmsProximaTerminal() != 0 &&
				buque.kmsProximaTerminal() <= this.kmANuevaTerminal);
	}
}