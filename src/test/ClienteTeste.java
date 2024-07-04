package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import classes.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class ClienteTeste {
    private Cliente cliente;
    private String nome;
    private boolean ehPrime;
    private double comprasMensais;
    private String regiao;
    private boolean ehCapital;
    private String tipoCliente;
    private Double custoFrete;

    public ClienteTeste(Cliente cliente, String nome, boolean ehPrime, double comprasMensais, String regiao, boolean ehCapital, String tipoCliente, Double custoFrete) {
        this.cliente = cliente;
        this.nome = nome;
        this.ehPrime = ehPrime;
        this.comprasMensais = comprasMensais;
        this.regiao = regiao;
        this.ehCapital = ehCapital;
        this.tipoCliente = tipoCliente;
        this.custoFrete = custoFrete;
    }

    @Parameters
    public static Collection<Object[]> parametros() {
        return Arrays.asList(new Object[][] {
        	{ 
				/*
				 * new Cliente("John Doe", false, 50.0, "Distrito Federal", true), "John Doe",
				 * false, 50.0, "Distrito Federal", true, "padrão", 5.0
				 */
        	},
            {
				/*
				 * new Cliente("Alicia Key", false, 150.0, "Região Centro-oeste", true),
				 * "Alicia Key", false, 150.0, "Região Centro-oeste", true, "especial", 10.0
				 */
        	},
            {
				/*
				 * new Cliente("Michael Jackson", false, 100.0, "Região Nordeste", false),
				 * "Michael Jackson", false, 100.0, "Região Nordeste", false, "padrão", 18.0
				 */
        	},
            {
				/*
				 * new Cliente("Lebron James", false, 99.9, "Região Norte", true),
				 * "Lebron James", false, 99.9, "Região Norte", true, "padrão", 20.0
				 */
        	},
            {
				/*
				 * new Cliente("Lionel Messi", false, 100.1, "Região Sudeste", false),
				 * "Lionel Messi", false, 100.1, "Região Sudeste", false, "especial", 10.0
				 */
        	},
            {
				/*
				 * new Cliente("Neymar Junior", true, 0.0, "Região Sul", true), "Neymar Junior",
				 * true, 0.0, "Região Sul", true, "prime", 0.0
				 */
        	},
            {
				/*
				 * new Cliente("Leonidas Souza", true, 150.0, "Distrito Federal", false),
				 * "Leonidas Souza", true, 150.0, "Distrito Federal", false, "prime", 0.0
				 */
        	}
        });
    }

    @Test
    public void nomeTest() {
        assertEquals(this.nome, cliente.getNome());
    }

    @Test
    public void ehPrimeTest() {
        assertEquals(this.ehPrime, cliente.getPrime());
    }

    @Test
    public void comprasMensaisTest() {
        assertEquals(this.comprasMensais, cliente.getComprasMensais(), 0.01);
    }

    @Test
    public void regiaoTest() {
        assertEquals(this.regiao, cliente.getRegiao());
    }

    @Test
    public void ehCapitalTest() {
        assertEquals(this.ehCapital, cliente.getCapital());
    }

    @Test
    public void tipoClienteTest() {
        assertEquals(this.tipoCliente, cliente.getTipoCliente());
    }

    @Test
    public void custoFreteTest() {
        assertEquals(this.custoFrete, cliente.getValorFrete());
    }
}
