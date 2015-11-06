package me.marlon.lab11.arvores;

/**
 * Created by nolram on 25/09/15.
 */
public class Nodo<T> {
    public T key;
    public Nodo<T> left;
    public Nodo<T> right;
    public Nodo<T> father;
    public int height;

    public Nodo(T key){
        this.key = key;
        this.height = 0;
        left = right = father = null;
    }

    public Nodo(){
        this.key = null;
        this.height = 0;
        left = right = father = null;
    }

    public String toString(){
        if(key != null)
            return key.toString();
        else
            return Integer.toString(-1);
    }
}
