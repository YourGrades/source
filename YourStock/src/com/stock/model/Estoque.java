package com.stock.model;

import com.stock.dao.EntregaDAO;
import com.stock.dao.EstoqueDAO;
import com.stock.dao.ProdutoDAO;
import com.stock.dao.RecebimentoDAO;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private static Estoque estoque;

    private List<Produto> produtos;

    private Estoque(){
        produtos = new ArrayList<>();
    }

    public static Estoque getEstoque(){
        if (estoque == null){
            estoque = new Estoque();
        }
        return estoque;
    }

    public void efetivarRecebimento(int codigoRecebe){
        Recebimento recebimento = RecebimentoDAO.selectByID(codigoRecebe);
        Produto prodReceb = ProdutoDAO.selectByID(recebimento.getCodigoProduto());
        prodReceb.setQuantidadeEstoque(recebimento.getQtdRecebe()+prodReceb.getQuantidadeEstoque());
        System.out.println("Nova quantidade: " + prodReceb.getQuantidadeEstoque());
        ProdutoDAO.updateQtd(prodReceb);
    }

    public void enviarEntrega(int codigoEntrega){
        Entrega entrega = EntregaDAO.selectByID(codigoEntrega);
        Produto prodEntrega = ProdutoDAO.selectByID(entrega.getCodigoProduto());
        prodEntrega.setQuantidadeEstoque(prodEntrega.getQuantidadeEstoque()-entrega.getQtdEntrega());
        System.out.println("Nova quantidade: "+ prodEntrega.getQuantidadeEstoque());
        ProdutoDAO.updateQtd(prodEntrega);
    }

    public void relatorioQtdPreco(){
        List<Integer> cdgProd = EstoqueDAO.getProdutoEstoque();
        List<Produto> produtos = new ArrayList<>();
        for (Integer i : cdgProd){
            produtos.add(ProdutoDAO.selectByID(i));
        }
        for (Produto p : produtos){
            System.out.println("Nome: "+ p.getNome());
            System.out.println("Quantidade em Estoque: "+ p.getQuantidadeEstoque());
            System.out.println("Preco: "+ p.getPreco());
            System.out.println("Valor Total Estoque: R$"+ p.calcularValorTotalEstoque());
            System.out.println("---------------------------------");
        }
    }
}
