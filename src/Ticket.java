/**
 * Clase que representa un ticket de compra.
 */
public class Ticket {
    private String nombreCliente;
    private int telefonoCliente;
    private int cantidadProductos;
    private double precioTotal;
   
	/**
	 * Constructor de la clase Ticket.
	 *
	 * @param nombreCliente     Nombre del cliente.
	 * @param telefonoCliente   Teléfono del cliente.
	 * @param cantidadProductos Cantidad de productos en el ticket.
	 * @param precioTotal       Precio total del ticket.
	 */
	public Ticket(String nombreCliente, int telefonoCliente, int cantidadProductos, double precioTotal) {
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.cantidadProductos = cantidadProductos;
        this.precioTotal = precioTotal;
       
    }

	public String getNombreCliente() {
		return nombreCliente;
	}

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    

    
}
