package unq.edu.po2.cliente;

import java.time.LocalDateTime;

public class Cliente {
	String nombre;
	
	public Cliente(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
        return nombre;
    }
	
	
	public void recibirNotificacion(LocalDateTime fecha) {
        
    }

    public void recibirFactura(Factura factura) {
        
    }

}
