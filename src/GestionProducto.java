import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GestionProducto {

	public GestionProducto() {
	}

	public Comida crearComida(Scanner sc, List<Comida> comidas) {
		Comida comida = new Comida(null, 0, null, false, 0, false, null, 0);

		System.out.println("Ingrese el nombre de la comida:");
		String nombre = sc.nextLine();
		comida.setNombre(nombre);

		System.out.println("Ingrese el precio de la comida:");
		double precio = sc.nextDouble();
		comida.setPrecio(precio);

		sc.nextLine(); // Limpiar el buffer de entrada

		System.out.println("Ingrese la fecha de caducidad de la comida (formato dd/MM/yyyy):");
		String fechaCaducidadStr = sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date fechaCaducidad = sdf.parse(fechaCaducidadStr);
			comida.setFechaCaducidad(fechaCaducidad);
		} catch (ParseException e) {
			System.out.println("Error al parsear la fecha de caducidad. Se establecerá la fecha actual.");
			comida.setFechaCaducidad(new Date());
		}

		System.out.println("Ingrese el estado de la comida:");
		String estado = sc.nextLine();
		comida.setEstado(estado);

		System.out.println("Ingrese la cantidad de la comida:");
		int cantidad = sc.nextInt();
		comida.setCantidad(cantidad);

		sc.nextLine(); // Limpiar el buffer de entrada

		System.out.println("Ingrese si la comida es perecedera (1 = Sí / 2 = No):");
		String perecederoStr = sc.nextLine();
		boolean perecedero;
		if (perecederoStr.equals("1")) {
			perecedero = true;
		} else if (perecederoStr.equals("2")) {
			perecedero = false;
		} else {
			System.out.println("Opción no válida. Se asumirá que no es perecedera.");
			perecedero = false; // Valor predeterminado en caso de opción inválida
		}
		comida.setPerecedero(perecedero);

		System.out.println("Ingrese el número de calorías de la comida:");
		float calorias = sc.nextFloat();
		comida.setCalorias(calorias);

		System.out.println("Ingrese si la comida es vegana (1 = Sí / 2 = No):");
		String veganoStr = sc.nextLine();
		boolean vegano;
		if (veganoStr.equals("1")) {
			vegano = true;
		} else if (veganoStr.equals("2")) {
			vegano = false;
		} else {
			System.out.println("Opción no válida. Se asumirá que no es vegana.");
			vegano = false; // Valor predeterminado en caso de opción inválida
		}
		comida.setVegano(vegano);

		sc.nextLine(); // Limpiar el buffer de entrada

		System.out.println("Ingrese la fecha de envasado de la comida (formato dd/MM/yyyy):");
		String fechaEnvaseStr = sc.nextLine();
		try {
			Date fechaEnvase = sdf.parse(fechaEnvaseStr);
			comida.setFechaEnvase(fechaEnvase);
		} catch (ParseException e) {
			System.out.println("Error al parsear la fecha de envasado. Se establecerá la fecha actual.");
			comida.setFechaEnvase(new Date());
		}

		comidas.add(comida);

		// Obtener la fecha de caducidad
		String fechaCaducidad = comida.obtener_caducidad();
		System.out.println(fechaCaducidad);

		return comida;
	}


	public Bebida crearBebida(Scanner sc, List<Bebida> bebidas) {
		Bebida bebida = new Bebida(null, 0, null, false, false, null, 0);

		System.out.println("Ingrese el nombre de la bebida:");
		String nombre = sc.nextLine();
		bebida.setNombre(nombre);

		System.out.println("Ingrese el precio de la bebida:");
		double precio = sc.nextDouble();
		bebida.setPrecio(precio);

		sc.nextLine(); // Limpiar el buffer de entrada

		System.out.println("Ingrese la fecha de caducidad de la bebida (formato dd/mm/aaaa):");
		String fechaCaducidadStr = sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date fechaCaducidad = sdf.parse(fechaCaducidadStr);
			bebida.setFechaCaducidad(fechaCaducidad);
		} catch (ParseException e) {
			System.out.println("Error al parsear la fecha de caducidad. Se establecerá la fecha actual.");
			bebida.setFechaCaducidad(new Date());
		}

		System.out.println("Ingrese el estado de la bebida:");
		String estado = sc.nextLine();
		bebida.setEstado(estado);

		System.out.println("Ingrese la cantidad de la bebida:");
		int cantidad = sc.nextInt();
		bebida.setCantidad(cantidad);

		// Solicitar y establecer los demás atributos específicos de Bebida
		// ...
		bebidas.add(bebida);
		return bebida;
	}

	// Otros métodos para gestionar productos...
}
