import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Pasarela {
	private double importe;
	String codigoPago;

	public Pasarela() {
		this.importe = 0;
		this.codigoPago = String.valueOf((new Date()).getTime());
	}

	public void CodigoPago(String codigoPago1) {
		codigoPago = String.valueOf((new Date()).getTime());
		codigoPago1 = codigoPago;
		System.out.println(codigoPago1);
	}


	public void pagoTarjeta(Scanner sc) {
		try {
			System.out.println("Ha seleccionado pago en tarjeta");
			System.out.println("¿Cuanto quiere pagar?");
			double pago2 = sc.nextDouble();

			Excepciones.validarImportePago(pago2);

			if (pago2 >= importe) {
				System.out.println("Ingrese los numeros de su tarjeta en su debido orden");
				String numerotar1 = sc.nextLine();
				numerotar1 = sc.nextLine();

				String numerotar = numerotar1.replaceAll("\\s", "");
				System.out.println(numerotar);
				Excepciones.validarTarjeta(numerotar);

				System.out.println("Se ha realizado el pago con éxito. Código de pago: " + codigoPago);
				importe = 0;
				codigoPago = String.valueOf((new Date()).getTime());
			} else {
				System.out.println("La cantidad tiene que ser igual o mayor a la del ticket");
				System.out.println("pruebe de nuevo");
			}
		} catch (Excepciones.ImportePagoException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Valor inválido. Ingrese un número válido.");
		} catch (Excepciones.TarjetaInvalidaException e) {
			System.out.println(e.getMessage());
		}
	}

	public void pagoEfectivo(Scanner sc) {
		try {
			System.out.println("Indique el importe total a pagar:");
			double total = sc.nextDouble();

			System.out.println("Indique la cantidad a pagar en efectivo:");
			double pago = sc.nextDouble();

			Excepciones.validarImportePago(total);

			if (pago >= total) {
				double vueltas = pago - total;

				if (vueltas > 0) {
					System.out.println("Pago realizado con éxito. Código de pago: " + generarCodigoPago());
					System.out.println("Ha seleccionado pago en efectivo");

					System.out.println("Se devuelven:");
					double[] valores = { 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01 };
					int[] cambio = new int[12];

					for (int i = 0; i < valores.length; i++) {
						while (vueltas >= valores[i]) {
							vueltas -= valores[i];
							cambio[i]++;
						}
					}

					String[] nombres = { "Billetes de 50", "Billetes de 20", "Billetes de 10", "Billetes de 5",
							"Monedas de 2", "Monedas de 1", "Monedas de 0.5", "Monedas de 0.2", "Monedas de 0.1",
							"Monedas de 0.05", "Monedas de 0.02", "Monedas de 0.01" };

					for (int i = 0; i < cambio.length; i++) {
						if (cambio[i] > 0) {
							System.out.println(cambio[i] + " " + nombres[i]);
						}
					}
				} else {
					System.out.println("No se requiere cambio. Pago exacto.");
				}
			} else {
				System.out.println(
						"La cantidad ingresada es menor al importe a pagar. Por favor, ingrese una cantidad válida.");
			}
		} catch (Excepciones.ImportePagoException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Valor inválido. Ingrese un número válido.");
		}
	}



	public void elegirpago(Pasarela pago, Scanner sc) {
		System.out.println("Como desea pagar");
		System.out.println("1.Efectivo");
		System.out.println("2.Tarjeta");
		System.out.println("3.Pago a cuenta");
		int decision2 = sc.nextInt();

		if (decision2 == 1) {
			pago.pagoEfectivo(sc);
		} else if (decision2 == 2) {
			pago.pagoTarjeta(sc);
		} else if (decision2 == 3) {
			pago.pagoCuenta(sc);
		}
	}

	public void pagoCuenta(Scanner sc) {
		try {
			System.out.println("Ha seleccionado pago a cuenta");
			System.out.println("Indique su número de cuenta:");
			String numeroCuenta = sc.nextLine();
			numeroCuenta = sc.nextLine();

			Excepciones.validarNumeroCuenta(numeroCuenta);

			System.out.println("Ingrese su número de teléfono:");
			int telefono = sc.nextInt();

			Excepciones.validarTelefono(telefono);

			System.out.println("Se ha realizado el pago con éxito. Código de pago: " + generarCodigoPago());
			importe = 0;
			codigoPago = String.valueOf((new Date()).getTime());
		} catch (Excepciones.NumeroCuentaInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Valor inválido. Ingrese un número válido.");
		} catch (Excepciones.TelefonoInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}

	private String generarCodigoPago() {
		return String.valueOf(new Date().getTime());
	}


}
