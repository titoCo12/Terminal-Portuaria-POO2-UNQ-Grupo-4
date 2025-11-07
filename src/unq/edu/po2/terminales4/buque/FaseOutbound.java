package unq.edu.po2.terminales4.buque;

public class FaseOutbound extends FaseBuque{

	public FaseOutbound(Buque buque) {
		super(buque);
		
	}

	@Override
	public void siguienteFase() {
		this.buque.setFase(new FaseInbound(this.buque));
		
	}
	
	private boolean entrandoEnSiguienteFase(int distancia) {
		return distancia < 50 && distancia > 0; 
	}

	@Override
	public void evaluarDistanciaADestino(int distancia) {
		if(this.entrandoEnSiguienteFase(distancia)) {
			this.siguienteFase();
		}
		
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
	
	@Override
	public void iniciarTrabajo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depart() {
		// TODO Auto-generated method stub
		
	}
	
}
