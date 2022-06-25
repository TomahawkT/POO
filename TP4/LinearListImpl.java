package TP4;

public class LinearListImpl implements LinearList {

    private Node first;
    private int size = 0;

    @Override
    public void add(Object obj) {
        Node current = first;
        if (first == null){
            first = new Node(obj,null);
            size++;
        } else{
          while(current.getTail() != null){
              current = current.getTail();
          }
          current.setTail(new Node(obj, null));
          size++;
        }
    }

    @Override
    public Object get(int i) {
        Node current = findNode(i);
        return current.getElem();
    }

    @Override
    public void set(int i, Object obj) {
        Node current = findNode(i);
        current.setElem(obj);
    }

    @Override
    public void remove(int i) {
        if (i == 0){
            first.setTail(first.getTail());
        }
        Node current = findNode(i);
        if (current != null){
            Node aux = current.getTail();
            current.setTail(current.getTail().getTail());
            size--;
        }
    }

    @Override
    public int indexOf(Object obj) {
        int idx=0;
        Node current = first;

        while(current != null && !current.getElem().equals(obj)){
            current = current.getTail();
            idx++;
        }
        return idx;
    }

    @Override
    public int size() {
        return size;
    }

    private Node findNode(int i){
        Node current = first;
        int idx = 0;

        if (i < 0){
            return null;
        }

        while (current != null && idx < i){
            idx++;
            current = current.getTail();
        }
        if (current == null){
            return null;
        }
        return current;
    }
}
