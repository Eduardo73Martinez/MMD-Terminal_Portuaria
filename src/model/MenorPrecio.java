package model;

import java.util.List;

public class MenorPrecio implements IOrden {

	@Override
	public CircuitoMaritimo elMejor(List<CircuitoMaritimo> circuitos, Terminal terO, Terminal terD) {
		// TODO Auto-generated method stub
		return circuitos.stream()
				.reduce((c1, c2) -> c1.precioTotalEntre(terO, terD) < c2.precioTotalEntre(terO, terD) ? c1 : c2).get();
	}
}
