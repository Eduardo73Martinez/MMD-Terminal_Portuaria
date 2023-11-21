package model;

import java.time.LocalDate;

public class Turno {

	private LocalDate arribo;
	private ICliente ICliente;

	Turno(LocalDate arribo, ICliente cliente) {
		// TODO Auto-generated constructor stub
		this.arribo = arribo;
		this.ICliente = cliente;
	}

}
