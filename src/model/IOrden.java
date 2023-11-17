package model;

import java.util.List;

public interface IOrden {

	CircuitoMaritimo elMejor(List<CircuitoMaritimo> circuitos, Terminal origen, Terminal destino);

}
