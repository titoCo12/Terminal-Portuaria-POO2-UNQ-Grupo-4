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
	public void finalizarTrabajo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void distancia(int distancia) {
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
