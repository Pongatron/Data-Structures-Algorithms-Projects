public class StackADT {

    private Node top;
    private int size;

    public StackADT () {
        top = null;
        size = 0;
    }

    public boolean empty () {
        return (top == null);
    }

    public int size () {
        return size;
    }

    public void push (String s) {
        Node newNode = new Node ();
        newNode.setData(s);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public String pop () {
        String s;
        s = top.getData();
        top = top.getNext();
        size--;
        return s;
    }

    public String ontop () {
        return top.getData();
    }
}
