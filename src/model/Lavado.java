package model;

public class Lavado implements ServicioContratable {

	private float		volumenFijo = 70;
	private float		costoFijoSup = 50;
	private float       porcentajeRelativo = 80;
	private Carga		container;

	public Lavado(Carga container) {
		// TODO Auto-generated constructor stub
		this.container = container;
	}

	@Override
	public float costoTotal() {
		// TODO Auto-generated method stub
		if (this.getVolumenContainer(this.container) > this.volumenFijo) {
			return this.costoFijoSup;
		} else {
			return this.costoFijoSup*this.porcentajeRelativo;
		}
	}

	private float getVolumenContainer(Carga container) {
		// TODO Auto-generated method stub
		return (float) (container.getAlto()*this.container.getAncho()*this.container.getLargo());
	}

}
