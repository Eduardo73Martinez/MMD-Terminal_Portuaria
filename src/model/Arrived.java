package model;

public class Arrived implements BuqueState {

	private Working faseSiguiente;

	public Arrived(Working fase) {
		this.faseSiguiente = fase;
	}

	@Override
	public Working siguiente(Buque b) {
//		this.faseSiguiente = (Working) fase;
		return this.faseSiguiente;
	}
	
	@Override
	public boolean hayPosibilidadDeCambio(Buque buque) {
		// TODO Auto-generated method stub
		return buque.hayOrdenDeWorking();
	}
}
