package com.stock.main;

import com.stock.menu.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        menuMain();

    }
    public static void menuMain(){
        int escolha = 0;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.println("---------------------------------");
                System.out.println("***** Bem Vindo ao Sistema YourStock *****");
                System.out.println("1. Menu Fornecedores");
                System.out.println("2. Menu Produtos");
                System.out.println("3. Menu Entregas");
                System.out.println("4. Menu Recebimentos");
                System.out.println("5. Menu Estoque");
                System.out.println("6. Sair");
                System.out.println("S2 fornecedor -> produto -> entrega -> recebimento2 -> estoque S2");
                System.out.println("Digite a sua escolha: ");
                escolha = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            switch (escolha) {
                case 1:
                    FornecedorMenu.menu();
                    break;
                case 2:
                    ProdutoMenu.menu();
                    break;
                case 3:
                    EntregaMenu.menu();
                    break;
                case 4:
                    RecebimentoMenu.menu();
                    break;
                case 5:
                    EstoqueMenu.menu();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 10);
    }
}
