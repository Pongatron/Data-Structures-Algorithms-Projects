public class QueueADT {

    private int size;
    private Node front;
    private Node rear;

    public QueueADT () {
        size = 0;
        front = null;
        rear = null;
    }

    public boolean empty () {
        return (size == 0);
    }

    public int size () {
        return size;
    }

    public void enqueue (String s) {
        Node newNode = new Node ();
        newNode.setData(s);
        newNode.setNext(null);
        if (this.empty())
            front = newNode;
        else
            rear.setNext(newNode);
        rear = newNode;
        size++;
    }

    public String dequeue () {
        String s;
        s = front.getData();
        front = front.getNext();
        size--;
        if (this.empty())
            rear = null;
        return s;
    }

    public String front () {
        return front.getData();
    }


}
