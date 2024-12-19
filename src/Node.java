public class Node {

    private String data;
    private Node next;

    public Node () {
        data = null;
        next = null;
    }

    public Node(String s) {
        data = s;
    }

    public Node(String s, Node n) {
        data = s;
        next = n;
    }

    public void setData(String newData) { data = newData; }
    public void setNext(Node newNext) { next = newNext; }

    public String getData () { return data; }
    public Node getNext () { return next;}
}
