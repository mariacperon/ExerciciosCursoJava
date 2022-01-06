package entities;

public class Produto {

    protected String nome;
    protected Double preco;
    protected Integer qtd;

    public Produto(String nome, Double preco, Integer qtd) {
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
    }

    public double precoTotal(){
        return preco * qtd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
}
