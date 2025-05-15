# Trabalho de Árvores Binárias - Etapa 1

## Disciplina: Técnicas de Programação Avançada

## Objetivo

Desenvolver uma **biblioteca de Árvores Binárias** em Java com suporte a **Generics** e **Comparator**, permitindo armazenar objetos de qualquer tipo e possibilitando diferentes formas de indexação para o mesmo tipo de objeto.

# 🐾 AppPet - Sistema de Adoção com Árvore Binária

Este é um sistema simples de gerenciamento de pets para adoção, desenvolvido em Java com base na estrutura de uma **árvore binária de busca (BST)**. O projeto segue o padrão **MVC (Model-View-Controller)** para uma melhor organização e separação de responsabilidades.

## 📌 Funcionalidades

- Adicionar pets à árvore binária.
- Buscar pets pelo nome e ID.
- Remover pets.
- Exibir os pets em ordem (in-order) ou por nível.

## 🚀 Como executar

1. Compile os arquivos com:

```bash
javac appPet/app/Main.java
```

2. Execute o programa:

```bash
java appPet.app.Main
```

## 🧠 Estrutura do Projeto

```
appPet/
│
├── app/
│   └── Main.java               # Classe principal (ponto de entrada do sistema)
│
├── controller/
│   └── PetController.java      # Controlador responsável pela lógica de negócio
│
├── model/
│   ├── Pet.java                # Classe que representa os pets
│   ├── IdComparador.java       # Comparador por ID
│   └── NomeComparador.java     # Comparador por nome
│
└── view/
    └── Menu.java               # Responsável pela interface de texto com o usuário

```

## 👨‍💻 Autores

- Guilherme Gomes de Faria Neto
- Manuely Meireles Lemos