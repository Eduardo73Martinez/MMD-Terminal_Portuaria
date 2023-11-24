package model;

import java.util.List;

public class TerminalOrigen extends SimpleQuery {

	private Terminal		terminal;

	public TerminalOrigen(Terminal terminal) {
		// TODO Auto-generated constructor stub
		this.terminal = terminal;
	}

	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
		// TODO Auto-generated method stub
		return viajes.stream().filter(v -> v.getTerminalOrigen().equals(this.terminal)).toList();
	}
}
