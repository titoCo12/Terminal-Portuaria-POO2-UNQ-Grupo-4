package unq.edu.po2.cliente;

import java.time.LocalDate;

import unq.edu.po2.factura.Factura;

public class Cliente {
	String nombre;
	
	public Cliente(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
        return nombre;
    }
	
	public void recibirNotificacion(LocalDate fecha) {
        //Pre-aviso de la llegada del buque, no hace nada.
    }
	
    public void recibirFactura(Factura factura) {
        // recibir correo en el mail, no hace nada.
    }
}
