package unq.edu.po2.terminales4.buque;

public abstract class FaseBuque {
	
	protected Buque buque;
	
	public FaseBuque(Buque buque) {
		this.buque = buque;
	}
	
	protected abstract void siguienteFase();
	public abstract void iniciarTrabajo();
	public abstract void depart();
	public  abstract void  evaluarDistanciaADestino(double distancia);

}
