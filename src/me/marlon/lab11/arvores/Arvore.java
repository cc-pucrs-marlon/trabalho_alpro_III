package me.marlon.lab11.arvores;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by nolram on 25/09/15.
 */
public class Arvore <T extends Comparable<T>> {
    private Nodo<T> root;

    public void addObject(T key){
        root = addObject0(root, key);
    }

    private Nodo<T> addObject0(Nodo<T> nodo, T key) {
        if (nodo == null) {
            return new Nodo<T>(key);
        }
        if (key.compareTo(nodo.key) > 0) {
            nodo.right = addObject0(nodo.right, key);
            if(h(nodo.left) - h(nodo.right) == -2){
                if(key.compareTo(nodo.right.key) > 0){
                    nodo = rotationWithSonRight(nodo);
                }else {
                    nodo = doubleRotationWithSonRight(nodo);
                }
            }
        }else if (key.compareTo(nodo.key) < 0) {
            nodo.left = addObject0(nodo.left, key);
            if(h(nodo.left) - h(nodo.right) == 2){
                if(key.compareTo(nodo.left.key) < 0){
                    nodo = rotationWithSonLeft(nodo);
                }else {
                    nodo = doubleRotationWithSonLeft(nodo);
                }
            }
        }else{
            throw new IllegalArgumentException("Já existe um nodo com essa chave");
        }
        nodo.height = 1 + Math.max(h(nodo.left), h(nodo.right));
        return nodo;
    }


    private Nodo<T> rotationWithSonRight(Nodo<T> k1){
        Nodo<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = 1 + Math.max(h(k1.left), h(k1.right));
        k2.height = 1 + Math.max(h(k2.left), h(k2.right));
        return k2;
    }

    private Nodo<T> doubleRotationWithSonRight(Nodo<T> k1){
        k1.right = rotationWithSonLeft(k1.right);
        return rotationWithSonRight(k1);
    }

    private Nodo<T> rotationWithSonLeft(Nodo<T> k1){
        Nodo<T> k2 = k1.left;
        k1.left = k2.right;
        k2.right = k1;
        k1.height = 1 + Math.max(h(k1.left), h(k1.right));
        k2.height = 1 + Math.max(h(k2.left), h(k2.right));
        return k2;
    }

    public Nodo<T> doubleRotationWithSonLeft(Nodo<T> k1){
        k1.left = rotationWithSonRight(k1.left);
        return rotationWithSonLeft(k1);
    }

    public boolean contains(T key){
        return contains0(root, key);
    }

    private boolean contains0(Nodo<T> nodo, T key) {
        if(nodo == null){
            return false;
        }
        if(key.compareTo(nodo.key) > 0){
            return contains0(nodo.right, key);
        }else if(key.compareTo(nodo.key) < 0){
            return contains0(nodo.left, key);
        }
        return true;
    }

    public int h(Nodo<T> nodo){
        return nodo == null ? -1 : nodo.height;
    }

    public Nodo<T> returnNodo(T key){
        return returnNodo0(root, key);
    }

    private Nodo<T> returnNodo0(Nodo<T> nodo, T key) {
        if(nodo == null){
            return null;
        }
        if(key.compareTo(nodo.key) > 0){
            return returnNodo0(nodo.right, key);
        }else if(key.compareTo(nodo.key) < 0){
            return returnNodo0(nodo.left, key);
        }
        return nodo;
    }

    public int grau(Nodo<T> nodo){
        if(nodo == null)
            return -1;

        int d = 0;

        if(nodo.left != null)
            d++;
        if(nodo.right != null)
            d++;
        return d;
    }

    public void printTree(){
        Queue<Nodo> filaAtual = new ArrayDeque<>();
        Queue<Nodo> proximaFila = new ArrayDeque<>();
        Nodo node;
        if(root != null){
            filaAtual.add(root);
        }
        do{
            while (filaAtual.size() > 0){
                node = filaAtual.poll();
                if(node.left != null)
                    proximaFila.offer(node.left);
                if(node.right != null)
                    proximaFila.offer(node.right);
                System.out.print(node.key + " ");
            }
            System.out.println();
            while (proximaFila.size() > 0){
                filaAtual.offer(proximaFila.poll());
            }
        } while (filaAtual.size() > 0);

    }

