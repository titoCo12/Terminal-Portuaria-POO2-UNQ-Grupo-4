package unq.edu.po2.factura;

import java.util.LinkedHashMap;
import java.util.Map;

import unq.edu.po2.terminales4.orden.Orden;

public class Factura {
	
	Map<String, Double> items = new LinkedHashMap<>();
	

	public void agregarItem(String servicio, double monto) {
		items.put(servicio, monto);
	}
	
	public Map<String, Double> getItems() {
		return items;
	}
	
	public double montoTotal() {
		return items.values().stream().mapToDouble(Double::doubleValue).sum();
	}
	
}

