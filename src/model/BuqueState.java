package model;

public interface BuqueState {

	public BuqueState siguiente();

	public void gestionarCambio(Buque buque);

	public boolean hayPosibilidadDeCambio(Buque buque);

	public void avisarCambio(Buque buque);

}
