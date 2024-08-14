package classes;

public class Transportadora {
    private Double valorFrete;
	private Boolean capital;

    public Transportadora(String regiao, boolean capital
    ){      
        this.valorFrete = definirValorFretePorRegiao(regiao);
    }

    public Double definirValorFretePorRegiao(String regiao)
		switch (regiao) {
			case "Distrito Federal":
				return 5.0;
			case "Região Centro-oeste":
				return capital ? 10.0 : 13.0;
			case "Região Nordeste":
				return capital ? 15.0 : 18.0;
			case "Região Norte":
				return capital ? 20.0 : 25.0;
			case "Região Sudeste":
				return capital ? 7.0 : 10.0;
			case "Região Sul":
				return capital ? 10.0 : 13.0;
			default:
				return 0.0;
		}
	}
}
