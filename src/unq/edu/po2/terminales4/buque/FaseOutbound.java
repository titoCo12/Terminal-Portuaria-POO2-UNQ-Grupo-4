package unq.edu.po2.terminales4.buque;

public class FaseOutbound extends FaseBuque{

	public FaseOutbound(Buque buque) {
		super(buque);
		
	}

	@Override
	public void siguienteFase() {
		this.buque.setFase(new FaseInbound(this.buque));
		
	}
	
	private boolean entrandoEnSiguienteFase(double distancia) {
		return distancia < 50 && distancia > 0; 
	}

	@Override
	public void evaluarDistanciaADestino(double distancia) {
		if(this.entrandoEnSiguienteFase(distancia)) {
			this.siguienteFase();
		}
		
	}
	
	@Override
	public void iniciarTrabajo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depart() {
		// TODO Auto-generated method stub
		
	}
	
}
