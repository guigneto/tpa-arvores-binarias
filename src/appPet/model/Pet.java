package appPet.model;

import java.util.random.RandomGenerator;

public class Pet {

    private int id;
    private String nome;
    private int idade;
    private String especie;
    private String raca;

    public Pet(String nome, int idade, String especie, String raca) {
        this.id =  1 + (int)(Math.random() * 100000);
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    @Override
    public String toString() {
        return nome + " (" + raca + ", " + idade + " anos, " + especie + ")";
    }
}