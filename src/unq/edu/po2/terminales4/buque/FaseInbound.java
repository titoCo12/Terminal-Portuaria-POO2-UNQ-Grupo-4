package unq.edu.po2.terminales4.buque;

public class FaseInbound extends FaseBuque {

	public FaseInbound(Buque buque) {
		super(buque);
		buque.avisarArriboATerminal();
	}

	@Override
	public void siguienteFase() {
		this.buque.setFase(new FaseArrived(this.buque));

	}

	private boolean estaEnTerminal(double distanciaADestino) {
		
		return distanciaADestino == 0;
	}

	@Override
	public void evaluarDistanciaADestino(double distancia) {
		if(this.estaEnTerminal(distancia)) {
			this.siguienteFase();
		}		
	}
	
	@Override
	public void depart() {
		

	}
	
	

	@Override
	public void iniciarTrabajo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void informarExportaciones() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarPagos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarImportaciones() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarExportaciones() {
		// TODO Auto-generated method stub
		
	}

}
