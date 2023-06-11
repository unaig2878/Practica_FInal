import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa un pedido realizado por un cliente.
 */
public class Pedido {

	/**
	 * Realiza un pedido para un cliente.
	 *
	 * @param telefonoCliente El número de teléfono del cliente.
	 * @param resp2           La opción seleccionada por el cliente.
	 * @param sc              El objeto Scanner utilizado para la entrada del
	 *                        usuario.
	 * @param cliente1        El primer cliente registrado.
	 * @param cliente2        El segundo cliente registrado.
	 * @param cliente3        El tercer cliente registrado.
	 * @param comidas         La lista de comidas disponibles.
	 * @param bebidas         La lista de bebidas disponibles.
	 */

	public void realizarPedido(int telefonoCliente, int resp2, Scanner sc, Cliente cliente1, Cliente cliente2,
            Cliente cliente3, List<Comida> comidas, List<Bebida> bebidas) {
		Conexion conexion = new Conexion();
        System.out.println("Indique su número de teléfono:");
        telefonoCliente = sc.nextInt();

        // Verificar si el cliente tiene cuenta
        Cliente cliente = null;
        if (telefonoCliente == cliente1.getTelefono()) {
            cliente = cliente1;
        } else if (telefonoCliente == cliente2.getTelefono()) {
            cliente = cliente2;
        } else if (telefonoCliente == cliente3.getTelefono()) {
            cliente = cliente3;
        }

        if (cliente != null) {
            int resp1 = 0, decision = 0;
            System.out.println("Estás registrado");
            System.out.println("Seleccione el producto que desea (ingrese el número):");

            System.out.println("Comidas:");
            int index = 1;
            for (Comida comida : comidas) {
                System.out.println(index + ". " + comida.getNombre());
                index++;
            }

            System.out.println("Bebidas:");
            for (Bebida bebida : bebidas) {
                System.out.println(index + ". " + bebida.getNombre());
                index++;
            }

            resp1 = sc.nextInt();

            System.out.println("¿Quiere otro? (recuerde que solo le queda 1)");
            System.out.println("1. Sí ... 2. No");
            decision = sc.nextInt();

            if (decision == 1) {
                System.out.println("Comidas:");
                index = 1;
                for (Comida comida : comidas) {
                    System.out.println(index + ". " + comida.getNombre());
                    index++;
                }

                System.out.println("Bebidas:");
                for (Bebida bebida : bebidas) {
                    System.out.println(index + ". " + bebida.getNombre());
                    index++;
                }

                System.out.println("Escriba el número del producto que desea:");
                resp2 = sc.nextInt();

                if (resp2 >= 1 && resp2 <= comidas.size() + bebidas.size()) {
                    if (resp1 != resp2) {
                        // Procesar el primer producto
                        procesarPedido(comidas.get(resp1 - 1).getNombre(), comidas.get(resp1 - 1), sc, 1);

                        // Procesar el segundo producto
                        if (resp2 <= comidas.size()) {
                            procesarPedido(comidas.get(resp2 - 1).getNombre(), comidas.get(resp2 - 1), sc, 1);
                        } else {
                            int indexBebida = resp2 - comidas.size() - 1;
                            procesarPedido(bebidas.get(indexBebida).getNombre(), bebidas.get(indexBebida), sc, 1);
                        }

                        // Crear el ticket y guardarlo en la base de datos
                        Ticket ticket = crearTicket(cliente, comidas.get(resp1 - 1), comidas.get(resp2 - 1));
						conexion.guardarTicket(ticket);
                    } else {
                        System.out.println("No puede ser el mismo producto que el primero");
                    }
                } else {
                    System.out.println("Número de producto no válido");
                }
            } else if (decision == 2) {
                if (resp1 >= 1 && resp1 <= comidas.size()) {
                    procesarPedido(comidas.get(resp1 - 1).getNombre(), comidas.get(resp1 - 1), sc, 1);

                    // Crear el ticket y guardarlo en la base de datos
                    Ticket ticket = crearTicket(cliente, comidas.get(resp1 - 1), null);
					conexion.guardarTicket(ticket);
                } else {
                    int indexBebida = resp1 - comidas.size() - 1;
                    procesarPedido(bebidas.get(indexBebida).getNombre(), bebidas.get(indexBebida), sc, 1);

                    // Crear el ticket y guardarlo en la base de datos
                    Ticket ticket = crearTicket(cliente, null, bebidas.get(indexBebida));
					conexion.guardarTicket(ticket);
                }
            } else {
                System.out.println("Valor no válido");
            }
        } else {
            System.out.println("Cliente no registrado");
        }
    }

	/**
	 * Procesa un pedido de un producto.
	 *
	 * @param nomProducto El nombre del producto.
	 * @param producto    El objeto Producto.
	 * @param sc          El objeto Scanner utilizado para la entrada del usuario.
	 * @param descuento   El descuento aplicado al precio del producto.
	 */
    private void procesarPedido(String nomProducto, Producto producto, Scanner sc, double descuento) {
        System.out.println("Tu producto: " + nomProducto);
        System.out.println("Indique la cantidad que quieres:");
        int cantidad = sc.nextInt();
        producto.setCantidad(cantidad);
        double precio = producto.getPrecio() * descuento;
        double precioTotal = precio * cantidad;
        System.out.println("El precio a pagar por el producto es: " + precioTotal);
    }

	/**
	 * Crea un ticket a partir de los productos seleccionados por el cliente.
	 *
	 * @param cliente   El objeto Cliente.
	 * @param producto1 El primer producto seleccionado.
	 * @param producto2 El segundo producto seleccionado.
	 * @return El objeto Ticket.
	 */
    private Ticket crearTicket(Cliente cliente, Producto producto1, Producto producto2) {
        double precioTotal = 0.0;
        int cantidadTotal = 0;

        List<String> productos = new ArrayList<>();

        if (producto1 != null) {
            int cantidad1 = producto1.getCantidad();
            double precio1 = producto1.getPrecio() * cantidad1;
            String producto1Info = producto1.getNombre() + " x" + cantidad1 + ": $" + precio1;
            productos.add(producto1Info);
            precioTotal += precio1;
            cantidadTotal += cantidad1;
        }

        if (producto2 != null) {
            int cantidad2 = producto2.getCantidad();
            double precio2 = producto2.getPrecio() * cantidad2;
            String producto2Info = producto2.getNombre() + " x" + cantidad2 + ": $" + precio2;
            productos.add(producto2Info);
            precioTotal += precio2;
            cantidadTotal += cantidad2;
        }

        return new Ticket(cliente.getNombre(), cliente.getTelefono(), cantidadTotal, precioTotal);
    }
}


