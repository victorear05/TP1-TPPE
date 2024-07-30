package classes;

import java.util.List;

public class CalculadoraDescontos {
    private List<Produto> itensVendidos;
    private Cliente cliente;
    private String metodoPagamento;
    private String cartao;
    private Double subTotal;

    public CalculadoraDescontos(List<Produto> itensVendidos, Cliente cliente, String metodoPagamento, String cartao, Double subTotal) {
        this.itensVendidos = itensVendidos;
        this.cliente = cliente;
        this.metodoPagamento = metodoPagamento;
        this.cartao = cartao;
        this.subTotal = subTotal;
    }

    public Double calcular() {
        Double descontoCartao;
        if (metodoPagamento.equals("cartao") && cartao.substring(0, 6).equals("429613")) {
            descontoCartao = 0.1;
        } else {
            descontoCartao = 0.0;
        }

        return this.subTotal * (cliente.getDescontoEspecial() + descontoCartao);
    }

    public List<Produto> getItensVendidos() {
        return itensVendidos;
    }

    public void setItensVendidos(List<Produto> itensVendidos) {
        this.itensVendidos = itensVendidos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
}
