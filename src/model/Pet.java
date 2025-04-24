package model;

public class Pet {

    private String nome;
    private int idade;
    private String especie;
    private String raca;

    public Pet(String nome, int idade, String especie, String raca) {
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