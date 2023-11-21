package model;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte {
	private List<Camion> camiones = new ArrayList<Camion>();
	private List<Chofer> choferes = new ArrayList<Chofer>();
	
	List<Camion> getCamiones() {
		// TODO Auto-generated method stub
		return this.camiones;
	}
	
	void agregarCamion(Camion camion) { 
		// TODO Auto-generated method stub		
		this.camiones.add(camion);
	}
	
	void quitarCamion(Camion camion) { 
		// TODO Auto-generated method stub		
		this.camiones.remove(camion);
	}

	List<Chofer> getChoferes() {
		// TODO Auto-generated method stub
		return this.choferes;
	}

	 void agregarChofer(Chofer chofer1) {
		// TODO Auto-generated method stub
		this.choferes.add(chofer1);
	}

	 void quitarChofer(Chofer chofer1) {
		// TODO Auto-generated method stub
		this.choferes.remove(chofer1);
	}
	
}
