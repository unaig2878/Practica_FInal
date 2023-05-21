import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Fichero {
	private static final String RUTA_Clientes = "C:\\Users\\unaig\\eclipse-workspace\\Practica_Final\\Ficheros\\Clientes.txt";
	private static final String RUTA_PRODUCTOS = "C:\\Users\\unaig\\eclipse-workspace\\Practica_Final\\Ficheros\\Productos.txt";

	public void guardarClientes(List<Cliente> clientes) {
		try (FileWriter writer = new FileWriter(RUTA_Clientes)) {
			for (Cliente cliente : clientes) {
				writer.write(cliente.toString());
				writer.write(System.lineSeparator());
			}
			System.out.println("Clientes guardados exitosamente en el archivo de texto.");
		} catch (IOException e) {
			System.out.println("Error al guardar los clientes en el archivo de texto: " + e.getMessage());
		}
	}

	public void guardarProductos(List<Comida> comidas, List<Bebida> bebidas) {
		try (FileWriter writer = new FileWriter(RUTA_PRODUCTOS)) {
			for (Comida comida : comidas) {
				writer.write(comida.toString());
				writer.write(System.lineSeparator());
			}
			for (Bebida bebida : bebidas) {
				writer.write(bebida.toString());
				writer.write(System.lineSeparator());
			}
			System.out.println("Productos guardados exitosamente en el archivo de texto.");
		} catch (IOException e) {
			System.out.println("Error al guardar los productos en el archivo de texto: " + e.getMessage());
		}
	}
}


