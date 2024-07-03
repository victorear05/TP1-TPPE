package test.mock;

import java.util.Arrays;
import java.util.List;

import classes.Cliente;
import classes.Produto;

public class MockProduto {
    public static List<Produto> getProdutos() {
        return Arrays.asList(
                new Produto(242, "Teclado Mecânico", 109.99, "unidade"),
                new Produto(241, "Mouse", 219.99, "unidade"),
                new Produto(240, "Tecla", 10.00, "peça"));
    }
}
