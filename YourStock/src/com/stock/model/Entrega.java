package com.stock.model;

public class Entrega {
    public enum STATUS {
        PENDENTE,
        ENVIADO,
        ENTREGUE
    }

    private int codigoEntrega;
    private String dataEntrega;
    private STATUS status;
    private String descricao;
    private int qtdEntrega;
    private int codigoProduto;
    private Produto produto;

    public int getCodigoEntrega() {
        return codigoEntrega;
    }

    public void setCodigoEntrega(int codigoEntrega) {
        this.codigoEntrega = codigoEntrega;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public STATUS getStatus() {
        return status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdEntrega() {
        return qtdEntrega;
    }

    public void setQtdEntrega(int qtdEntrega) {
        this.qtdEntrega = qtdEntrega;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getCodigoProduto() {

        return this.codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public void atualizarStatus(int aux){
        switch (aux){
            case 1:
                this.status = STATUS.ENVIADO;
                break;
            case 2:
                this.status = STATUS.ENTREGUE;
                break;
            default:
                this.status = STATUS.PENDENTE;
        }
    }

    public Entrega(int codigoEntrega,String dataEntrega, String descricao, int qtdEntrega, int codigoProduto) {
        this.codigoEntrega = codigoEntrega;
        this.dataEntrega = dataEntrega;
        this.status = STATUS.PENDENTE;
        this.descricao = descricao;
        this.qtdEntrega = qtdEntrega;
        this.codigoProduto = codigoProduto;
    }
}
