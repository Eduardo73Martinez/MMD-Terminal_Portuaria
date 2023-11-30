package model;

public class Inbound implements BuqueState {

	private Arrived siguiente;
	private float kmANuevaTerminal = 0;

	public Inbound(Arrived fase) {
		this.siguiente = fase;
	}

	@Override
	public boolean hayPosibilidadDeCambio(Buque buque) {
		// TODO Auto-generated method stub
		return (this.kmANuevaTerminal == buque.kmsProximaTerminal());
	}

	@Override
	public void avisarCambio(Buque buque) {} // Por polimorfismo
	
	@Override
	public void gestionarCambio(Buque buque) {
		// TODO Auto-generated method stub
		if (this.hayPosibilidadDeCambio(buque)) {
			this.avisarCambio(buque);
			buque.setFase(this.siguiente);
		}
	}
}
