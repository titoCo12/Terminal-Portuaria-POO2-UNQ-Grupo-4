package unq.edu.po2.cliente;

public class Cliente {
	String nombre;
	
	public Cliente(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
        return nombre;
    }
	
	/* Solo pruebo container por ahora
	 public void recibirNotificacion(LocalDateTime fecha) {
        
    }

    public void recibirFactura(Factura factura) {
        
    }
	 */

}
