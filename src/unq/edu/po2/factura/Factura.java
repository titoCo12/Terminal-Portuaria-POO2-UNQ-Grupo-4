package unq.edu.po2.factura;

import java.util.ArrayList;
import java.util.List;




public class Factura {
	List<Item> items;
	
	public Factura() {
		this.items = new ArrayList<Item>();
	}

	public void agregarItem(Item item) {
		this.items.add(item);
	}
	
	public double montoTotal() {
		return this.items.stream().mapToDouble( i -> i.getValor()).sum();
	}
}

