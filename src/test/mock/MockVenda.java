package test.mock;

import java.util.GregorianCalendar;

import classes.Venda;

public class MockVenda {
    public static Venda getVendaPadraoCartaoLoja() {
        return new Venda(MockCliente.getClientePadrao(), MockProduto.getProdutos(),
                new GregorianCalendar(2023, 6, 2), "cartao", "4296131011231416");
    }

    public static Venda getVendaEspecialCartaoNaoLoja() {
        return new Venda(MockCliente.getClienteEspecial(), MockProduto.getProdutos(),
                new GregorianCalendar(2023, 6, 2), "cartao", "4256131011231416");
    }

    public static Venda getVendaEspecialCartaoLoja() {
        return new Venda(MockCliente.getClienteEspecial(), MockProduto.getProdutos(),
                new GregorianCalendar(2023, 6, 2), "cartao", "4296131011231416");
    }

    public static Venda getVendaPrimeCartaoLoja() {
        return new Venda(MockCliente.getClientePrime(), MockProduto.getProdutos(),
                new GregorianCalendar(2023, 6, 2), "cartao", "4296131011231416");
    }

    public static Venda getVendaPrimeDinheiro() {
        return new Venda(MockCliente.getClientePrime(), MockProduto.getProdutos(),
                new GregorianCalendar(2023, 6, 2), "dinheiro", null);
    }
}
