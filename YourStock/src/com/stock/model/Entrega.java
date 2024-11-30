package com.stock.model;

import java.util.Date;

public class Entrega {
    public enum STATUS {
        PENDENTE,
        ENVIADO,
        ENTREGUE
    }
    private int codigoEntrega;
    private Date dataEntrega;
    private STATUS status;
    private String descricao;
    private int qtdEntrega;
    private Produto produto;

    public int getCodigoEntrega() {
        return codigoEntrega;
    }

    public void setCodigoEntrega(int codigoEntrega) {
        this.codigoEntrega = codigoEntrega;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
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

    public double calcularValorEntrega(){
        Produto prodEntrega = this.getProduto();
        return prodEntrega.getPreco() * this.getQtdEntrega();
    }

    public Entrega(int codigoEntrega, Date dataEntrega, String descricao, int qtdEntrega, Produto produto) {
        this.codigoEntrega = codigoEntrega;
        this.dataEntrega = dataEntrega;
        this.status = STATUS.PENDENTE;
        this.descricao = descricao;
        this.qtdEntrega = qtdEntrega;
        this.produto = produto;
    }
}
