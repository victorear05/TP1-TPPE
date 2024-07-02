package classes;

public class Produto {
    private Integer codigoItem;
    private String descricao;
    private Double valor;
    private String unidade;

    public Produto(Integer codigoItem, String descricao, Double valor, String unidade) {
        this.codigoItem = codigoItem;
        this.descricao = descricao;
        this.valor = valor;
        this.unidade = unidade;
    }

    public Integer getCodigoItem() {
        return this.codigoItem;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Double getValor() {
        return this.valor;
    }

    public String getUnidade() {
        return this.unidade;
    }

    public void setCodigoItem(Integer codigoItem) {
        this.codigoItem = codigoItem;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
