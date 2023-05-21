import java.util.List;
import java.util.Scanner;

public class Pedido {

    public Pedido() {
        // TODO Auto-generated constructor stub
    }

    public void realizarPedido(int telefonocliente, int resp2, Scanner sc, Cliente cliente1, Cliente cliente2,
            Cliente cliente3, List<Comida> comidas, List<Bebida> bebidas) {


        System.out.println("indique su numero de telefono");
        telefonocliente = sc.nextInt();
        // Verificar si el cliente tiene cuenta
        if (telefonocliente == cliente1.getTelefono() || telefonocliente == cliente2.getTelefono()
                || telefonocliente == cliente3.getTelefono()) {
            // Imprimir lista de productos y permitir selección
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

            // Se da la opción de elegir otro producto
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

				// Verificar si el número de producto es válido
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
					} else {
						System.out.println("No puede ser el mismo producto que el primero");
					}
                } else {
					System.out.println("Número de producto no válido");
                }
            } else if (decision == 2) {
                // Procesar un solo producto
				if (resp1 >= 1 && resp1 <= comidas.size()) {
					procesarPedido(comidas.get(resp1 - 1).getNombre(), comidas.get(resp1 - 1), sc, 1);
				} else {
					int indexBebida = resp1 - comidas.size() - 1;
					procesarPedido(bebidas.get(indexBebida).getNombre(), bebidas.get(indexBebida), sc, 1);
				}
            } else {
                System.out.println("Valor no válido");
            }
        } else {
            System.out.println("Cliente no registrado");
        }
    }

    private void procesarPedido(String nomproducto, Producto producto, Scanner sc, double descuento) {
        System.out.println("Tu producto: " + nomproducto);
        System.out.println("Indique la cantidad que quieres:");
        int cantidad = sc.nextInt();
        producto.setCantidad(cantidad);
        double precio = producto.getPrecio() * descuento;
        double precioTotal = precio * cantidad;
        System.out.println("El precio a pagar por el producto es: " + precioTotal);
    }
}





