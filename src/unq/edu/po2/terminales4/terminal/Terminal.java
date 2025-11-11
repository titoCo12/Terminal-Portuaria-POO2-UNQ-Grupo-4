package unq.edu.po2.terminales4.terminal;


import java.util.*;

import unq.edu.po2.terminales4.buque.*;
import unq.edu.po2.terminales4.circuito.*;
import unq.edu.po2.terminales4.condicionesRutas.*;
import unq.edu.po2.terminales4.orden.*;
import unq.edu.po2.terminales4.posicion.*;
import unq.edu.po2.terminales4.viajes.*;
	
public class Terminal {

	private MotorDeBusqueda motorBusqueda;
	
	public Terminal(MotorDeBusqueda motor) {
		this.motorBusqueda = motor;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Ruta> busquedaRutas(CondicionRuta condicion) {
		return this.motorBusqueda.busquedaRutas(this.getPuerto(), condicion);
	} 
	
	public Optional<Circuito> mejorCircuito(Puerto destino, CriterioCircuito criterio) {
		return motorBusqueda.mejorCircuito(this.getPuerto(), destino, criterio);
	}

}
