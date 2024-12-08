package com.stock.menu;

import com.stock.dao.EstoqueDAO;
import com.stock.dao.ProdutoDAO;
import com.stock.main.Main;
import com.stock.model.Estoque;
import com.stock.model.Produto;

import java.util.*;

public class EstoqueMenu {
    static Scanner sc = new Scanner(System.in);
    static int escolha = 0;
    static Random aux = new Random();
    private static int contador = aux.nextInt(99)+1;

    public static void menu(){

        do {
            System.out.println("---------------------------------");
            System.out.println("***** Menu Estoque *****");
            System.out.println("1. Cadastrar novo Produto no Estoque");
            System.out.println("2. Consultar Produtos no Estoque");
            System.out.println("3. Efetivar um Recebimento");
            System.out.println("4. Enviar uma Entrega");
            System.out.println("5. Relatorio de Quantidade X Preco");
            System.out.println("6. Remover Produto do estoque");
            System.out.println("7. Retornar ao menu inicial");
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
                    System.out.println("Codigo do Produto: ");
                    int codigoProd = sc.nextInt();
                    EstoqueDAO.create(ProdutoDAO.selectByID(codigoProd));
                    System.out.println("---------------------------------");
                    break;
                case 2:
                    System.out.println("---------------------------------");
                    System.out.println("Produtos cadastrados:");
                    for (Integer i : EstoqueDAO.getProdutoEstoque()){
                        Produto p = ProdutoDAO.selectByID(i);
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
                    System.out.println("Informar codigo do Recebimento: ");
                    int codigoReceb = sc.nextInt();
                    Estoque.getEstoque().efetivarRecebimento(codigoReceb);
                    System.out.println("---------------------------------");
                    break;
                case 4:
                    System.out.println("---------------------------------");
                    System.out.println("Informar codigo da Entrega: ");
                    int codigoEntrega = sc.nextInt();
                    Estoque.getEstoque().enviarEntrega(codigoEntrega);
                    System.out.println("---------------------------------");
                    break;
                case 5:
                    System.out.println("---------------------------------");
                    System.out.println("Relatorio por produto: ");
                    Estoque.getEstoque().relatorioQtdPreco();
                    System.out.println("---------------------------------");
                    break;
                case 6:
                    System.out.println("---------------------------------");
                    System.out.println("Informar codigo do Produto a ser REMOVIDO do estoque: ");
                    int codProdDel = sc.nextInt();
                    EstoqueDAO.deleteByID(codProdDel);
                    System.out.println("---------------------------------");
                break;
                case 7:
                    Main.menuMain();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 10);


    }
}
