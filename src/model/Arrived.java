package model;

public class Arrived implements BuqueState {

	private Working faseSiguiente;

	public Arrived(Working fase) {
		this.faseSiguiente = fase;
	}
	
	@Override
	public Working siguiente() {
		return this.faseSiguiente;
	}
	
	@Override
	public boolean hayPosibilidadDeCambio(Buque buque) {
		// TODO Auto-generated method stub
		return buque.hayOrdenDeWorking();
	}

	@Override
	public void avisarCambio(Buque buque) { // Por polimorfismo
		// Debería avisar a la naviera:
		// Posibilidades:
		// 	a) Completó su viaje (Está en la terminal origen y tiene que asignarse nuevo viaje)
		//  b) Sigue su viaje (la naviera NO asigna nuevo viaje)
		if (buque.enUltimoTramo()) {
			// Naviera tendría que asignarle nuevo viaje
		}
	}

	@Override
	public void gestionarCambio(Buque buque) {
		// TODO Auto-generated method stub
		if (this.hayPosibilidadDeCambio(buque)) {
			this.avisarCambio(buque);
			buque.setFase(this.siguiente());
		}
	}
}
