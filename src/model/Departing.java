package model;

public class Departing implements BuqueState {

	private Outbound faseSiguiente;
	private float kmANuevaTerminal = 1; //Kms

	public Departing(Outbound fase) {
		this.faseSiguiente = fase;
	}
	
	@Override
	public Outbound siguiente() {
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
		if (!buque.enUltimoTramo()) {
			buque.siguienteTramo();
		}
	}
	
	@Override
	public void gestionarCambio(Buque buque) {
		// TODO Auto-generated method stub
		if (this.hayPosibilidadDeCambio(buque)) {
			this.avisarCambio(buque);
			buque.setFase(this.siguiente());
		}
	}
}