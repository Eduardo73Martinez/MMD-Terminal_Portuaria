package model;

import java.util.ArrayList;
import java.util.List;

public class Camion {

	private Chofer chofer;
	private Turno turno;
	private List<Carga> cargas = new ArrayList<Carga>();

	 Chofer getChofer() {
		// TODO Auto-generated method stub
		return this.chofer;
	}

	 void setChofer(Chofer chofer) {
		// TODO Auto-generated method stub
		this.chofer = chofer;
	}

	Turno getTurno() {
		// TODO Auto-generated method stub
		return this.turno;
	}

	void setTurno(Turno turno) {
		// TODO Auto-generated method stub
		this.turno = turno;
	}

	List<Carga> getCargas() {
		// TODO Auto-generated method stub
		return this.cargas;
	}

	void agregarCarga(Carga carga) {
		// TODO Auto-generated method stub
		this.cargas.add(carga);
	}

	void quitarCarga(Carga carga) {
		// TODO Auto-generated method stub
		this.cargas.remove(carga);
	}

}
