package com.stock.menu;

import com.stock.dao.ProdutoDAO;
import com.stock.main.Main;
import com.stock.model.Produto;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ProdutoMenu {
    static Scanner sc = new Scanner(System.in);
    static int escolha = 0;
    static Random aux = new Random();
    private static int contador = aux.nextInt(99)+1;

    public static void menu(){

        do {
            System.out.println("---------------------------------");
            System.out.println("***** Menu Produto *****");
            System.out.println("1. Cadastrar novo produto");
            System.out.println("2. Consultar produtos");
            System.out.println("3. Editar um produto");
            System.out.println("4. Deletar um produto");
            System.out.println("5. Retornar ao menu inicial"); //voltar ao menu principal (transformar em metodo)
            System.out.println("Digite a sua escolha: ");
            try {
                escolha = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                sc.nextLine();
                escolha = 0;
            }
            switch (escolha) {
                case 1:
                    System.out.println("---------------------------------");
                    System.out.println("Favor informar os seguintes dados:");
                    System.out.println("Nome do produto: ");
                    sc.nextLine();
                    String nome = sc.nextLine();
                    System.out.println("Descricao do produto: ");
                    String desc = sc.nextLine();
                    System.out.println("Preco do produto: ");
                    double preco = sc.nextDouble();
                    System.out.println("Categoria do produto: ");
                    sc.nextLine();
                    String categoria = sc.nextLine();
                    System.out.println("Quantidade inicial do estoque: ");
                    int qtdEstoque = sc.nextInt();
                    System.out.println("Codigo do fornecedor do produto: ");
                    int codigoForne = sc.nextInt();
                    Produto produto = new Produto(contador++,nome,desc,preco,categoria,qtdEstoque,codigoForne);
                    ProdutoDAO.create(produto);
                    System.out.println("---------------------------------");
                    break;
                case 2:
                    System.out.println("---------------------------------");
                    System.out.println("Produtos cadastrados:");
                    for (Produto p : ProdutoDAO.getProduto()){
                        System.out.println("---------------------------------");
                        System.out.println("Codigo: " + p.getCodigoProduto());
                        System.out.println("Nome: " + p.getNome());
                        System.out.println("Descricao: " + p.getDescricao());
                        System.out.println("Preco: R$" + p.getPreco());
                        System.out.println("Categoria: "+ p.getCategoria());
                        System.out.println("Quantidade em estoque: "+ p.getQuantidadeEstoque());
                        System.out.println("Codigo fornecedor: "+ p.getCodigoFornecedor());
                        System.out.println("---------------------------------");
                    }
                    break;
                case 3:
                    System.out.println("---------------------------------");
                    System.out.println("Informe o Codigo do Produto a ser editado: ");
                    int codigoUp = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nome do produto a ser editado: ");
                    String nomeUp = sc.nextLine();
                    System.out.println("Descricao do produto a ser editado: ");
                    String descUp = sc.nextLine();
                    System.out.println("Preco do produto a ser editado: ");
                    double precoUp = sc.nextDouble();
                    System.out.println("Categoria do produto a ser editado: ");
                    sc.nextLine();
                    String categoriaUp = sc.nextLine();
                    System.out.println("Quantidade do estoque a ser editado: ");
                    int qtdEstoqueUp = sc.nextInt();
                    System.out.println("Codigo do fornecedor do produto a ser editado: ");
                    int codigoForneUp = sc.nextInt();
                    Produto upProd = new Produto(codigoUp,nomeUp,descUp,precoUp,categoriaUp,qtdEstoqueUp,codigoForneUp);
                    ProdutoDAO.update(upProd);
                    System.out.println("---------------------------------");
                    break;
                case 4:
                    System.out.println("---------------------------------");
                    System.out.println("Informe o Codigo do Produto a ser deletado: ");
                    int codigoDelProd = sc.nextInt();
                    ProdutoDAO.deleteByID(codigoDelProd);
                    System.out.println("---------------------------------");
                    break;
                case 5:
                    Main.menuMain();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 10);

    }
}
