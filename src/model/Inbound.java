package model;

public class Inbound implements BuqueState {

	private Arrived faseSiguiente;
	private float kmANuevaTerminal = 0;

	public Inbound(Arrived fase) {
		this.faseSiguiente = fase;
	}

	@Override
	public Arrived siguiente(Buque b) {
		b.recibir(this.faseSiguiente);
		return this.faseSiguiente;
	}

	@Override
	public boolean hayPosibilidadDeCambio(Buque buque) {
		// TODO Auto-generated method stub
		return (this.kmANuevaTerminal == buque.kmsProximaTerminal());
	}
}
