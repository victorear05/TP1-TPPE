package test.mock;

import classes.Cliente;

public class MockCliente {
	public static Cliente getClientePrime() {
		return new Cliente(
				"Neymar Junior", true, 0.0, "Região Sul", true, 100.00);
	}

	public static Cliente getClientePadrao() {
		return new Cliente("John Doe",
				false, 50.0, "Distrito Federal", true, 0.00);
	}

	public static Cliente getClienteEspecial() {
		return new Cliente("Lionel Messi", false, 100.1, "Região Sudeste", false, 0.00);
	}

}
