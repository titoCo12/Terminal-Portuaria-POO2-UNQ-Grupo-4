package unq.edu.po2.terminales4.buque;

public class FaseArrived extends FaseBuque {

	public FaseArrived(Buque buque) {
		super(buque);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void siguienteFase() {
		this.buque.setFase(new FaseWorking(this.buque));

	}

	@Override
	public void iniciarTrabajo() {
		this.siguienteFase();

	}

	@Override
	public void depart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void evaluarDistanciaADestino(double distancia) {
		// TODO Auto-generated method stub
	}
	
}
