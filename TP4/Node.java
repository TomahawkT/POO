package TP4;

public class Node {
    private Object elem;
    private Node tail;

    public Node(Object elem, Node tail) {
        this.elem = elem;
        this.tail = tail;
    }

    public Object getElem() {
        return elem;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
}
