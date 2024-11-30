package com.stock.model;

public class Recebimento {
    private int codigoRecebimento;
    private String descricao;
    private Produto produto;
    private int qtdRecebe;

    public int getCodigoRecebimento() {
        return codigoRecebimento;
    }

    public void setCodigoRecebimento(int codigoRecebimento) {
        this.codigoRecebimento = codigoRecebimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtdRecebe() {
        return qtdRecebe;
    }

    public void setQtdRecebe(int qtdRecebe) {
        this.qtdRecebe = qtdRecebe;
    }

    public Recebimento(int codigoRecebimento, String descricao, Produto produto, int qtdRecebe) {
        this.codigoRecebimento = codigoRecebimento;
        this.descricao = descricao;
        this.produto = produto;
        this.qtdRecebe = qtdRecebe;
    }
}
