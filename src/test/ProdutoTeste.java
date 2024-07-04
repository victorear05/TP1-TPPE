package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import classes.Produto;

@RunWith(Parameterized.class)
public class ProdutoTeste {
    private Produto produto;
    private Integer codigoItem;
    private String descricao;
    private Double valor;
    private String unidade;

    public ProdutoTeste(Produto produto, Integer codigoItem, String descricao, Double valor, String unidade) {
        this.produto = produto;
        this.codigoItem = codigoItem;
        this.descricao = descricao;
        this.valor = valor;
        this.unidade = unidade;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(
        		new Object[][] { 
        			{ 
        				new Produto(242, "Teclado Mecânico", 109.99, "unidade"), 
        				242, "Teclado Mecânico", 109.99, "unidade" } 
        			});
    }

    @Test
    public void codigoItemTest() {
        assertEquals(this.codigoItem, produto.getCodigoItem());
    }

    @Test
    public void descricaoTest() {
        assertEquals(this.descricao, produto.getDescricao());
    }

    @Test
    public void valorTest() {
        assertEquals(this.valor, produto.getValor());
    }

    @Test
    public void unidadeTest() {
        assertEquals(this.unidade, produto.getUnidade());
    }
}
