package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FechaLlegada {

	private List<Viaje> 	viajes = new ArrayList<Viaje>();
	private LocalDate		fecha;

	public FechaLlegada(LocalDate fecha, List<Viaje> viajes) {
		// TODO Auto-generated constructor stub
		this.fecha = fecha;
		this.viajes = viajes;
	}

	public List<Viaje> filtrar() {
		// TODO Auto-generated method stub
		return viajes.stream().filter(v -> v.getFechaDeSalida().equals(this.fecha)).toList();
	}

}
