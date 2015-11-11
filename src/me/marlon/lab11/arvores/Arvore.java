package me.marlon.lab11.arvores;

import java.util.*;

/**
 * Created by nolram on 25/09/15.
 */
public class Arvore {
    private Nodo root;

    public void addObjectNonAVL(int key){
        root = addObjectNonAVL0(root, key);
    }

    private Nodo addObjectNonAVL0(Nodo nodo, int key) {
        if(nodo == null){
            return new Nodo(key);
        }
        if(key > nodo.key){
            nodo.right = addObjectNonAVL0(nodo.right, key);
        }else if(key < nodo.key){
            nodo.left = addObjectNonAVL0(nodo.left, key);
        }else{
            throw new IllegalArgumentException("Já existe um nodo com essa chave");
        }

        nodo.height = 1 + Math.max(h(nodo.left), h(nodo.right));
        return nodo;
    }


    public void addObjectAVL(int key){
        root = addObjectAVL0(root, key);
    }

    private Nodo addObjectAVL0(Nodo nodo, int key) {
        if (nodo == null) {
            return new Nodo(key);
        }
        if (key > nodo.key) {
            nodo.right = addObjectAVL0(nodo.right, key);
            if(h(nodo.left) - h(nodo.right) == -2){
                if(key>nodo.right.key){
                    nodo = rotationWithSonRight(nodo);
                }else {
                    nodo = doubleRotationWithSonRight(nodo);
                }
            }
        }else if (key<nodo.key) {
            nodo.left = addObjectAVL0(nodo.left, key);
            if(h(nodo.left) - h(nodo.right) == 2){
                if(key<nodo.left.key){
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


    private Nodo rotationWithSonRight(Nodo k1){
        Nodo k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = 1 + Math.max(h(k1.left), h(k1.right));
        k2.height = 1 + Math.max(h(k2.left), h(k2.right));
        return k2;
    }

    private Nodo doubleRotationWithSonRight(Nodo k1){
        k1.right = rotationWithSonLeft(k1.right);
        return rotationWithSonRight(k1);
    }

    private Nodo rotationWithSonLeft(Nodo k1){
        Nodo k2 = k1.left;
        k1.left = k2.right;
        k2.right = k1;
        k1.height = 1 + Math.max(h(k1.left), h(k1.right));
        k2.height = 1 + Math.max(h(k2.left), h(k2.right));
        return k2;
    }

    public Nodo doubleRotationWithSonLeft(Nodo k1){
        k1.left = rotationWithSonRight(k1.left);
        return rotationWithSonLeft(k1);
    }

    public boolean contains(int key){
        return contains0(root, key);
    }

    private boolean contains0(Nodo nodo, int key) {
        if(nodo == null){
            return false;
        }
        if(key>nodo.key){
            return contains0(nodo.right, key);
        }else if(key<nodo.key){
            return contains0(nodo.left, key);
        }
        return true;
    }

    public int h(Nodo nodo){
        return nodo == null ? -1 : nodo.height;
    }

    public Nodo returnNodo(int key){
        return returnNodo0(root, key);
    }

    private Nodo returnNodo0(Nodo nodo, int key) {
        if(nodo == null){
            return null;
        }
        if(key>nodo.key){
            return returnNodo0(nodo.right, key);
        }else if(key<nodo.key){
            return returnNodo0(nodo.left, key);
        }
        return nodo;
    }

    public int grau(Nodo nodo){
        if(nodo == null)
            return -1;

        int d = 0;

        if(nodo.left != null)
            d++;
        if(nodo.right != null)
            d++;
        return d;
    }

    public String printTreeJB(){
        return printTreeJB0(root);
    }

    private String printTreeJB0(Nodo nodo) {
        Stack<Nodo> filaAtual = new Stack<>();
        Stack<Nodo> proximaFila = new Stack<>();
        StringBuilder textTemp = new StringBuilder();
        StringBuilder textFinal = new StringBuilder();
        //String pipesNewLine = "";
        //int pipePos = 0;
        Nodo node;
        HashMap<Integer, Integer> hashPosition = fillPosition();
        int pos;
        int contASCII;
        if(nodo != null){
            filaAtual.push(nodo);
        }
        do{
            while (filaAtual.size() > 0){
                node = filaAtual.pop();
                pos = hashPosition.get(node.key);
                if(node.left != null) {
                    contASCII = hashPosition.get(node.left.key);
                    textTemp.append(stringBuilder(" ", contASCII - textTemp.length()));
                    textTemp.append("|");
                    //pipePos = textTemp.length();
                    //pipesNewLine += stringBuilder(" ", contASCII);
                    //pipesNewLine += "|";
                    textTemp.append(stringBuilder("-", pos - contASCII - 1));
                    proximaFila.push(node.left);
                } else {
                    textTemp.append(stringBuilder(" ", pos - textTemp.length()));
                }
                textTemp.append(node.key);
                if(node.right != null) {
                    contASCII = hashPosition.get(node.right.key);
                    //pipesNewLine += stringBuilder(" ", contASCII-pipesNewLine.length());
                    //pipesNewLine += "|";
                    textTemp.append(stringBuilder("-", contASCII - pos - 1));
                    textTemp.append("|");
                    proximaFila.push(node.right);
                }
            }
            //textTemp.append("\n"+pipesNewLine);
            //System.out.print(textTemp);
            textFinal.append(textTemp);
            textTemp = new StringBuilder();
            //pipesNewLine = "";
            textFinal.append("\n");
            //System.out.println();
            while (proximaFila.size() > 0){
                filaAtual.push(proximaFila.pop());
            }
        } while (filaAtual.size() > 0);
        return textFinal.toString();
    }

    public HashMap<Integer, Integer> fillPosition(){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        fillPosition0(root, 1, hashMap);
        return hashMap;
    }

    private int fillPosition0(Nodo nodo, int cont, HashMap<Integer, Integer> hashMap){
        if(nodo != null){
            cont = fillPosition0(nodo.left, cont, hashMap);
            String key = Integer.toString(nodo.key);
            cont = cont + key.length();
            hashMap.put(nodo.key, cont);
            cont = fillPosition0(nodo.right, cont, hashMap);
        }
        return cont;
    }

    public String stringBuilder(String letter, int n){
        StringBuilder texto = new StringBuilder();
        for(int i=0; i < n; i++){
            texto.append(letter);
        }
        return texto.toString();
    }

    public String printTreeE2(){
        Stack<Nodo> filaAtual = new Stack<>();
        Stack<Nodo> proximaFila = new Stack<>();
        String texto = "";
        Nodo node;
        if(root != null){
            filaAtual.add(root);
        }
        do{
            while (filaAtual.size() > 0){
                node = filaAtual.pop();
                if(node.left != null)
                    proximaFila.push(node.left);
                if(node.right != null)
                    proximaFila.push(node.right);
                texto += node.key + " ";
                //System.out.print(node.key + " ");
            }
            texto += "\n";
            //System.out.println();
            while (proximaFila.size() > 0){
                filaAtual.push(proximaFila.pop());
            }
        } while (filaAtual.size() > 0);
        return texto;
    }

    @Override
    public String toString(){
        return String.format("BinarySearchintree [root=%s]", toString0(root));
    }

    private String toString0(Nodo nodo) {
        if(nodo == null){
            return " # ";
        }
        int delta = getHeight0(nodo.left) - getHeight0(nodo.right);
        Nodo father = getFather(nodo);
        int v_father = -1;
        if(father != null){
            v_father = (Integer)father.key;
        }

        String msg = String.format(" %s degree = %d level = %d delta = %d height = %d father = %d uncle = ? %n[%s] %n[%s]",
                nodo.key, degree(nodo), level(nodo), delta, h(nodo), v_father, toString0(nodo.left),
                toString0(nodo.right));
        return msg;
    }

    private Nodo getFather(Nodo nodo){
        return getFather0(root, nodo);
    }

    private Nodo getFather0(Nodo nodo, Nodo target){
        if(nodo == null)
            return null;
        if(nodo.left != null && nodo.left.key==target.key){
            return nodo;
        }else if(nodo.right != null && nodo.right.key==target.key){
            return nodo;
        }else if(target.key<nodo.key){
            return getFather0(nodo.left, target);
        }else if(target.key>nodo.key){
            return getFather0(nodo.right, target);
        }
        return null;
    }

    private int level(Nodo nodo) {
        return level0(root, nodo, 0);
    }

    private int level0(Nodo nodo, Nodo target, int i) {
        if(target.key<nodo.key){
            return level0(nodo.left, target, i++);
        }else if(target.key>nodo.key){
            return level0(nodo.right, target, i++);
        }else {
            return i;
        }
    }

    private int degree(Nodo nodo){
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

    private int getHeight0(Nodo nodo) {
        if(nodo == null)
            return -1;
        int hl = getHeight0(nodo.left);
        int hr = getHeight0(nodo.right);
        return 1 + Math.max(hl, hr);
    }

    public void caminhamentoPreOrdem(){
        caminhamentoPreOrdem0(root);
    }

    private void caminhamentoPreOrdem0(Nodo nodo) {
        if(nodo != null) {
            System.out.print("  " + nodo.key);
            caminhamentoPreOrdem0(nodo.left);
            caminhamentoPreOrdem0(nodo.right);
        }
    }

    public void caminhamentoPosOrdem(){
        caminhamentoPosOrdem0(root);
    }

    private void caminhamentoPosOrdem0(Nodo nodo) {
        if(nodo != null){
            caminhamentoPosOrdem0(nodo.left);
            caminhamentoPosOrdem0(nodo.right);
            System.out.print("  " + nodo.key);
        }
    }

    public void caminhamentoOrdemCentral(){
        caminhamentoOrdemCentral0(root);
    }

    private void caminhamentoOrdemCentral0(Nodo nodo) {
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

    private void getCaminhoPar0(Nodo nodo, List<Nodo> caminho) {
        if(nodo != null){
            if((Integer)nodo.key % 2 == 0) {
                caminho.add(nodo);
                getCaminhoPar0(nodo.left, caminho);
                getCaminhoPar0(nodo.right, caminho);
            }
        }
    }
}
