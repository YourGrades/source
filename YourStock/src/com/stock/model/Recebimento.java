package com.stock.model;

public class Recebimento {

    private int codigoRecebimento;
    private String descricao;
    private int qtdRecebe;
    private int codigoProduto;
    private Produto produto;

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

    public int getCodigoProduto(){
        return this.codigoProduto;
    }

    public int getQtdRecebe() {
        return qtdRecebe;
    }

    public void setQtdRecebe(int qtdRecebe) {
        this.qtdRecebe = qtdRecebe;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Recebimento(int codigoRecebimento, String descricao, int qtdRecebe, int codigoProduto) {
        this.codigoRecebimento = codigoRecebimento;
        this.descricao = descricao;
        this.qtdRecebe = qtdRecebe;
        this.codigoProduto = codigoProduto;
    }
}
