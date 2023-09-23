package EX4;

public class Fatura {
    private String numero;
    private String descricao;
    private int quantidadeItens;

    private double precoUnitario;

    public Fatura(String numero, String descricao, int quantidadeItens, double precoUnitario) {
        this.numero = numero;
        this.descricao = descricao;
        setQuantidadeItens(quantidadeItens);
        setPrecoUnitario(precoUnitario);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = Math.max(quantidadeItens, 0);
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = Math.max(precoUnitario, 0);
    }

    public double getValorFatura() {
        return this.quantidadeItens * this.precoUnitario;
    }
}
