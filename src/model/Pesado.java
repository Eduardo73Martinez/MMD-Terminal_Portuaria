package model;

public class Pesado implements ServicioCarga {

	private float		costo = 50;
	private float       pesoRegistrado;
	private Carga		container;

	public Pesado(Carga container) {
		// TODO Auto-generated constructor stub
		this.container = container;
		this.pesoRegistrado = this.pesar(this.container);
	}

	private float pesar(Carga container) {
		// TODO Auto-generated method stub
		return (float) container.getPeso();
	}

	@Override
	public float costoTotal() {
		// TODO Auto-generated method stub
		return this.costo;
	}

}
