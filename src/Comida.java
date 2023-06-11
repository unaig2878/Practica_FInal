import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Clase que representa un producto de comida.
 */
public class Comida extends Producto implements Serializable {
	private boolean perecedero;
	private float calorias;
	private boolean vegano;
	private Date fechaEnvase;

	/**
	 * Constructor de la clase Comida.
	 * 
	 * @param nombre         El nombre del producto de comida.
	 * @param precio         El precio del producto de comida.
	 * @param fechaCaducidad La fecha de caducidad del producto de comida.
	 * @param perecedero     Indica si el producto de comida es perecedero.
	 * @param calorias       Las calorías del producto de comida.
	 * @param vegano         Indica si el producto de comida es vegano.
	 * @param fechaEnvase    La fecha de envase del producto de comida.
	 * @param cantidad       La cantidad del producto de comida.
	 */
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

