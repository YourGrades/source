package com.stock.menu;

import com.stock.dao.RecebimentoDAO;
import com.stock.main.Main;
import com.stock.model.Recebimento;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RecebimentoMenu {
    static Scanner sc = new Scanner(System.in);
    static int escolha = 0;
    static Random aux = new Random();
    private static int contador = aux.nextInt(99)+1;

    public static void menu(){

        do {
            System.out.println("---------------------------------");
            System.out.println("***** Menu Recebimentos *****");
            System.out.println("1. Cadastrar novo Recebimento");
            System.out.println("2. Consultar Recebimentos");
            System.out.println("3. Editar um Recebimento");
            System.out.println("4. Deletar um Recebimento");
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
                    System.out.println("Descricao do Recebimento: ");
                    sc.nextLine();
                    String desc = sc.nextLine();
                    System.out.println("Unidades do Produto: ");
                    int qtdReceb = sc.nextInt();
                    System.out.println("Codigo do Produto: ");
                    int codigoProd = sc.nextInt();
                    Recebimento recebimento = new Recebimento(contador++,desc,qtdReceb,codigoProd);
                    RecebimentoDAO.create(recebimento);
                    System.out.println("---------------------------------");
                    break;
                case 2:
                    System.out.println("---------------------------------");
                    System.out.println("Recebimentos cadastrados:");
                    for (Recebimento r : RecebimentoDAO.getRecebimento()){
                        System.out.println("---------------------------------");
                        System.out.println("Codigo Recebimento: " + r.getCodigoRecebimento());
                        System.out.println("Descricao: "+r.getDescricao());
                        System.out.println("Unidades: "+r.getQtdRecebe());
                        System.out.println("Codigo Produto: "+r.getCodigoProduto());
                        System.out.println("---------------------------------");
                    }
                    break;
                case 3:
                    System.out.println("---------------------------------");
                    System.out.println("Codigo do Recebimento a ser editado: ");
                    int codigoUp = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Descricao do Recebimento a ser editado: ");
                    String descUp = sc.nextLine();
                    System.out.println("Unidades do Produto a ser editado: ");
                    int qtdRecebUp = sc.nextInt();
                    System.out.println("Codigo do Produto a ser editado: ");
                    int codigoProdUp = sc.nextInt();
                    Recebimento recebUp = new Recebimento(codigoUp,descUp,qtdRecebUp,codigoProdUp);
                    RecebimentoDAO.update(recebUp);
                    System.out.println("---------------------------------");
                    break;
                case 4:
                    System.out.println("---------------------------------");
                    System.out.println("Informe o Codigo do Recebimento a ser deletado: ");
                    int codigoDelReceb = sc.nextInt();
                    RecebimentoDAO.deleteByID(codigoDelReceb);
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
