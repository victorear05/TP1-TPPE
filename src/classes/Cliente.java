package classes;


public class Cliente {
    private String nome;
    private boolean prime;
    private double comprasMensais;
    private String regiao;
    private boolean capital;
    private String tipoCliente;
    private Double custoFrete;

    public Cliente(String nome, boolean prime, double comprasMensais, String regiao, boolean capital) {
        this.nome = nome;
        this.prime = prime;
        this.comprasMensais = comprasMensais;
        this.regiao = regiao;
        this.capital = capital;
        this.tipoCliente = tipoClienteResolver(prime, comprasMensais);
        this.custoFrete = custoFreteResolver(regiao, capital, prime);
    }

    private String tipoClienteResolver(boolean prime, double comprasMensais) {
        if (prime) {
            return "prime";
        } else if (comprasMensais > 100.0) {
            return "especial";
        } else {
            return "padrão";
        }
    }

    private Double custoFreteResolver(String regiao, boolean capital, boolean prime) {
        if (prime) {
            return 0.0;
        }

        Double custoFrete;
        switch (regiao) {
            case "Distrito Federal":
                custoFrete = 5.0;
                break;
            case "Região Centro-oeste":
                if (capital) {
                    custoFrete = 10.0;
                } else {
                    custoFrete = 13.0;
                }
                break;
            case "Região Nordeste":
                if (capital) {
                    custoFrete = 15.0;
                } else {
                    custoFrete = 18.0;
                }
                break;
            case "Região Norte":
                if (capital) {
                    custoFrete = 20.0;
                } else {
                    custoFrete = 25.0;
                }
                break;
            case "Região Sudeste":
                if (capital) {
                    custoFrete = 7.0;
                } else {
                    custoFrete = 10.0;
                }
                break;
            case "Região Sul":
                if (capital) {
                    custoFrete = 10.0;
                } else {
                    custoFrete = 13.0;
                }
                break;
            default:
                custoFrete = null;
        }
        return custoFrete;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean ehPrime() {
        return this.prime;
    }

    public double getComprasMensais() {
        return this.comprasMensais;
    }

    public String getRegiao() {
        return this.regiao;
    }

    public boolean ehCapital() {
        return this.capital;
    }

    public String getTipoCliente() {
        return this.tipoCliente;
    }

    public Double getCustoFrete() {
        return this.custoFrete;
    }
}