package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import classes.CalculadoraDescontos;
import classes.Cliente;
import classes.Produto;

@RunWith(Parameterized.class)
public class CalculadoraDescontosTeste {
    private CalculadoraDescontos calculadoraDescontos;
    private Double expectedDesconto;

    public CalculadoraDescontosTeste(CalculadoraDescontos calculadoraDescontos, Double expectedDesconto) {
        this.calculadoraDescontos = calculadoraDescontos;
        this.expectedDesconto = expectedDesconto;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        Produto produto1 = new Produto(1, "Produto 1", 100.0, "un");
        Produto produto2 = new Produto(2, "Produto 2", 200.0, "un");

        Cliente clienteComDescontoEspecial = new Cliente("Cliente Especial", false, 200.0, "Região Sudeste", true, 0.0);
        Cliente clienteSemDescontoEspecial = new Cliente("Cliente Padrão", false, 50.0, "Região Sudeste", true, 0.0);
        Cliente clientePrime = new Cliente("Cliente Prime", true, 150.0, "Região Sudeste", true, 0.0);

        return Arrays.asList(new Object[][] {
                { new CalculadoraDescontos(Arrays.asList(produto1, produto2), clienteComDescontoEspecial, "cartao", "4296131234567890", 300.0), 60.0 },
                { new CalculadoraDescontos(Arrays.asList(produto1, produto2), clienteSemDescontoEspecial, "cartao", "4296131234567890", 300.0), 30.0 },
                { new CalculadoraDescontos(Arrays.asList(produto1, produto2), clienteComDescontoEspecial, "dinheiro", "", 300.0), 30.0 },
                { new CalculadoraDescontos(Arrays.asList(produto1, produto2), clienteSemDescontoEspecial, "dinheiro", "", 300.0), 0.0 },
                { new CalculadoraDescontos(Arrays.asList(produto1, produto2), clientePrime, "cartao", "4296131234567890", 300.0), 60.0 }
        });
    }

    @Test
    public void calcularDescontoTest() {
        assertEquals(expectedDesconto, calculadoraDescontos.calcular(), 0.0001);
    }
}
