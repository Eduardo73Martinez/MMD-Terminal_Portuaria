package model;

import java.util.List;

public class MenorTiempo implements IOrden {

	@Override
	public CircuitoMaritimo elMejor(List<CircuitoMaritimo> circuitos, Terminal terO, Terminal terD) {
		// TODO Auto-generated method stub
		return circuitos.stream()
				.reduce((c1, c2) -> c1.tiempoTotalEntre(terO, terD) < c2.tiempoTotalEntre(terO, terD) ? c1 : c2).get();
	}
}
