import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionPedidos implements Imprimible {

	@Override
	public void imprimir() {
		// Lógica para imprimir el ticket final de gestión de pedidos
		System.out.println("=== TICKET FINAL DE GESTIÓN DE PEDIDOS ===");
		// ... Código para imprimir los detalles de los pedidos gestionados
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GestionProducto gestpro = new GestionProducto();
		Pedido pedido = new Pedido();
		Fichero fichero = new Fichero();
		Pasarela pasarela = new Pasarela();
		Cliente cliente1 = new Cliente(null, null, 0, null);
		Cliente cliente2 = new Cliente(null, null, 0, null);
		Cliente cliente3 = new Cliente(null, null, 0, null);
		List<Comida> comidas = new ArrayList<>();
		List<Bebida> bebidas = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();


		Cliente.ingresarClientes(cliente1, cliente2, cliente3, sc);

		for (int i = 0; i < 5; i++) {
			System.out.println(
					"Seleccione el tipo de producto que desea crear (1 = Comida / 2 = Bebida) para el producto "
							+ (i + 1) + ":");
			String tipoProductoStr = sc.nextLine();

			if (tipoProductoStr.equals("1")) {
				gestpro.crearComida(sc, comidas);
			} else if (tipoProductoStr.equals("2")) {
				gestpro.crearBebida(sc, bebidas);
			} else {
				System.out.println("Opción no válida. Por favor, seleccione '1' para comida o '2' para bebida.");
				i--;
			}
		}

		pedido.realizarPedido(0, 0, sc, cliente1, cliente2, cliente3, comidas, bebidas);
		pasarela.elegirpago(pasarela, sc);
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		fichero.guardarClientes(clientes);
		fichero.guardarProductos(comidas, bebidas);
	}


}
