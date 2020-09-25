package src.graph;

import java.util.HashMap;

public class Node<D> {
    D data ;
    int id ;
    HashMap<Integer, Node<D>> inNods;
    HashMap<Integer, Node<D>> outNods;
    Node(D data){
        this.data=data;
        inNods = new HashMap<>();
        outNods = new HashMap<>();
    }
}
