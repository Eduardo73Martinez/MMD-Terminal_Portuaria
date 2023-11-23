package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TerminalPortuaria implements Terminal {

	private boolean 				buqueCerca 			= false;
	private Posicion 				posicion;
	private List<Camion> 			camionesRegistrados = new ArrayList<Camion>();
	private List<Chofer> 			choferesRegistrados	= new ArrayList<Chofer>();
	private List<EmpresaTransporte> empresasRegistradas	= new ArrayList<EmpresaTransporte>();
	private List<Consignee> 		consignees			= new ArrayList<Consignee>();
	private List<Shipper> 			shippers			= new ArrayList<Shipper>();
	private IOrden 					prioridad;
	private List<CircuitoMaritimo> 	circuitos			= new ArrayList<CircuitoMaritimo>();
	private List<Naviera> 			navieras			= new ArrayList<Naviera>();
	
	
	/*
	 * Chuequear todos los atributos por comportamiento definidos en UML
	 * Hacer métdodos de listas gestionadas en la terminal. Métodos CreateReadUpdateDelete
	 */

	Boolean hayBuqueCerca() { //es package para testear
		return this.getBuqueCerca();
	}
	
	@Override
	public Posicion getPosicion() { //pública porque necesita conocerla, x ej., el buque
		return this.posicion;
	}

	@Override
	public void recibirPreaviso(Buque buque) { //es package para testear
		this.buqueCerca = true; //Revisar si falta comportamiento
	} 
	
	@Override
	public void recibirEmail(Email email) {
		this.shippers.stream().forEach(s->s.recibirEmail(email));
	}

	public Boolean getBuqueCerca() { //es package para testear
		// TODO Auto-generated method stub
		return buqueCerca;
	}
	
	public List<Camion> getCamionesRegistrados() { //sigue el orden CRUD (create está en atributos) //es package para testear
		return this.camionesRegistrados;
	}
	
	public void registrarCamion(Camion camion) { //es package para testear
		this.camionesRegistrados.add(camion);
	}
	
	public void quitarCamion(Camion camion) { // es package para testear
		this.camionesRegistrados.remove(camion);
	}
	
	public List<Chofer> getChoferesRegistrados() { //sigue el orden CRUD (create está en atributos) // es package para testear
		return this.choferesRegistrados;
	}
	
	public void registrarChofer(Chofer chofer) { // es package para testear
		this.choferesRegistrados.add(chofer);
	}
	
	public void quitarChofer(Chofer chofer) { // es package para testear
		this.choferesRegistrados.remove(chofer);
	}	
	
	public List<EmpresaTransporte> getEmpresasRegistradas() { //sigue el orden CRUD (create está en atributos) // es package para testear
		return this.empresasRegistradas;
	}
	
	public void registrarEmpresa(EmpresaTransporte empresa) { //es package para testear
		this.empresasRegistradas.add(empresa);
	}
	
	public void quitarEmpresa(EmpresaTransporte empresa) { //es package para testear
		this.empresasRegistradas.remove(empresa);
	}
	
	public List<Consignee> getConsignee() { //sigue el orden CRUD (create está en atributos) // es package para testear
		return this.consignees;
	}
	
	public void registrarConsignee(Consignee consignee) { // es package para testear
		this.consignees.add(consignee);
	}
	
	public void quitarConsignee(Consignee consignee) { // es package para testear
		this.consignees.remove(consignee);
	}
	
	public List<Shipper> getShippers() { //sigue el orden CRUD (create está en atributos) // es package para testear
		return this.shippers;
	}
	
	public void registrarShipper(Shipper shipper) { // es package para testear
		this.shippers.add(shipper);
	}
	
	public void quitarShipper(Shipper shipper) { // es package para testear
		this.shippers.remove(shipper);
	}
	
	public List<CircuitoMaritimo> getCircuitos() { //sigue el orden CRUD (create está en atributos) // es package para testear
		return this.circuitos;
	}
	
	public void registrarCircuito(CircuitoMaritimo circuito) { // es package para testear
		this.circuitos.add(circuito);
	}
	
	public void quitarCircuito(CircuitoMaritimo circuito) { // es package para testear
		this.circuitos.remove(circuito);
	}
	
	public List<Naviera> getNavieras() { //sigue el orden CRUD (create está en atributos) // es package para testear
		return this.navieras;
	}
	
	public void registrarNaviera(Naviera naviera) { // es package para testear
		this.navieras.add(naviera);
	}
	
	public void quitarNaviera(Naviera naviera) { // es package para testear
		this.navieras.remove(naviera);
	}
	

	public void envio(Shipper shipper, Carga carga, Viaje viaje, Camion camion, Chofer chofer) { //es package para testear
		// TODO Auto-generated method stub
		
	}

	public void recepcion(Consignee consignee, Carga carga, Viaje viaje, Camion camion, Chofer chofer) { //es package para testear
		// TODO Auto-generated method stub
		
	}

	public void asignarTurno(ICliente cliente) { //es package para testear
		// TODO Auto-generated method stub
		
	}

	public List<Viaje> filtrar() { // es package para testear
		// TODO Auto-generated method stub
		return null;
		
	}

	public CircuitoMaritimo elMejorCircuito(Terminal terminal) { //también se podría pasar la prioridad como parámetro
		// TODO Auto-generated method stub
		return prioridad.elMejor(this.circuitos, this, terminal);
	}

	public void setPrioridad(IOrden prioridad) {
		// TODO Auto-generated method stub
		this.prioridad = prioridad;
	}
	
	public IOrden getPrioridad() {
		return this.prioridad;
	}
	
	public void validarTransporteCarga(OrdenBasicaTP orden) { //manejar esta lógica con bool?
		// TODO Auto-generated method stub
//		Camion camion = orden.getCamion(); //falta modificar Orden
//		Chofer chofer = orden.getChofer(); //falta modificar Orden
//		this.validarTurno(camion);
//		this.validarCamionYChofer(camion, chofer); 
	}

	public void validarTurno(Camion camion) {
		// TODO Auto-generated method stub
		// si el turno queda en la orden, depende del modelado de la misma		
	}

	public void validarCamionYChofer(Camion camion, Chofer chofer) {
		// TODO Auto-generated method stub
		if (this.camionesRegistrados.contains(camion)) {
			// no sé qué se debería hacer si pasa la validación
		} else {
			// tampoco sé qué hacer si no pasa
		}
	}

	public float tiempoHasta(Terminal terminal) {
		// TODO Auto-generated method stub
//		if (this.hayCircuitoCon(terminal)) { //polimorfismo?
//			this.setPrioridad(MenorTiempo); //como setear la prioridad a tiempo?
//			return this.elMejorCircuito(terminal).tiempoTotalDelCircuito(); // problema de double y float
//		}
		return 0;
	}

	public boolean hayCircuitoCon(Terminal terminal) {
		// TODO Auto-generated method stub
//		return (no sé cómo armar la expresión de consultarle a los tramos de un circuito por las terminales,
//				sería un recorrido por la lista de tramos de cada circuito). 
		return false;
	}

	public LocalDate proximaPartidaHasta(Terminal terminal) {
		// TODO Auto-generated method stub
//		if (this.hayPartidasA(terminal)) { //polimorfismo?
//			return //ver manejo de colecciones de viajes/circuitos
//		}
		return null;
	}

	public boolean hayPartidasA(Terminal terminal) {
		// TODO Auto-generated method stub
		// ver manejo de colecciones de viajes/circuitos
		return false;
	}

	public void contratar(ServicioContratable servicio, OrdenBasicaTP orden) {
		// TODO Auto-generated method stub
		// no tengo claro cuál sería el comportamiento de contratar un servicio
		
	}

	public List<Viaje> cronogramaSalidaViajes() {
		// TODO Auto-generated method stub
		//return Naviera.getViajes(); //la naviera le deberia pasar los viajes
		return null;
	}

}
