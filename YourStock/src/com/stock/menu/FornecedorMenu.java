package com.stock.menu;

import com.stock.dao.FornecedorDAO;
import com.stock.main.Main;
import com.stock.model.Fornecedor;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class FornecedorMenu {

    static Scanner sc = new Scanner(System.in);
    static int escolha = 0;
    static Random aux = new Random();
    private static int contador = aux.nextInt(99)+1;

    public static void menu(){

        do {
            System.out.println("---------------------------------");
            System.out.println("***** Menu Fornecedores *****");
            System.out.println("1. Cadastrar novo fornecedor");
            System.out.println("2. Consultar fornecedores");
            System.out.println("3. Editar um fornecedor");
            System.out.println("4. Deletar um fornecedor");
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
                    System.out.println("Nome do fornecedor: ");
                    sc.nextLine();
                    String nome = sc.nextLine();
                    System.out.println("Email do fornecedor: ");
                    String email = sc.nextLine();
                    System.out.println("Telefone do fornecedor: ");
                    String telefone = sc.nextLine();
                    Fornecedor fornecedor = new Fornecedor(contador++,nome,email,telefone);
                    FornecedorDAO.create(fornecedor);
                    System.out.println("---------------------------------");
                    break;
                case 2:
                    System.out.println("---------------------------------");
                    System.out.println("Fornecedores cadastrados:");
                    for (Fornecedor f : FornecedorDAO.getFornecedor()){
                        System.out.println("---------------------------------");
                        System.out.println("Codigo Fornecedor: " + f.getCodigoFornecedor());
                        System.out.println("Nome: "+f.getNome());
                        System.out.println("Email: "+f.getEmail());
                        System.out.println("Telefone: "+f.getTelefone());
                        System.out.println("---------------------------------");
                    }
                    break;
                case 3:
                    System.out.println("---------------------------------");
                    System.out.println("Codigo do Fornecedor a ser editado: ");
                    int codigoUp = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nome do Fornecedor a ser editado: ");
                    String nomeUp = sc.nextLine();
                    System.out.println("Email do Fornecedor a ser editado: ");
                    String emailUp = sc.nextLine();
                    System.out.println("Telefone do Fornecedor a ser editado: ");
                    String telefoneUp = sc.nextLine();
                    Fornecedor upForne = new Fornecedor(codigoUp,nomeUp,emailUp,telefoneUp);
                    FornecedorDAO.update(upForne);
                    System.out.println("---------------------------------");
                    break;
                case 4:
                    System.out.println("---------------------------------");
                    System.out.println("Informe o Codigo do Fornecedor a ser deletado: ");
                    int codigoDelForn = sc.nextInt();
                    FornecedorDAO.deleteByID(codigoDelForn);
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
