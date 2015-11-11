package me.marlon.lab11.arvores;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nolram on 25/09/15.
 */
public class Main {
    public static void main(String[] args){
        //26280332316429735373115199276325346367241431922202903181031171206255452343852241
        Arvore arvore = new Arvore();
        int valores[] = {262,80,332,3,164,297,353,73,115,199,276,325,346,367,24,143,192,220,290,
                318,10,31,171,206,255,45,234,38,52,241};
        for (int i=0; i<valores.length; i++){
            arvore.addObjectNonAVL(valores[i]);
        }
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
        System.out.println();
        System.out.println();
        arvore.printTreeJB();
        //System.out.println(arvore.grau(arvore.returnNodo(11)));
    }
}
