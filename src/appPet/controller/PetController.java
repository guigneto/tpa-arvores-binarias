package appPet.controller;

import lib.ArvoreBinaria;
import appPet.model.Pet;
import appPet.model.NomeComparador;
import appPet.view.Menu;

import java.util.Scanner;

public class PetController {

    private ArvoreBinaria<Pet> arvore;
    private Scanner scanner;

    public PetController() {
        this.arvore = new ArvoreBinaria<>(new NomeComparador());
        this.scanner = new Scanner(System.in);
    }

    public void executar() {
        int opcao;
        do {
            opcao = Menu.exibirMenu();

            switch (opcao) {
                case 1 -> adicionarPet();
                case 2 -> pesquisarPetPorNome();
                case 3 -> removerPet();
                case 4 -> listarPetsEmOrdem();
                case 5 -> listarPetsPorNivel();
                case 0 -> System.out.println("Encerrando o programa. Até logo!");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    public void adicionarPet() {
        System.out.print("Nome do pet: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.print("Espécie: ");
        String especie = scanner.nextLine();

        System.out.print("Raça: ");
        String raca = scanner.nextLine();

        Pet novoPet = new Pet(nome, idade, especie, raca);
        arvore.adicionar(novoPet);
        System.out.println("Pet adicionado com sucesso!");
    }

    public void pesquisarPetPorNome() {
        System.out.print("Digite o nome do pet para pesquisar: ");
        String nome = scanner.nextLine();

        Pet dummy = new Pet(nome, 0, "", "");
        Pet encontrado = (Pet) arvore.pesquisar(dummy);

        if (encontrado != null) {
            System.out.println("Pet encontrado: " + encontrado);
        } else {
            System.out.println("Pet não encontrado.");
        }
    }

    public void removerPet() {
        System.out.print("Digite o nome do pet para remover: ");
        String nome = scanner.nextLine();

        Pet dummy = new Pet(nome, 0, "", "");
        Pet removido = (Pet) arvore.remover(dummy);

        System.out.println("Tentando remover: " + nome);
        if (removido != null) {
            System.out.println("Pet removido com sucesso.");
        } else {
            System.out.println("Pet não encontrado.");
        }
    }

    public void listarPetsEmOrdem() {
        System.out.println("Pets em ordem (alfabética):");
        System.out.println(arvore.caminharEmOrdem());
    }

    public void listarPetsPorNivel() {
        System.out.println("Pets por nível (em largura):");
        System.out.println(arvore.caminharEmNivel());
    }
}
