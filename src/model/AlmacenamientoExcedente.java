package model;

import java.time.LocalDate;

import javax.management.RuntimeErrorException;

public class AlmacenamientoExcedente implements ServicioCarga {

	private float		costoDiarioExc = 50;
	private LocalDate	inicioAlmac;
	private LocalDate	finalAlmac;

	public AlmacenamientoExcedente(LocalDate fechaInicio) {
		// TODO Auto-generated constructor stub
		this.inicioAlmac = fechaInicio;
	}

	@Override
	public float costoTotal() {
		// TODO Auto-generated method stub
		return this.diasDeAlmacenamiento()*this.costoDiarioExc;
	}

	private int diasDeAlmacenamiento() {
		// TODO Auto-generated method stub
		return this.inicioAlmac.until(this.finalAlmac).getDays();
	}
	
	public void registrarFechaFinalAlmacenamiento(LocalDate fecha) {
		this.validarFecha(fecha);
		this.finalAlmac = fecha;
	}

	private void validarFecha(LocalDate fecha) throws RuntimeErrorException{
		// TODO Auto-generated method stub
		if (this.inicioAlmac.isAfter(fecha)) {
			//RuntimeErrorException;
		}
	}

}
