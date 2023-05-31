import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ClaseTest {

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bd_ejemplo?characterEncoding=utf8";
	private static final String USUARIO = "root";
	private static final String CLAVE = "Qwerty";

	public static void main(String[] args) {
		ClaseTest test = new ClaseTest();
		test.probarConexion();
		test.probarStockage();
		test.probarStockage2();
		test.probarStockage3();
		test.probarStockage4();
		test.probarStockage5();
		test.probarStockage6();
	}

	public void probarStockage() {
		// Caso de prueba 1: cantProducto1 y cantProducto2 son menores que el stock
		probarStockageCaso(5, 10, 25, 20);

		// Caso de prueba 2: cantProducto1 y cantProducto2 son mayores que el stock
		probarStockageCaso(35, 40, -1, -1); // Suponiendo que Stockage devuelve -1 cuando no hay suficiente stock

		// Caso de prueba 3: cantProducto1 es menor que el stock y cantProducto2 es
		// mayor que el stock
		probarStockageCaso(5, 40, 25, -1);

		// Caso de prueba 4: cantProducto1 es mayor que el stock y cantProducto2 es
		// menor que el stock
		probarStockageCaso(35, 10, -1, 20);
	}

	public void probarStockageCaso(int cantProducto1, int cantProducto2, int stockEsperadoProducto1,
			int stockEsperadoProducto2) {
		List<Integer> resultadoStock = null;
		try {
			resultadoStock = Producto.Stockage(new Scanner(System.in), cantProducto1, cantProducto2, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (resultadoStock != null && resultadoStock.size() >= 2 && resultadoStock.get(0) == stockEsperadoProducto1
				&& resultadoStock.get(1) == stockEsperadoProducto2) {
			System.out.println("Prueba de Stockage PASADA para cantProducto1 = " + cantProducto1 + " y cantProducto2 = "
					+ cantProducto2);
		} else {
			System.out.println("Prueba de Stockage FALLIDA para cantProducto1 = " + cantProducto1
					+ " y cantProducto2 = " + cantProducto2);
			System.out.println("Stock esperado para el producto 1: " + stockEsperadoProducto1 + ", Stock actual: "
					+ (resultadoStock != null && resultadoStock.size() >= 1 ? resultadoStock.get(0) : "N/A"));
			System.out.println("Stock esperado para el producto 2: " + stockEsperadoProducto2 + ", Stock actual: "
					+ (resultadoStock != null && resultadoStock.size() >= 2 ? resultadoStock.get(1) : "N/A"));
		}
	}

	public void probarStockage2() {
		// Caso de prueba: cantProducto1 y cantProducto2 son iguales a 0 (el cliente no
		// pide ningún producto)
		probarStockageCaso(0, 0, 30, 30);
	}

	public void probarStockage3() {
		// Caso de prueba: cantProducto1 es igual a 0 y cantProducto2 es menor que el
		// stock
		probarStockageCaso(0, 10, 30, 20);
	}

	public void probarStockage4() {
		// Caso de prueba: cantProducto1 es menor que el stock y cantProducto2 es igual
		// a 0
		probarStockageCaso(5, 0, 25, 30);
	}

	public void probarStockage5() {
		// Caso de prueba: cantProducto1 es igual al stock y cantProducto2 es mayor que
		// el stock
		probarStockageCaso(30, 35, 0, 0); // Cuando no hay suficiente stock, Stockage devuelve el stock actual (que es
											// 0)
	}

	public void probarStockage6() {
		// Caso de prueba: cantProducto1 es mayor que el stock y cantProducto2 es igual
		// al stock
		probarStockageCaso(35, 30, 0, 0);
	}

	// Creamos un ArrayList para el stock de cada producto

	public void probarConexion() {
		Connection conexion = null;
		try {
			Class.forName(CONTROLADOR);
			conexion = conectar();
			if (conexion != null) {
				System.out.println("Conexión correctamente establecida con la base de datos");
				// Aquí puedes agregar la lógica adicional que deseas probar
			} else {
				System.out.println("No se pudo establecer la conexión");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador de la base de datos");
			e.printStackTrace();
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Connection conectar() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}
		return conexion;
	}
}

