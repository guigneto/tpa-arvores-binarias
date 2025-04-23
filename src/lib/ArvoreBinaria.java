package lib;
import java.util.Queue;
import java.util.LinkedList;

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
        T val = (T) valor;
        return pesquisarRecursivo(raiz, val);
    }

    private T pesquisarRecursivo(No<T> atual, T valor) {
        if (atual == null) return null;

        int cmp = comparador.compare(valor, atual.getValor());

        if (cmp == 0) {
            return atual.getValor();
        } else if (cmp < 0) {
            return pesquisarRecursivo(atual.getFilhoEsquerda(), valor);
        } else {
            return pesquisarRecursivo(atual.getFilhoDireita(), valor);
        }
    }

    @Override
    public Object pesquisar(Object valor, Comparator comp) {
        T val = (T) valor;
        return pesquisarComComparator(raiz, val, comp);
    }

    private T pesquisarComComparator(No<T> atual, T valor, Comparator comp) {
        if (atual == null) return null;

        int cmp = comp.compare(valor, atual.getValor());

        if (cmp == 0) {
            return atual.getValor();
        } else if (cmp < 0) {
            return pesquisarComComparator(atual.getFilhoEsquerda(), valor, comp);
        } else {
            return pesquisarComComparator(atual.getFilhoDireita(), valor, comp);
        }
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
        if (raiz == null) return "";

        StringBuilder resultado = new StringBuilder();
        Queue<No<T>> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No<T> atual = fila.poll();
            resultado.append(atual.getValor()).append(" ");

            if (atual.getFilhoEsquerda() != null) fila.add(atual.getFilhoEsquerda());
            if (atual.getFilhoDireita() != null) fila.add(atual.getFilhoDireita());
        }

        return resultado.toString().trim();
    }


    @Override
    public String caminharEmOrdem() {
        StringBuilder resultado = new StringBuilder();
        caminharEmOrdem(raiz, resultado);
        return resultado.toString().trim(); // remove o espaço no fim
    }

    private void caminharEmOrdem(No<T> no, StringBuilder sb) {
        if (no != null) {
            caminharEmOrdem(no.getFilhoEsquerda(), sb);
            sb.append(no.getValor()).append(" ");
            caminharEmOrdem(no.getFilhoDireita(), sb);
        }
    }

}
