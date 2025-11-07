package unq.edu.po2.terminales4.buque;

public class FaseDeparting extends FaseBuque {

	public FaseDeparting(Buque buque) {
		super(buque);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void siguienteFase() {
		this.buque.setFase(new FaseOutbound(this.buque));
	}

	@Override
	public void evaluarDistanciaADestino(int distancia) {
		if(distancia > 1) {
			this.buque.avisarSalidaATerminal();
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
