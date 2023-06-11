import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Clase abstracta que representa un producto.
 */
public abstract class Producto implements Serializable {
	protected String nombre;
	protected double precio;
	protected Date fechaCaducidad;
	protected String estado;
	protected int cantidad;

	/**
	 * Constructor de la clase Producto.
	 *
	 * @param nombre         El nombre del producto.
	 * @param precio         El precio del producto.
	 * @param fechaCaducidad La fecha de caducidad del producto.
	 * @param cantidad       La cantidad disponible del producto.
	 */
	public Producto(String nombre, double precio, Date fechaCaducidad, int cantidad) {
		this.nombre = nombre;
		this.precio = precio;
		this.fechaCaducidad = fechaCaducidad;
		this.estado = "";
		this.cantidad = cantidad;
	}

	/**
	 * Método estático que gestiona el stock de los productos.
	 *
	 * @param sc            El objeto Scanner utilizado para la entrada del usuario.
	 * @param cantproducto1 La cantidad deseada del primer producto.
	 * @param cantproducto2 La cantidad deseada del segundo producto.
	 * @param resp1         La respuesta del usuario para volver más tarde.
	 * @return Una lista con el stock restante de cada producto.
	 */
	public static List<Integer> Stockage(Scanner sc, int cantproducto1, int cantproducto2, int resp1) {
		while (cantproducto1 == 0 && cantproducto2 == 0) {
			System.out.print("Quiere producto1 1.si 2.no");
			cantproducto1 = sc.nextInt();
			System.out.print("Quiere producto2 1.si 2.no ");
			cantproducto2 = sc.nextInt();
		}

		// Creamos un ArrayList para el stock de cada producto
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();

		// Llenamos el stock con 30 productos para cada producto
		for (int i = 0; i < 30; i++) {
			list.add(i);
			list2.add(i);
		}

		System.out.println("### Menu Stockage ###");
		System.out.println("Nos quedan 30 productos en stock de cada producto");

		while (cantproducto1 > 0) {
			System.out.print("Cuántos valores desea quitar del primer producto? ");
			if (cantproducto1 <= list.size()) {
				list.subList(list.size() - cantproducto1, list.size()).clear();
				System.out.println("Ha pedido: " + cantproducto1 + " unidades");
				System.out.println("En stock nos quedan disponibles " + list.size() + " del primer producto");
				break;
			} else {
				System.out.println("No tenemos " + cantproducto1 + " del primer producto en stock");
				System.out.println("Desea volver más tarde? 1. Sí 2. No");
				resp1 = sc.nextInt();
				if (resp1 == 1) {
					while (list.size() < 30) {
						list.add(0);
					}
					System.out.println("Ya tiene stock, comience de nuevo");
				} else {
					System.out.println("Muchas gracias por su visita");
					return null;
				}
			}
		}

		while (cantproducto2 > 0) {
			System.out.print("Cuántos valores desea quitar del segundo producto? ");
			if (cantproducto2 <= list2.size()) {
				list2.subList(list2.size() - cantproducto2, list2.size()).clear();
				System.out.println("Ha pedido: " + cantproducto2 + " unidades");
				System.out.println("En stock nos quedan disponibles " + list2.size() + " del segundo producto");
				break;
			} else {
				System.out.println("No tenemos " + cantproducto2 + " del segundo producto en stock");
				System.out.println("Desea volver más tarde? 1. Sí 2. No");
				int resp2 = sc.nextInt();
				if (resp2 == 1) {
					while (list2.size() < 30) {
						list2.add(0);
					}
					System.out.println("Ya tiene stock, comience de nuevo");
				} else {
					System.out.println("Muchas gracias por su visita");
					return null;
				}
			}
		}

		// Devuelve el stock restante para ambos productos
		List<Integer> stocks = new ArrayList<>();
		stocks.add(list.size());
		stocks.add(list2.size());
		return stocks;
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
