package classes;

import java.util.GregorianCalendar;
import java.util.List;

public class Venda {
    private Cliente cliente;
	private List<Produto> itensVendidos;
    private GregorianCalendar dataVenda;
    private String metodoPagamento;
    private String cartao;
	private Double valorTotal;
    private Double valorDescontos;
    private Double valorTaxas;
    private Double valorFinal;
    private Double valorCashback;

    public Venda(
    		Cliente cliente, List<Produto> itensVendidos, GregorianCalendar dataVenda, 
    		String metodoPagamento, String cartao
    		) {
        this.cliente = cliente;
        this.itensVendidos = itensVendidos;
        this.dataVenda = dataVenda;
        this.metodoPagamento = metodoPagamento;
        this.cartao = cartao;
        this.valorTotal = calcularValorTotal(itensVendidos);
        this.valorDescontos = calcularValorDescontos(cliente, metodoPagamento, cartao);
        this.valorTaxas = calcularValorTaxas(cliente);
        this.valorFinal = calcularValorFinal();
        this.valorCashback = calcularValorCashback(cliente, metodoPagamento, cartao);
    }

    private Double calcularValorTotal(List<Produto> itensVendidos) {
        Double valorTotal = itensVendidos.stream()
                .map(Produto::getValor)
                .reduce(0.0, Double::sum);
        return valorTotal;
    }

    private Double calcularValorDescontos(Cliente cliente, String metodoPagamento, String cartao) {
    	Double descontoCartao;
    	if (metodoPagamento == "cartao" && cartao.substring(0, 6) == "429613") {
    		descontoCartao = 0.1;
    	} else {
    		descontoCartao = 0.0;
    	}
    	
    	return getValorTotal() * (cliente.getDescontoEspecial() + descontoCartao);
    }

    private Double calcularValorTaxas(Cliente cliente) {
    	Double taxas = cliente.getTaxaIcms() + cliente.getTaxaImunicipal();
        return getValorTotal() * taxas + cliente.getValorFrete();
    }

    private Double calcularValorFinal() {
        return getValorTotal() - getValorDescontos() + getValorTaxas();
    }

    private Double calcularValorCashback(
    		Cliente cliente, String metodoPagamento, String cartao
    		) {
    	Double cashbackRealCartao;
    	if (metodoPagamento == "cartao" && cartao.substring(0, 6) == "429613") {
    		cashbackRealCartao = 0.05;
    	} else {
    		cashbackRealCartao = 0.0;
    	}
    	
    	return Math.floor(getValorTotal()) * (cliente.getCashbackReal() + cashbackRealCartao);
    }
    
    public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getItensVendidos() {
		return itensVendidos;
	}

	public void setItensVendidos(List<Produto> itensVendidos) {
		this.itensVendidos = itensVendidos;
	}

	public GregorianCalendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(GregorianCalendar dataVenda) {
		this.dataVenda = dataVenda;
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

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorDescontos() {
		return valorDescontos;
	}

	public void setValorDescontos(Double valorDescontos) {
		this.valorDescontos = valorDescontos;
	}

	public Double getValorTaxas() {
		return valorTaxas;
	}

	public void setValorTaxas(Double valorTaxas) {
		this.valorTaxas = valorTaxas;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Double getValorCashback() {
		return valorCashback;
	}

	public void setValorCashback(Double valorCashback) {
		this.valorCashback = valorCashback;
	}
}
