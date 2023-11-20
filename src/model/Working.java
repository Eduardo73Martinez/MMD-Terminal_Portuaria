package model;

public class Working implements BuqueState {

	private Departing faseSiguiente;

	public Working(Departing fase) {
		this.faseSiguiente = fase;
	}

	@Override
	public Departing siguiente(Buque b) {
//		this.faseSiguiente = (Departing) fase;
		return this.faseSiguiente;
	}

	@Override
	public boolean hayPosibilidadDeCambio(Buque buque) {
		// TODO Auto-generated method stub
		return buque.hayOrdenDeDepart();
	}
}
