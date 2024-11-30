package com.stock.model;

public class Produto {
    private int codigoProduto;
    private String nome;
    private String descricao;
    private double preco;
    private String categoria;
    private Fornecedor fornecedor;
    private int quantidadeEstoque = 0;

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void atualizarQuantidade(int qtdAtualizacao){
        int qtd = this.getQuantidadeEstoque() + qtdAtualizacao;
        this.setQuantidadeEstoque(qtd);
    }

    public double calcularValorTotalEstoque(){
        return (this.getPreco() * this.getQuantidadeEstoque());
    }

    public Produto(int codigoProduto, String nome, String descricao, double preco, String categoria, Fornecedor fornecedor) {
        this.codigoProduto = codigoProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigoProduto=" + this.codigoProduto +
                ", nome='" + this.nome + '\'' +
                ", descricao='" + this.descricao + '\'' +
                ", preco=" + this.preco +
                ", categoria='" + this.categoria + '\'' +
                ", fornecedor=" + this.fornecedor.getNome() +
                '}';
    }
}
