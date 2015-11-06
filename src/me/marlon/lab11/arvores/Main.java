package me.marlon.lab11.arvores;

/**
 * Created by nolram on 25/09/15.
 */
public class Main {
    public static void main(String[] args){
        // 20, 22, 12, 13, 7, 14, 8, 15, 6, 10
        Arvore<Integer> arvore = new Arvore<>();
        arvore.addObject(20);
        arvore.addObject(22);
        arvore.addObject(12);
        arvore.addObject(13);
        arvore.addObject(7);
        arvore.addObject(14);
        arvore.addObject(8);
        arvore.addObject(15);
        arvore.addObject(6);
        arvore.addObject(10);
        System.out.println(arvore);
        System.out.println(arvore.contains(10));
        System.out.println(arvore.contains(15));
        //System.out.println(arvore.getCaminhoPar());

        System.out.println("Caminhamento Pré-Ordem");
        arvore.caminhamentoPreOrdem();

        System.out.println();
        System.out.println("Caminhamento Pós-Ordem");
        arvore.caminhamentoPosOrdem();

        System.out.println();
        System.out.println("Caminhamento Ordem Central");
        arvore.caminhamentoOrdemCentral();

        System.out.println();
        arvore.printTree();
        //System.out.println(arvore.grau(arvore.returnNodo(11)));
    }
}
