package com.stock.menu;

import com.stock.dao.EntregaDAO;
import com.stock.dao.ProdutoDAO;
import com.stock.main.Main;
import com.stock.model.Entrega;
import com.stock.model.Produto;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class EntregaMenu {
    static Scanner sc = new Scanner(System.in);
    static int escolha = 0;
    static Random aux = new Random();
    private static int contador = aux.nextInt(99)+1;

    public static void menu(){

        do {
            System.out.println("---------------------------------");
            System.out.println("***** Menu Entregas *****");
            System.out.println("1. Cadastrar nova entrega");
            System.out.println("2. Consultar entregas");
            System.out.println("3. Editar uma entrega");
            System.out.println("4. Deletar uma entrega");
            System.out.println("5. Calcular valor de uma entrega");
            System.out.println("6. Atualizar Status de uma entrega");
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
                    System.out.println("Data da entrega: ");
                    sc.nextLine();
                    String data = sc.nextLine();
                    System.out.println("Descricao da entrega: ");
                    String desc = sc.nextLine();
                    System.out.println("Quantas unidades de produto na entrega: ");
                    int qtdEntrega = sc.nextInt();
                    System.out.println("Codigo do produto da entrega: ");
                    int codProd = sc.nextInt();
                    Entrega entrega = new Entrega(contador++,data,desc,qtdEntrega,codProd);
                    EntregaDAO.create(entrega);
                    System.out.println("---------------------------------");
                    break;
                case 2:
                    System.out.println("---------------------------------");
                    System.out.println("Entregas cadastradas:");
                    for (Entrega e : EntregaDAO.getEntrega()){
                        System.out.println("---------------------------------");
                        System.out.println("Codigo da Entrega: " + e.getCodigoEntrega());
                        System.out.println("Data: "+e.getDataEntrega());
                        System.out.println("Status: "+e.getStatus().toString());
                        System.out.println("Descricao: "+e.getDescricao());
                        System.out.println("Unidades: "+e.getQtdEntrega());
                        System.out.println("Codigo do Produto: "+e.getCodigoProduto());
                        System.out.println("---------------------------------");
                    }
                    break;
                case 3:
                    System.out.println("---------------------------------");
                    System.out.println("Informe o Codigo da Entrega a ser editada: ");
                    int codigoUp = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Data da entrega a ser editada: ");
                    String dataUp = sc.nextLine();
                    System.out.println("Descricao da entrega a ser editada: ");
                    String descUp = sc.nextLine();
                    System.out.println("Unidades de produto na entrega a ser editada: ");
                    int qtdEntregaUp = sc.nextInt();
                    System.out.println("Codigo do produto da entrega a ser editada: ");
                    int codProdUp = sc.nextInt();
                    Entrega upEntre = new Entrega(codigoUp,dataUp,descUp,qtdEntregaUp,codProdUp);
                    EntregaDAO.update(upEntre);
                    System.out.println("---------------------------------");
                    break;
                case 4:
                    System.out.println("---------------------------------");
                    System.out.println("Informe o Codigo da Entrega a ser deletada: ");
                    int codigoDelEntrega = sc.nextInt();
                    EntregaDAO.deleteByID(codigoDelEntrega);
                    System.out.println("---------------------------------");
                    break;
                case 5:
                    System.out.println("---------------------------------");
                    System.out.println("Informe o codigo da entrega a ser calculada: ");
                    int cdgEntr5 = sc.nextInt();
                    Entrega entrega5 = EntregaDAO.selectByID(cdgEntr5);
                    Produto prodEntreg = ProdutoDAO.selectByID(entrega5.getCodigoProduto());
                    System.out.println("Nome do Produto: "+prodEntreg.getNome());
                    System.out.println("Preco do Produto: R$"+prodEntreg.getPreco());
                    System.out.println("Unidades: "+entrega5.getQtdEntrega());
                    System.out.println("Valor total da entrega: R$"+prodEntreg.getPreco()*entrega5.getQtdEntrega());
                    System.out.println("---------------------------------");
                    break;
                case 6:
                    System.out.println("---------------------------------");
                    System.out.println("Informe o codigo da entrega para atualizar o Status: ");
                    int cdg6 = sc.nextInt();
                    Entrega entrega6 = EntregaDAO.selectByID(cdg6);
                    System.out.println("Informe o novo Status: ");
                    System.out.println("Digite 1 para ENVIADO;");
                    System.out.println("Digite 2 para ENTREGUE;");
                    int auxSt = sc.nextInt();
                    entrega6.atualizarStatus(auxSt);
                    EntregaDAO.updateStatus(entrega6);
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
