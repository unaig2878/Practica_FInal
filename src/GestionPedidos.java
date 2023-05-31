import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionPedidos implements Imprimible {

	@Override
	public void imprimir() {
		System.out.println("=== TICKET FINAL DE GESTIÓN DE PEDIDOS ===");

	}
	public static void main(String[] args) {
		int resp1 = 0;
		Scanner sc = new Scanner(System.in);
		GestionProducto gestpro = new GestionProducto();
		Pedido pedido = new Pedido();
		Fichero fichero = new Fichero();
		Pasarela pasarela = new Pasarela();
		Conexion conexion = new Conexion();

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
		System.out.println("Indique la cantidad del producto 1");
		int cantproducto1 = sc.nextInt();
		System.out.println("Indique cantidad de producto 2(si no ha pedido uno indique 0)");
		int cantproducto2 = sc.nextInt();

		Producto.Stockage(sc, cantproducto1, cantproducto2, resp1);
		pasarela.elegirpago(pasarela, sc);
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		fichero.guardarClientes(clientes);
		fichero.guardarProductos(comidas, bebidas);
		conexion.ingresarProductos(comidas, bebidas);
		conexion.ingresarClientesBD(cliente1, cliente2, cliente3);


	}


}
