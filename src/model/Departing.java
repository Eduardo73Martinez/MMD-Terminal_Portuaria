package model;

public class Departing implements BuqueState {

	private Outbound faseSiguiente;
	private float kmANuevaTerminal = 1; //Kms

	public Departing(Outbound fase) {
		this.faseSiguiente = fase;
	}

	@Override
	public Outbound siguiente(Buque b) {
		b.avisarPartida(this);
		b.recibir(this.faseSiguiente);
		return this.faseSiguiente;
	}

	@Override
	public boolean hayPosibilidadDeCambio(Buque buque) {
		// TODO Auto-generated method stub
		return (buque.kmsProximaTerminal() != 0 &&
				buque.kmsProximaTerminal() <= this.kmANuevaTerminal);
	}

	@Override
	public void avisarCambio(Buque buque) {
		// TODO Auto-generated method stub
		buque.getProximaTerminal().recibirPreaviso(buque);
	}
}