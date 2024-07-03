package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import classes.Cliente;
import classes.Produto;
import classes.Venda;
import test.mock.MockCliente;
import test.mock.MockProduto;

@RunWith(Parameterized.class)
public class VendaTeste {
    private Venda venda;
    private Cliente cliente;
    private List<Produto> itensVendidos;
    private GregorianCalendar dataVenda;
    private String metodoPagamento;
    private Double subTotal;
    private Double valorDesconto;
    private Double valorImpostos;
    private Double valorFinal;

    public VendaTeste(Venda venda, Cliente cliente, List<Produto> itensVendidos, GregorianCalendar dataVenda,
            String metodoPagamento,
            Double subTotal, Double valorDesconto, Double valorImpostos, Double valorFinal) {
        this.venda = venda;
        this.cliente = cliente;
        this.itensVendidos = itensVendidos;
        this.dataVenda = dataVenda;
        this.metodoPagamento = metodoPagamento;
        this.subTotal = subTotal;
        this.valorDesconto = valorDesconto;
        this.valorImpostos = valorImpostos;
        this.valorFinal = valorFinal;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        // TODO: Trocar valorDesconto, valorImpostos, valorFinal
        return Arrays.asList(new Object[][] {
                { new Venda(MockCliente.getClientePadrao(), MockProduto.getProdutos(),
                        new GregorianCalendar(2023, 6, 2), "4296 1310 1123 1416"), MockCliente.getClientePadrao(),
                        MockProduto.getProdutos(), new GregorianCalendar(2023, 6, 2), "4296 1310 1123 1416", 339.98,
                        0.0, 0.0, 339.98 }
        });
    }

    @Test
    public void subTotalTest() {
        assertEquals(this.subTotal, venda.getSubTotal());
    }

    @Test
    public void valorFinalTest() {
        assertEquals(this.valorFinal, venda.getValorFinal());
    }

}
