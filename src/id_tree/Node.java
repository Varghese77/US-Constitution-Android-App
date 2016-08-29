package id_tree;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Node implements Serializable {

    private int id;
    private int size;
    private Node[] nodes;

    public Node(int branches){
        this(branches, 0);
    }

    public Node(int branches, int id){
        this.id = id;
        this.size = 0;
        nodes = new Node[branches];
    }

    public boolean hasID(){
        return id != 0;
    }

    public int getID() {
        if (!hasID()){
            throw new IllegalStateException();
        }
        return id;
    }

    public int length(){
        return nodes.length;
    }

    private int size(){
        return this.size;
    }

    public Node get(int i){
        if ((i + 1) > length()){
            throw new IllegalStateException();
        }
        return nodes[i];
    }

    public void set(int i, Node node){
        if ((i + 1) > length()){
            throw new IllegalStateException();
        }
        nodes[i] = node;
    }

    public void add(Node node){
        set(size, node);
        size++;
    }
}
