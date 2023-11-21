package model;

public interface Terminal {

	public Posicion getPosicion();

	public void recibirEmail(Email email);

	public void recibirPreaviso(Buque buque);

}
