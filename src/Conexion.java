import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Clase que maneja la conexión a la base de datos y realiza operaciones de
 * inserción.
 */
public class Conexion {

	/**
	 * Controlador JDBC para la base de datos MySQL.
	 */
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";

	/**
	 * URL de conexión a la base de datos.
	 */
	private static final String URL = "jdbc:mysql://localhost:3306/bd_ejemplo?characterEncoding=utf8";

	/**
	 * Usuario de la base de datos.
	 */
	private static final String USUARIO = "root";

	/**
	 * Contraseña del usuario de la base de datos.
	 */
	private static final String CLAVE = "Qwerty";

	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}

	/**
	 * Establece una conexión a la base de datos.
	 *
	 * @return Objeto Connection que representa la conexión establecida.
	 */

	public Connection conectar() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexión correctamente establecida con la base de datos");
		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}
		return conexion;
	}

	/**
	 * Ingresa una lista de comidas y bebidas en la base de datos.
	 *
	 * @param comidas Lista de comidas a ingresar.
	 * @param bebidas Lista de bebidas a ingresar.
	 */
	public void ingresarProductos(List<Comida> comidas, List<Bebida> bebidas) {
		try (Connection connection = conectar()) {
			for (Comida comida : comidas) {
				insertarComida(comida, connection);
			}

			for (Bebida bebida : bebidas) {
				insertarBebida(bebida, connection);
			}

			System.out.println("Datos de los productos ingresados en la base de datos");
		} catch (SQLException e) {
			System.out.println("Error al insertar los datos en la base de datos");
			e.printStackTrace();
		}
	}

	/**
	 * Inserta una comida en la base de datos.
	 *
	 * @param comida     Comida a insertar.
	 * @param connection Conexión a la base de datos.
	 * @throws SQLException Si ocurre un error durante la inserción.
	 */
	private void insertarComida(Comida comida, Connection connection) throws SQLException {
		String sql = "INSERT INTO productos (nombre, precio, fecha_caducidad, estado, cantidad, perecedero, calorias, vegano, fecha_envase) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, comida.getNombre());
		statement.setDouble(2, comida.getPrecio());
		statement.setDate(3, new java.sql.Date(comida.getFechaCaducidad().getTime()));
		statement.setString(4, comida.getEstado());
		statement.setInt(5, comida.getCantidad());
		statement.setBoolean(8, comida.isPerecedero());
		statement.setFloat(9, comida.getCalorias());
		statement.setBoolean(10, comida.getVegano());
		statement.setDate(11, new java.sql.Date(comida.getFechaEnvase().getTime()));
		statement.executeUpdate();
	}

	/**
	 * Inserta una bebida en la base de datos.
	 *
	 * @param bebida     Bebida a insertar.
	 * @param connection Conexión a la base de datos.
	 * @throws SQLException Si ocurre un error durante la inserción.
	 */

	private void insertarBebida(Bebida bebida, Connection connection) throws SQLException {
		String sql = "INSERT INTO productos (nombre, precio, fecha_caducidad, estado, cantidad, gaseoso, lacteo) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, bebida.getNombre());
		statement.setDouble(2, bebida.getPrecio());
		statement.setDate(3, new java.sql.Date(bebida.getFechaCaducidad().getTime()));
		statement.setString(4, bebida.getEstado());
		statement.setInt(5, bebida.getCantidad());
		statement.setBoolean(6, bebida.isGaseoso());
		statement.setBoolean(7, bebida.isLacteo());
		statement.executeUpdate();
	}


	/**
	 * Ingresa clientes en la base de datos.
	 *
	 * @param cliente1 Primer cliente a ingresar.
	 * @param cliente2 Segundo cliente a ingresar.
	 * @param cliente3 Tercer cliente a ingresar.
	 */

	public void ingresarClientesBD(Cliente cliente1, Cliente cliente2, Cliente cliente3) {
		try (Connection connection = conectar()) {
			// Preparar la consulta SQL para el primer cliente
			String sql1 = "INSERT INTO clientes (telefono, nombre, apellido, direccion) VALUES (?, ?, ?, ?)";
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setInt(1, cliente1.getTelefono());
			statement1.setString(2, cliente1.getNombre());
			statement1.setString(3, cliente1.getApellidos());
			statement1.setString(4, cliente1.getDireccion());
			statement1.executeUpdate();

			// Preparar la consulta SQL para el segundo cliente
			String sql2 = "INSERT INTO clientes (telefono, nombre, apellido, direccion) VALUES (?, ?, ?, ?)";
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			statement2.setInt(1, cliente2.getTelefono());
			statement2.setString(2, cliente2.getNombre());
			statement2.setString(3, cliente2.getApellidos());
			statement2.setString(4, cliente2.getDireccion());
			statement2.executeUpdate();

			// Preparar la consulta SQL para el tercer cliente
			String sql3 = "INSERT INTO clientes (telefono, nombre, apellido, direccion) VALUES (?, ?, ?, ?)";
			PreparedStatement statement3 = connection.prepareStatement(sql3);
			statement3.setInt(1, cliente3.getTelefono());
			statement3.setString(2, cliente3.getNombre());
			statement3.setString(3, cliente3.getApellidos());
			statement3.setString(4, cliente3.getDireccion());
			statement3.executeUpdate();

			System.out.println("Datos de los clientes ingresados en la base de datos");
		} catch (SQLException e) {
			System.out.println("Error al insertar los datos en la base de datos");
			e.printStackTrace();
		}
	}

	/**
	 * Guarda un ticket en la base de datos.
	 *
	 * @param ticket Ticket a guardar.
	 */
	public void guardarTicket(Ticket ticket) {
	    try (Connection connection = conectar()) {
	        String sql = "INSERT INTO tickets (nombre_cliente, telefono_cliente, cantidad_productos, precio_total) VALUES (?, ?, ?, ?)";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, ticket.getNombreCliente());
	        statement.setInt(2, ticket.getTelefonoCliente());
	        statement.setInt(3, ticket.getCantidadProductos());
	        statement.setDouble(4, ticket.getPrecioTotal());
	        statement.executeUpdate();

	        // Obtener la clave primaria generada automáticamente
	        

	        System.out.println("Ticket guardado en la base de datos");
	    } catch (SQLException e) {
	        System.out.println("Error al guardar el ticket en la base de datos");
	        e.printStackTrace();
	    }
	}

}

