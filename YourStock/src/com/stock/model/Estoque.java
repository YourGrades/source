package com.stock.model;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private static Estoque estoque;

    private List<Produto> produtos;
    private List<Recebimento> recebimentos;
    private List<Entrega> entregas;

    private Estoque(){
        produtos = new ArrayList<>();
        recebimentos = new ArrayList<>();

    }

    public static Estoque getEstoque(){
        if (estoque == null){
            estoque = new Estoque();
        }
        return estoque;
    }

    public void adicionarProduto(Produto produto){
        this.produtos.add(produto);
    }

    public void efetivarRecebimento(Recebimento recebimento){
        Produto prodRecebido = recebimento.getProduto();
        int qtd = recebimento.getQtdRecebe();
        prodRecebido.atualizarQuantidade(qtd);
    }

    public void enviarEntrega(Entrega entrega){
        Produto prodEnviado = entrega.getProduto();
        int qtd = entrega.getQtdEntrega();
        prodEnviado.atualizarQuantidade(-qtd);
    }

    public Produto consultarProdutoPorCodigo(int codigoProduto){
        for (Produto produto : this.produtos){
            if (produto.getCodigoProduto() == codigoProduto){
                return produto;
            }
        }
        return null;
    }

    public void listarProdutos(){
        for (Produto produto : this.produtos){
            System.out.println(produto.toString());
        }
    }

    public Produto listarProdutoPorFornecedor(Fornecedor fornecedor){
        for (Produto produto : this.produtos){
            if (produto.getFornecedor().equals(fornecedor)) {
                return produto;
            }
        }
        return null;
    }

    public void excluirProduto(Produto produto){
        produto.setQuantidadeEstoque(0);
        this.produtos.remove(produto);
        //remover produto da tabela do estoque
    }

    public void relatorioQtdPreco(){
        for (Produto produto : this.produtos){
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Unidades no estoque: " + produto.getQuantidadeEstoque());
            System.out.println("Valor unitario: R$" + produto.getPreco());
            System.out.println("Valor total: R$" + produto.calcularValorTotalEstoque());
        }
    }
}
