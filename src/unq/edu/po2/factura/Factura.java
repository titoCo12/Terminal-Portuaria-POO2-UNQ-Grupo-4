package unq.edu.po2.factura;

import java.util.LinkedHashMap;
import java.util.Map;

import unq.edu.po2.terminales4.orden.Orden;

public class Factura {
	private Map<String, Double> items = new LinkedHashMap<>();
	
	public Factura(Orden orden) {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Qué corno hago con las fechas? la fecha de llegada que está en la orden?
	 * Si es así, necesito agregarla a los items y que Factura conozca la orden para eso
	 * Creo que es necesario que el cliente conozca la factura para que la pueda recibir
	 */
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

