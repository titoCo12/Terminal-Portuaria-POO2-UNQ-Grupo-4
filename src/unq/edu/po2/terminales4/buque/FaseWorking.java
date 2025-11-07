package unq.edu.po2.terminales4.buque;

public class FaseWorking extends FaseBuque {

	public FaseWorking(Buque buque) {
		super(buque);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void siguienteFase() {
		this.buque.setFase(new FaseDeparting(this.buque));

	}

	@Override
	public void iniciarTrabajo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void depart() {
		this.siguienteFase();

	}


	@Override
	public void evaluarDistanciaADestino(int distancia) {
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
