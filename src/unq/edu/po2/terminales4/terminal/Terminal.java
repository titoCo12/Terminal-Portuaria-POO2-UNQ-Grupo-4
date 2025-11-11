package unq.edu.po2.terminales4.terminal;


import java.util.*;

import unq.edu.po2.empresaTransportista.EmpresaTransportista;
import unq.edu.po2.terminales4.buque.*;
import unq.edu.po2.terminales4.circuito.*;
import unq.edu.po2.terminales4.condicionesRutas.*;
import unq.edu.po2.terminales4.orden.*;
import unq.edu.po2.terminales4.posicion.*;
import unq.edu.po2.terminales4.viajes.*;
	
public class Terminal {

	private MotorDeBusqueda motorBusqueda;
	private Puerto puerto;
	private List<EmpresaTransportista> empresas;
	
	public Terminal(MotorDeBusqueda motor, Puerto puerto, List<EmpresaTransportista> empresas) {
		this.motorBusqueda = motor;
		this.puerto = puerto;
		this.empresas = empresas;
	}
	
	
	public void preavisoBuque(List<Orden> list) {
		// TODO Auto-generated method stub
		
	}

	public Posicion posicion() {
		// TODO Auto-generated method stub
		return null;
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
		orden.manejarLlegada(camion, this);
	}
	
	public boolean validarCamion(Camion camion) {
		
	}
	
	public boolean validarChofer(Chofer chofer) {
		
	}

}
