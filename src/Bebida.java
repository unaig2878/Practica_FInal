import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Bebida extends Producto implements Serializable {
	private boolean gaseoso;
	private boolean lacteo;

	public boolean isGaseoso() {
		return gaseoso;
	}

	public void setGaseoso(boolean gaseoso) {
		this.gaseoso = gaseoso;
	}

	public boolean isLacteo() {
		return lacteo;
	}

	public void setLacteo(boolean lacteo) {
		this.lacteo = lacteo;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	private String medida;

	public Bebida(String nombre, double precio, Date fechaCaducidad, boolean gaseoso, boolean lacteo, String medida,int cantidad) {
		super(nombre, precio, fechaCaducidad, cantidad);
		this.gaseoso = gaseoso;
		this.lacteo = lacteo;
		this.medida = medida;
	}

	@Override
	public String toString() {
		return "Cliente: " + nombre + " " + precio + ", gas: " + gaseoso + " fecha: " + fechaCaducidad + " cantidad:"
				+ cantidad + " lacteo" + lacteo;
	}

	@Override
	public String obtener_caducidad() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaCaducidad);

		if (lacteo) {
			calendar.add(Calendar.DAY_OF_MONTH, 10);
		} else {
			calendar.add(Calendar.DAY_OF_MONTH, 20);
		}

		Date fechaCaducidadActualizada = calendar.getTime();
		return "Fecha de caducidad: " + fechaCaducidadActualizada;
	}

	@Override
	public void detalle_producto() {
		// Implementación específica para mostrar los atributos de la bebida
		System.out.println("Nombre: " + nombre);
		System.out.println("Precio: " + precio);
		System.out.println("Fecha de caducidad: " + fechaCaducidad);
		System.out.println("Estado: " + estado);
		System.out.println("Gaseoso: " + gaseoso);
		System.out.println("Lácteo: " + lacteo);
		System.out.println("Medida: " + medida);
	}
}
