package lib;

import java.util.Comparator;

public class ArvoreBinaria<T> implements IArvoreBinaria<T>{

    protected No<T> raiz = null;
    protected Comparator<T> comparador;

    public ArvoreBinaria(Comparator<T> comp) {
        comparador = comp;
    }

    @Override
    public void adicionar(Object novoValor) {
        T valor = (T) novoValor;
        raiz = inserirRecursivo(raiz, valor);
    }

    private No<T> inserirRecursivo(No<T> atual, T valor) {
        if (atual == null) {
            return new No<>(valor);
        }

        int cmp = comparador.compare(valor, atual.getValor());

        if (cmp < 0) {
            atual.setFilhoEsquerda(inserirRecursivo(atual.getFilhoEsquerda(), valor));
        } else if (cmp > 0) {
            atual.setFilhoDireita(inserirRecursivo(atual.getFilhoDireita(), valor));
        } // se cmp == 0, valor duplicado — vamo tratar ou não?

        return atual;
    }

    @Override
    public Object pesquisar(Object valor) {
        return null;
    }

    @Override
    public Object pesquisar(Object valor, Comparator comparador) {
        return null;
    }

    @Override
    public Object remover(Object valor) {
        return null;
    }

    @Override
    public int altura() {
        return calcularAltura(raiz);
    }

    public int calcularAltura(No<T> no){
        if (no == null) return 0; // altura de árvore vazia = 0
        int alturaEsquerda = calcularAltura(no.getFilhoEsquerda());
        int alturaDireita = calcularAltura(no.getFilhoDireita());
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    @Override
    public int quantidadeNos() {
        return contarNos(raiz);
    }

    private int contarNos(No<T> no) {
        if (no == null) return 0;
        return 1 + contarNos(no.getFilhoEsquerda()) + contarNos(no.getFilhoDireita());
    }

    @Override
    public String caminharEmNivel() {
        return "";
    }

    @Override
    public String caminharEmOrdem() {
        return "";
    }
}
