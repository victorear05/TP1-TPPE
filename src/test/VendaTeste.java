package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import classes.Venda;
import test.mock.MockVenda;

@RunWith(Parameterized.class)
public class VendaTeste {
    private Venda venda;
    private Double subTotal;
    private Double valorDesconto;
    private Double valorTaxas;
    private Double valorFinal;
    private Double valorCashback;

    public VendaTeste(Venda venda, Double subTotal, Double valorDesconto, Double valorTaxas, Double valorCashback,
            Double valorFinal) {
        this.venda = venda;
        this.subTotal = subTotal;
        this.valorDesconto = valorDesconto;
        this.valorTaxas = valorTaxas;
        this.valorCashback = valorCashback;
        this.valorFinal = valorFinal;

    }

    @Parameters
    public static Collection<Object[]> getParameters() {

        return Arrays.asList(new Object[][] {
                {
                        MockVenda.getVendaPadraoCartaoLoja(), 339.98, (339.98 * 0.1), ((339.98 * 0.18) + 5.0),
                        (339.98 * 0.05), 372.1784
                },
                {
                        MockVenda.getVendaEspecialCartaoNaoLoja(), 339.98, (339.98 * 0.1), ((339.98 * 0.16) + 7.0), 0.0,
                        367.3788
                },
                {
                        MockVenda.getVendaEspecialCartaoLoja(), 339.98, (339.98 * 0.2), ((339.98 * 0.16) + 7.0),
                        (339.98 * 0.05), 333.3808
                },
                {
                        MockVenda.getVendaPrimeCartaoLoja(), 339.98, (339.98 * 0.1), ((339.98 * 0.16)), (339.98 * 0.08),
                        360.3788
                },
                {
                        MockVenda.getVendaPrimeDinheiro(), 339.98, 0.0, ((339.98 * 0.16)), (339.98 * 0.03), 394.3768
                }

        });
    }

    @Test
    public void calcularSubTotalTest() {
        assertEquals(this.subTotal, venda.getSubTotal());
    }

    @Test
    public void calcularValorFinalTest() {
        assertEquals(this.valorFinal, venda.getValorFinal());
    }

    @Test
    public void calcularValorDescontosTest() {
        assertEquals(this.valorDesconto, venda.getValorDescontos());
    }

    @Test
    public void calcularValorTaxasTest() {
        assertEquals(this.valorTaxas, venda.getValorTaxas());
    }

    @Test
    public void calcularValorCashbackTest() {
        assertEquals(this.valorCashback, venda.getValorCashback());
    }
}
