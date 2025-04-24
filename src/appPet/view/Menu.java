package appPet.view;

import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public static int exibirMenu() {
        System.out.println("\n==== Sistema de Adoção de Pets ====");
        System.out.println("1. Adicionar pet");
        System.out.println("2. Pesquisar pet por nome");
        System.out.println("3. Remover pet");
        System.out.println("4. Listar pets em ordem");
        System.out.println("5. Listar pets por nível");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
