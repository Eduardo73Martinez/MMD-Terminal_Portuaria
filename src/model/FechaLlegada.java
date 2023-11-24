package model;

import java.time.LocalDate;
import java.util.List;

public class FechaLlegada extends SimpleQuery {

	private LocalDate		fecha;

	public FechaLlegada(LocalDate fecha) {
		// TODO Auto-generated constructor stub
		this.fecha = fecha;
	}

	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
		// TODO Auto-generated method stub
		return viajes.stream().filter(v -> v.getFechaDeLlegada().equals(this.fecha)).toList();
	}
}
