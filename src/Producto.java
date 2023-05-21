import java.io.Serializable;
import java.util.Date;

public abstract class Producto implements Serializable {
	protected String nombre;
	protected double precio;
	protected Date fechaCaducidad;
	protected String estado;
	protected int cantidad;

	public Producto(String nombre, double precio, Date fechaCaducidad, int cantidad) {
		this.nombre = nombre;
		this.precio = precio;
		this.fechaCaducidad = fechaCaducidad;
		this.estado = "";
		this.cantidad = cantidad;
	}



	public abstract String obtener_caducidad();

	public abstract void detalle_producto();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
