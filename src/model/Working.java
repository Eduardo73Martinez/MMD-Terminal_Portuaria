package model;

public class Working implements BuqueState {

	private Departing faseSiguiente;

	public Working(Departing fase) {
		this.faseSiguiente = fase;
	}
	
	@Override
	public Departing siguiente() {
		return this.faseSiguiente;
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
			buque.setFase(this.siguiente());
		}
	}
}