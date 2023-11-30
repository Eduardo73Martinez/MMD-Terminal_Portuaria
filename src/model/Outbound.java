package model;

public class Outbound implements BuqueState {

	private Inbound siguiente;
	private float kmANuevaTerminal = 50; //Kms

	public Outbound() {}

	public void setSiguiente(Inbound fase) {
		this.siguiente = fase;
	}

	@Override
	public boolean hayPosibilidadDeCambio(Buque buque) {
		// TODO Auto-generated method stub
		return (buque.kmsProximaTerminal() != 0 &&
				buque.kmsProximaTerminal() >= this.kmANuevaTerminal);
	}

	@Override
	public void avisarCambio(Buque buque) {
		// TODO Auto-generated method stub
		buque.enviarEmailA(buque.getProximaTerminal());
	}

	@Override
	public void gestionarCambio(Buque buque) {
		// TODO Auto-generated method stub
		if (this.hayPosibilidadDeCambio(buque)) {
			this.avisarCambio(buque);
			buque.setFase(this.siguiente);
		}
	}
}
