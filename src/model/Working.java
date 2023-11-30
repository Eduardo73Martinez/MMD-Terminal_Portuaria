package model;

public class Working implements BuqueState {

	private Departing siguiente;

	public Working(Departing fase) {
		this.siguiente = fase;
	}
	
	@Override
	public boolean hayPosibilidadDeCambio(Buque buque) {
		// TODO Auto-generated method stub
		return !buque.enUltimoTramo() && buque.hayOrdenDeDepart();
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