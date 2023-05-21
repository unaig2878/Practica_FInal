import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Comida extends Producto implements Serializable {
	private boolean perecedero;
	private float calorias;
	private boolean vegano;
	private Date fechaEnvase;

	public Comida(String nombre, double precio, Date fechaCaducidad, boolean perecedero, float calorias,
			Boolean vegano, Date fechaEnvase, int cantidad) {
		super(nombre, precio, fechaCaducidad, cantidad);
		this.perecedero = perecedero;
		this.calorias = calorias;
		this.vegano = vegano;
		this.fechaEnvase = fechaEnvase;
	}

	@Override
	public String toString() {
		return "Cliente: " + nombre + " " + precio + ", calorias: " + calorias + " fecha: " + fechaCaducidad
				+ "cantidad:" + cantidad + "Fecha envase" + fechaEnvase;
	}

	@Override
	public String obtener_caducidad() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaEnvase);

		if (perecedero) {
			calendar.add(Calendar.DAY_OF_MONTH, 10);
		}

		Date fechaCaducidad = calendar.getTime();
		return "Fecha de caducidad: " + fechaCaducidad;
	}

	@Override
	public void detalle_producto() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Precio: " + precio);
		System.out.println("Fecha de caducidad: " + fechaCaducidad);
		System.out.println("Estado: " + estado);
		System.out.println("Perecedero: " + perecedero);
		System.out.println("Calorías: " + calorias);
		System.out.println("Vegano: " + vegano);
		System.out.println("Fecha de envase: " + fechaEnvase);
	}

	public boolean isPerecedero() {
		return perecedero;
	}

	public void setPerecedero(boolean perecedero) {
		this.perecedero = perecedero;
	}

	public float getCalorias() {
		return calorias;
	}

	public void setCalorias(float calorias) {
		this.calorias = calorias;
	}

	public boolean getVegano() {
		return vegano;
	}

	public void setVegano(Boolean vegano) {
		this.vegano = vegano;
	}

	public Date getFechaEnvase() {
		return fechaEnvase;
	}

	public void setFechaEnvase(Date fechaEnvase) {
		this.fechaEnvase = fechaEnvase;
	}

}

