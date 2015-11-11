package me.marlon.lab11.arvores;

/**
 * Created by nolram on 25/09/15.
 */
public class Nodo {
    public int key;
    public Nodo left;
    public Nodo right;
    public Nodo father;
    public int height;

    public Nodo(int key){
        this.key = key;
        this.height = 0;
        left = right = father = null;
    }

    public Nodo(){
        this.key = 0;
        this.height = 0;
        left = right = father = null;
    }

    public String toString(){
        return Integer.toString(this.key);
    }
}
