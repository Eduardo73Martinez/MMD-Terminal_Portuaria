package model;

import java.time.LocalDate;
import java.util.List;

public class FechaSalida extends SimpleQuery {

	private LocalDate		fecha;

	public FechaSalida(LocalDate fecha) {
		// TODO Auto-generated constructor stub
		this.fecha = fecha;
	}

	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
		// TODO Auto-generated method stub
		return viajes.stream().filter(v -> v.getFechaDeSalida().equals(this.fecha)).toList();
	}
}
