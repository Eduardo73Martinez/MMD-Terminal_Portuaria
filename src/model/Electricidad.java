package model;

import java.time.LocalDate;

public class Electricidad implements ServicioContratable {

	private float costoKWh;
	private Reefer container;
	private LocalDate inicioConexionElec;
	private LocalDate finalConexionElec;

	public Electricidad(Reefer reefer, LocalDate fechaInicio, LocalDate fechaFinal, float costoKWh) {
		// TODO Auto-generated constructor stub
		this.container = reefer;
		this.inicioConexionElec = fechaInicio;
		this.finalConexionElec = fechaFinal;
		this.costoKWh = costoKWh;
	}

	public float costoTotal() {
		// TODO Auto-generated method stub
		return (float) (this.horasContratadas()*this.costoKWh*this.container.getConsumo());
	}

	private float horasContratadas() {
		// TODO Auto-generated method stub
		return this.inicioConexionElec.until(this.finalConexionElec).getDays()*24;
	}

}
