public class Excepciones {
	public static class TelefonoInvalidoException extends Exception {
		public TelefonoInvalidoException(String mensaje) {
			super(mensaje);
		}
	}

	public static class ImportePagoException extends Exception {
		public ImportePagoException(String mensaje) {
			super(mensaje);
		}
	}

	public static class NumeroCuentaInvalidoException extends Exception {
		public NumeroCuentaInvalidoException(String mensaje) {
			super(mensaje);
		}
	}

	public static void validarTelefono(int telefono) throws TelefonoInvalidoException {
		if (telefono < 100000000 || telefono > 999999999) {
			throw new TelefonoInvalidoException("Teléfono inválido. El número debe tener 9 dígitos.");
		}
	}

	public static void validarImportePago(double importe) throws ImportePagoException {
		if (importe < 0) {
			throw new ImportePagoException("Importe de pago inválido. El importe no puede ser negativo.");
		}
	}

	public static void validarNumeroCuenta(String numeroCuenta) throws NumeroCuentaInvalidoException {
		// Realizar la validación del número de cuenta
		if (numeroCuenta.length() != 10) {
			throw new NumeroCuentaInvalidoException(
					"Número de cuenta inválido. El número de cuenta debe tener 10 caracteres.");
		}
	}

	public static void validarTarjeta(String numeroTarjeta) throws TarjetaInvalidaException {
		int primerDigito = Integer.parseInt(numeroTarjeta.substring(0, 1));
		int longitud = numeroTarjeta.length();

		if ((primerDigito == 3 && longitud == 15) || (primerDigito == 4 && longitud == 16)
				|| (primerDigito == 5 && longitud == 16)) {
			System.out.println("Su tarjeta ha sido aceptada");
			if (primerDigito == 3) {
				System.out.println("Su tarjeta es una American Express");
			} else if (primerDigito == 4) {
				System.out.println("Su tarjeta es una Visa");
			} else if (primerDigito == 5) {
				System.out.println("Su tarjeta es una Mastercard");
			}
		} else {
			throw new TarjetaInvalidaException(
					"Número de tarjeta inválido. La tarjeta no es de tipo American Express, Visa o Mastercard.");
		}
	}

	public static class TarjetaInvalidaException extends Exception {
		public TarjetaInvalidaException(String mensaje) {
			super(mensaje);
		}
	}
}


