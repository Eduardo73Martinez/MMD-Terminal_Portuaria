package model;

import java.util.List;

public class TerminalDestino extends SimpleQuery {

	private Terminal		terminal;

	public TerminalDestino(Terminal terminal, List<Viaje> viajes) {
		// TODO Auto-generated constructor stub
		this.terminal = terminal;
		this.viajes = viajes;
	}

	@Override
	public List<Viaje> filtrar() {
		// TODO Auto-generated method stub
		return viajes.stream().filter(v -> v.getTerminalDestino().equals(this.terminal)).toList();	}
}
