package model;

public class Working implements BuqueState {

	private Departing faseSiguiente;

	public Working(Departing fase) {
		this.faseSiguiente = fase;
	}

	@Override
	public Departing siguiente(Buque b) {
		b.recibir(this.faseSiguiente);
		return this.faseSiguiente;
	}

	@Override
	public boolean hayPosibilidadDeCambio(Buque buque) {
		// TODO Auto-generated method stub
		return !buque.enUltimoTramo() && buque.hayOrdenDeDepart();
	}

	@Override
	public void avisarCambio(Buque buque) {} // Por polimorfismo
}