    @Override
    public String toString(){
        return String.format("BinarySearchTree [root=%s]", toString0(root));
    }

    private String toString0(Nodo nodo) {
        if(nodo == null){
            return " # ";
        }
        int delta = getHeight0(nodo.left) - getHeight0(nodo.right);
        Nodo<T> father = getFather(nodo);
        int v_father = -1;
        if(father != null){
            v_father = (Integer)father.key;
        }

        String msg = String.format(" %s degree = %d level = %d height = %d delta = %d father = %d uncle = ? %n[%s] %n[%s]",
                nodo.key, degree(nodo), level(nodo), h(nodo), delta, v_father, toString0(nodo.left),
                toString0(nodo.right));
        return msg;
    }

    private Nodo<T> getFather(Nodo<T> nodo){
        return getFather0(root, nodo);
    }

    private Nodo<T> getFather0(Nodo<T> nodo, Nodo<T> target){
        if(nodo == null)
            return null;
        if(nodo.left != null && nodo.left.key.compareTo(target.key) == 0){
            return nodo;
        }else if(nodo.right != null && nodo.right.key.compareTo(target.key) == 0){
            return nodo;
        }else if(target.key.compareTo(nodo.key) < 0){
            return getFather0(nodo.left, target);
        }else if(target.key.compareTo(nodo.key) > 0){
            return getFather0(nodo.right, target);
        }
        return null;
    }

    private int level(Nodo<T> nodo) {
        return level0(root, nodo, 0);
    }

    private int level0(Nodo<T> nodo, Nodo<T> target, int i) {
        if(target.key.compareTo(nodo.key) < 0){
            return level0(nodo.left, target, i++);
        }else if(target.key.compareTo(nodo.key) > 0){
            return level0(nodo.right, target, i++);
        }else {
            return i;
        }
    }

    private int degree(Nodo<T> nodo){
        if(nodo == null)
            return -1;
        int d = 0;
        if(nodo.left != null)
            d++;
        if(nodo.right != null)
            d++;
        return d;
    }

    public int getHeight(){
        return getHeight0(root);
    }

    private int getHeight0(Nodo<T> nodo) {
        if(nodo == null)
            return -1;
        int hl = getHeight0(nodo.left);
        int hr = getHeight0(nodo.right);
        return 1 + Math.max(hl, hr);
    }

    public void caminhamentoPreOrdem(){
        caminhamentoPreOrdem0(root);
    }

    private void caminhamentoPreOrdem0(Nodo<T> nodo) {
        if(nodo != null) {
            System.out.print("  " + nodo.key);
            caminhamentoPreOrdem0(nodo.left);
            caminhamentoPreOrdem0(nodo.right);
        }
    }

    public void caminhamentoPosOrdem(){
        caminhamentoPosOrdem0(root);
    }

    private void caminhamentoPosOrdem0(Nodo<T> nodo) {
        if(nodo != null){
            caminhamentoPosOrdem0(nodo.left);
            caminhamentoPosOrdem0(nodo.right);
            System.out.print("  " + nodo.key);
        }
    }

    public void caminhamentoOrdemCentral(){
        caminhamentoOrdemCentral0(root);
    }

    private void caminhamentoOrdemCentral0(Nodo<T> nodo) {
        if(nodo != null){
            caminhamentoOrdemCentral0(nodo.left);
            System.out.print("  " + nodo.key);
            caminhamentoOrdemCentral0(nodo.right);
        }
    }

    public List<Nodo> getCaminhoPar(){
        List<Nodo> caminho = new ArrayList<>();
        getCaminhoPar0(root, caminho);
        return caminho;
    }

    private void getCaminhoPar0(Nodo<T> nodo, List<Nodo> caminho) {
        if(nodo != null){
            if((Integer)nodo.key % 2 == 0) {
                caminho.add(nodo);
                getCaminhoPar0(nodo.left, caminho);
                getCaminhoPar0(nodo.right, caminho);
            }
        }
    }
}
