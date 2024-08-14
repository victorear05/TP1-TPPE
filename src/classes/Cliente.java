package classes;

public class Cliente {
	private String nome;
	private Boolean prime;
	private Double comprasMensais;
	private Double descontoEspecial;
	private String regiao;
	private Boolean capital;
	private String tipoCliente;
	private Double valorFrete;
	private Double cashbackReal;
	private Double cashbackTotal;
	private Double taxaIcms;
	private Double taxaImunicipal;

	public Cliente(
			String nome, boolean prime, double comprasMensais,
			String regiao, boolean capital, double cashbackTotal) {
		this.nome = nome;
		this.prime = prime;
		this.comprasMensais = comprasMensais;
		this.descontoEspecial = definirDescontoEspecial(comprasMensais);
		this.regiao = regiao;
		this.capital = capital;
		this.tipoCliente = definirTipoCliente(prime, comprasMensais);
		this.valorFrete = definirValorFrete(prime, regiao, capital, getTipoCliente());
		this.cashbackReal = definirCashbackReal(prime);
		this.cashbackTotal = cashbackTotal;
		this.taxaIcms = definirTaxaIcms(regiao);
		this.taxaImunicipal = definirTaxaImunicipal(regiao);

	}

	private double definirDescontoEspecial(double comprasMensais) {
		if (comprasMensais > 100.00) {
			return 0.1;
		} else {
			return 0.0;
		}
	}

	private String definirTipoCliente(boolean prime, double comprasMensais) {
		if (prime) {
			return "prime";
		} else if (comprasMensais > 100.0) {
			return "especial";
		} else {
			return "padrão";
		}
	}

	private Double definirValorFrete(
			boolean prime, String regiao, boolean capital, String tipoCliente) {
		if (prime) {
			return 0.0;
		}
		this.valorFrete = new Transportadora(regiao, capital).definirValorFretePorRegiao(regiao);

		return this.aplicarDescontoFreteTipoCliente(tipoCliente, this.valorFrete);
	}

	private Double aplicarDescontoFreteTipoCliente(String tipoCliente, Double valorFrete) {

		switch (tipoCliente) {
			case "prime":
				return 0.0;
			case "especial":
				return (valorFrete * 0.7);
			default:
				return valorFrete;
		}
	}

	// private Double definirValorFretePorRegiao(String regiao) {
	// 	switch (regiao) {
	// 		case "Distrito Federal":
	// 			return 5.0;
	// 		case "Região Centro-oeste":
	// 			return capital ? 10.0 : 13.0;
	// 		case "Região Nordeste":
	// 			return capital ? 15.0 : 18.0;
	// 		case "Região Norte":
	// 			return capital ? 20.0 : 25.0;
	// 		case "Região Sudeste":
	// 			return capital ? 7.0 : 10.0;
	// 		case "Região Sul":
	// 			return capital ? 10.0 : 13.0;
	// 		default:
	// 			return 0.0;
	// 	}
	// }

	private Double definirCashbackReal(Boolean prime) {
		if (prime) {
			return 0.03;
		} else {
			return 0.0;
		}
	}

	private Double definirTaxaIcms(String regiao) {
		if (regiao.equals("Distrito Federal")) {
			return 0.18;
		} else {
			return 0.12;
		}
	}

	private Double definirTaxaImunicipal(String regiao) {
		if (regiao.equals("Distrito Federal")) {
			return 0.0;
		} else {
			return 0.04;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getPrime() {
		return prime;
	}

	public void setPrime(Boolean prime) {
		this.prime = prime;
	}

	public Double getComprasMensais() {
		return comprasMensais;
	}

	public void setComprasMensais(Double comprasMensais) {
		this.comprasMensais = comprasMensais;
	}

	public Double getDescontoEspecial() {
		return descontoEspecial;
	}

	public void setDescontoEspecial(Double descontoEspecial) {
		this.descontoEspecial = descontoEspecial;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Boolean getCapital() {
		return capital;
	}

	public void setCapital(Boolean capital) {
		this.capital = capital;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public Double getCashbackReal() {
		return cashbackReal;
	}

	public void setCashbackReal(Double cashbackReal) {
		this.cashbackReal = cashbackReal;
	}

	public Double getCashbackTotal() {
		return cashbackTotal;
	}

	public void setCashbackTotal(Double cashbackTotal) {
		this.cashbackTotal = cashbackTotal;
	}

	public Double getTaxaIcms() {
		return taxaIcms;
	}

	public void setTaxaIcms(Double taxaIcms) {
		this.taxaIcms = taxaIcms;
	}

	public Double getTaxaImunicipal() {
		return taxaImunicipal;
	}

	public void setTaxaImunicipal(Double taxaImunicipal) {
		this.taxaImunicipal = taxaImunicipal;
	}
}