package unq.edu.po2.terminales4.terminal;


import java.time.LocalDate;
import java.util.*;

import unq.edu.po2.chofer.*;
import unq.edu.po2.cliente.*;
import unq.edu.po2.container.*;
import unq.edu.po2.empresaTransportista.EmpresaTransportista;
import unq.edu.po2.servicio.*;
import unq.edu.po2.terminales4.buque.*;
import unq.edu.po2.terminales4.camion.Camion;
import unq.edu.po2.terminales4.circuito.*;
import unq.edu.po2.terminales4.condicionesRutas.*;
import unq.edu.po2.terminales4.orden.*;
import unq.edu.po2.terminales4.posicion.*;
import unq.edu.po2.terminales4.reporte.*;
import unq.edu.po2.terminales4.viajes.*;
	
public class Terminal {

	private MotorDeBusqueda motorBusqueda;
	private Puerto puerto;
	private List<EmpresaTransportista> empresas = new ArrayList<>();
	private List<Container> containersAlmacenados = new ArrayList<>();
	
	public Terminal(MotorDeBusqueda motor, Puerto puerto, List<EmpresaTransportista> empresas) {
		this.motorBusqueda = motor;
		this.puerto = puerto;
		this.empresas = empresas;   
	}
	
	//la asignacion de turno no debe ser considerada en el trabajo
	public OrdenExportacion registrarExportacion(String patenteCamion, String dniChofer, Cliente cliente, 
			Container contenedor, Puerto destino, Viaje viaje) throws Exception {
		if (!viaje.pasaPor(destino) || !viaje.pasaPor(this.puerto)) {
			throw new Exception("Viaje no pasa por los puertos origen y destino");
		}
		if (viaje.fechaLlegadaA(this.puerto).get().isAfter(viaje.fechaLlegadaA(destino).get())) {
			throw new Exception("Viaje pasa por puerto destino antes de pasar por puerto origen (esta terminal)");
		}
		OrdenExportacion orden = new OrdenExportacion(dniChofer, patenteCamion, LocalDate.now().plusDays(1), 
				viaje.fechaLlegadaA(destino).get(), this.puerto, destino, contenedor, cliente,
				viaje.fechaLlegadaA(this.puerto).get(), viaje);
		contenedor.agregarServicio(new Lavado(1000.0, 1800.0));
		contenedor.agregarServicio(new Pesado(800.0));
		return orden;
	}
	
	
	public void preavisoBuque(List<Orden> list) {
		list.stream().forEach(o -> o.getCliente().recibirNotificacion(o.getFechaLlegada()));
	}

	public Posicion posicion() {
		return puerto.getPosicion();
	}
	
	public void buqueSaliendo(Buque buqueSaliendo) {
		buqueSaliendo.enviarFacturas();
	}

	public Puerto getPuerto() {
		return this.puerto;
	}
	
	public List<Ruta> busquedaRutas(CondicionRuta condicion) {
		return this.motorBusqueda.busquedaRutas(this.getPuerto(), condicion);
	} 
	
	public Optional<Circuito> mejorCircuito(Puerto destino, CriterioCircuito criterio) {
		return motorBusqueda.mejorCircuito(this.getPuerto(), destino, criterio); 
	}
	
	
	public void llegadaDeCamion(Orden orden, Camion camion) {
		if (this.validarCamion(camion) && this.validarChofer(camion.getChofer())) {
			orden.manejarLlegada(this, camion);
		}
	}
	
	
	public boolean validarCamion(Camion camion) {
		return empresas.stream().anyMatch(e -> e.esCamionHabilitado(camion));
	}
	
	public boolean validarChofer(Chofer chofer) {
		return empresas.stream().anyMatch(e -> e.esChoferHabilitado(chofer));
	}
	
	public void almacenarContainer(Container container) {
		this.containersAlmacenados.add(container);
	}
	
	public void removerContainer(Container container) {
		this.containersAlmacenados.remove(container);
	}
	
	public List<Container> getContainersAlmacenados() {
		return this.containersAlmacenados;
	}
	
	public String generarReporte(Buque buque, Reporte reporte) {
		buque.acceptReporte(reporte, this);
		return reporte.devolverReporte();
	}
	
	public int diasDeNavieraHasta(Naviera naviera, Puerto destino) {
		return naviera.mejorTiempoHasta(this.getPuerto(), destino);
	}
	
	public Optional<LocalDate> salidaDeBuqueHasta(Buque buque, Puerto destino){
		return this.motorBusqueda.salidaDeBuqueHasta(buque, this.getPuerto(), destino);
	}
	
	

}
