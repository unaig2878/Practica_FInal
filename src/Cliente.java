import java.io.Serializable;
import java.util.Scanner;

public class Cliente implements Serializable {
	private String nombre;
	private String apellidos;
	private int telefono;
	private String direccion;

	public Cliente(String nombre, String apellidos, int telefono, String direccion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente: " + nombre + " " + apellidos + ", Teléfono: " + telefono + " direccion: " + direccion;
	}

	public static void ingresarClientes(Cliente cliente1, Cliente cliente2, Cliente cliente3, Scanner sc) {
		int telefono1 = 0, telefono2 = 0, telefono3;
		try {
			System.out.println("Cliente 1");
			System.out.println("Escriba su Nombre");
			String nombre1 = sc.nextLine();
			cliente1.setNombre(nombre1);

			System.out.println("Escriba su apellido");
			String apellido1 = sc.nextLine();
			cliente1.setApellidos(apellido1);

			try {
				System.out.println("Escriba su telefono");
				telefono1 = sc.nextInt();
				sc.nextLine();
				Excepciones.validarTelefono(telefono1);
				cliente1.setTelefono(telefono1);
			} catch (Excepciones.TelefonoInvalidoException e) {
				System.out.println("Error al ingresar el número de teléfono del Cliente 1: " + e.getMessage());
			}

			System.out.println("Escriba su Direccion");
			String direccion1 = sc.nextLine();
			cliente1.setDireccion(direccion1);
		} catch (Exception e) {
			System.out.println("Error al ingresar los datos del Cliente 1: " + e.getMessage());
		}

		// Segundo cliente
		try {
			System.out.println("Cliente 2");
			System.out.println("Escriba su Nombre");
			String nombre2 = sc.nextLine();
			cliente2.setNombre(nombre2);

			System.out.println("Escriba su apellido");
			String apellido2 = sc.nextLine();
			cliente2.setApellidos(apellido2);

			// Bucle para verificar que el número de teléfono insertado no está siendo usado
			while (true) {
				try {
					System.out.println("Escriba su telefono");
					telefono2 = sc.nextInt();
					sc.nextLine();

					Excepciones.validarTelefono(telefono2);

					// excepciones
					if (telefono2 == telefono1) {
						throw new Excepciones.TelefonoInvalidoException(
								"El número de teléfono ya está en uso. Pruebe de nuevo.");
					}

					cliente3.setTelefono(telefono2);
					break;
				} catch (Excepciones.TelefonoInvalidoException e) {
					System.out.println("Error al ingresar el número de teléfono del Cliente 3: " + e.getMessage());
				}
			}

			System.out.println("Escriba su Direccion");
			String direccion2 = sc.nextLine();
			cliente2.setDireccion(direccion2);
		} catch (Exception e) {
			System.out.println("Error al ingresar los datos del Cliente 2: " + e.getMessage());
		}

		// Tercer cliente
		try {
			System.out.println("Cliente 3");
			System.out.println("Escriba su Nombre");
			String nombre3 = sc.nextLine();
			cliente3.setNombre(nombre3);

			System.out.println("Escriba su apellido");
			String apellido3 = sc.nextLine();
			cliente3.setApellidos(apellido3);

			// Bucle para verificar que el número no esté siendo usado por ningún otro
			while (true) {
				try {
					System.out.println("Escriba su telefono");
					telefono3 = sc.nextInt();
					sc.nextLine();

					Excepciones.validarTelefono(telefono3);

					// excepciones
					if (telefono3 == telefono1 || telefono3 == telefono2) {
						throw new Excepciones.TelefonoInvalidoException(
								"El número de teléfono ya está en uso. Pruebe de nuevo.");
					}

					cliente3.setTelefono(telefono3);
					break;
				} catch (Excepciones.TelefonoInvalidoException e) {
					System.out.println("Error al ingresar el número de teléfono del Cliente 3: " + e.getMessage());
				}
			}


			System.out.println("Escriba su Direccion");
			String direccion3 = sc.nextLine();
			cliente3.setDireccion(direccion3);
		} catch (Exception e) {
			System.out.println("Error al ingresar los datos del Cliente 3: " + e.getMessage());
		}

	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
