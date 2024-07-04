package test.mock;

import java.util.Arrays;
import java.util.List;

import classes.Cliente;

public class MockCliente {
    public static List<Cliente> getClientes() {
        return Arrays.asList(
        		/*
        		 * new Cliente("John Doe", false, 50.0, "Distrito Federal", true), new
        		 * Cliente("Alicia Key", false, 150.0, "Região Centro-oeste", true), new
        		 * Cliente("Michael Jackson", false, 100.0, "Região Nordeste", false), new
        		 * Cliente("Lebron James", false, 99.9, "Região Norte", true), new
        		 * Cliente("Lionel Messi", false, 100.1, "Região Sudeste", false), new
        		 * Cliente("Neymar Junior", true, 0.0, "Região Sul", true), new
        		 * Cliente("Leonidas Souza", true, 150.0, "Distrito Federal", false)
        		 */
        		);
    }

	/*
	 * public static Cliente getClientePrime() { return new Cliente(
	 * "Neymar Junior", true, 0.0, "Região Sul", true ); }
	 * 
	 * public static Cliente getClientePadrao() { return new Cliente( "John Doe",
	 * false, 50.0, "Distrito Federal", true ); }
	 */
}
