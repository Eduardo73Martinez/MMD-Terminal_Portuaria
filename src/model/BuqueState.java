package model;

public interface BuqueState {

	public void gestionarCambio(Buque buque);

	public boolean hayPosibilidadDeCambio(Buque buque);

	public void avisarCambio(Buque buque);

}
