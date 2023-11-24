package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class And extends CompositeQuery {

	public And(IQuery query1, IQuery query2) {
		// TODO Auto-generated constructor stub
		this.query1 = query1;
		this.query2 = query2;
	}

	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
		Set<Viaje> setViaje1 = new HashSet<Viaje>();
		Set<Viaje> setViaje2 = new HashSet<Viaje>();
		setViaje1.addAll(query1.filtrar(viajes));
		setViaje2.addAll(query2.filtrar(viajes));
		Set<Viaje> setViaje3 = new HashSet<Viaje>(setViaje1);
		setViaje3.retainAll(setViaje2);
		return setViaje3.stream().toList();
	}
}
