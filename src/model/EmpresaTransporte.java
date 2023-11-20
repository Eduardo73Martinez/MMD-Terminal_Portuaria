package model;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte {
	private List<Camion> camiones = new ArrayList<Camion>();

	public List<Camion> getCamiones() {
		// TODO Auto-generated method stub
		return this.camiones;
	}

	public void agregarCamion(Camion camion) {
		// TODO Auto-generated method stub
		this.camiones.add(camion);
	}

	public void quitarCamion(Camion camion) {
		// TODO Auto-generated method stub
		this.camiones.remove(camion);
	}

}
