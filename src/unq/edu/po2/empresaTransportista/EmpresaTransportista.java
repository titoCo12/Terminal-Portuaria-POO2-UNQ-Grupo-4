package unq.edu.po2.empresaTransportista;

import java.util.ArrayList;
import java.util.List;

import unq.edu.po2.chofer.Chofer;
import unq.edu.po2.terminales4.camion.Camion;

public class EmpresaTransportista {
	
	String nombre;
	List<String> choferesHabilitados;
	List<String> camionesHabilitados;
	
	public EmpresaTransportista (String nombre) {
		this.nombre = nombre;
		this.camionesHabilitados = new ArrayList<>();
		this.choferesHabilitados = new ArrayList<>();
	}
	
	public boolean esChoferHabilitado(Chofer chofer) {
		return choferesHabilitados.contains(chofer.getDni());
	}
	
	public boolean esCamionHabilitado(Camion camion) {
		return camionesHabilitados.contains(camion.getPatente());
	}
	
	public void agregarCamion(Camion camion) {
		camionesHabilitados.add(camion.getPatente());
	}
	
	public void agregarChofer(Chofer chofer) {
		choferesHabilitados.add(chofer.getDni());
	}
	
}
