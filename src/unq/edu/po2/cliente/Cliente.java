package unq.edu.po2.cliente;

import java.time.LocalDateTime;

import unq.edu.po2.factura.Factura;

public class Cliente {
	String nombre;
	
	public Cliente(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
        return nombre;
    }
	
	
	public void recibirNotificacion(LocalDateTime fecha) {
        //Pre-aviso de la llegada del buque
    }
	
    public void recibirFactura(Factura factura) {
        // recibir correo en el mail
    }
}
