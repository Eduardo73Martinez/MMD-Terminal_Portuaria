package model;

public interface BuqueState {

	public BuqueState siguiente(Buque b);

	public boolean hayPosibilidadDeCambio(Buque buque);

	public void avisarCambio(Buque buque);

}
