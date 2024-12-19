// Here is all the code needed to build dfs and bfs
// methods -- fill-in the code of the two static methods
// in the application. Note all the help in the main method.

class Node {

    private int data;
    private Node next;

    public Node() {
        this(0, null);
    }

    public Node(int d) {
        this(d, null);
    }

    public Node(int d, Node n) {
        data = d;
        next = n;
    }

    public void setData(int newData) {
        data = newData;
    }

    public void setNext(Node newNext) {
        next = newNext;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void displayNode() {
        System.out.print(data);
    }
}

class LinkListADT {

    private Node first;

    public LinkListADT() {
        first = null;
    }

    public boolean empty() {
        return (first == null);
    }

    public int size() {
        int count = 0;
        Node current = first;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public void insertFirst(int newData) {
        Node newFirst = new Node(newData);
        newFirst.setNext(first);
        first = newFirst;
    }

    public Node deleteFirst() {
        if (empty()) {
            System.out.println("List is empty, nothing to delete.");
            return null;
        }
        Node temp = first;
        first = first.getNext();
        return temp;
    }

    public Node getFirst () {
        return first;
    }

    public boolean search(int key) {
        Node current = first;
        while (current != null) {
            if (current.getData() == key) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void traverse() {
        Node current = first;
        while (current != null) {
            current.displayNode();
            System.out.print(" ");
            current = current.getNext();
        }
    }
}

class LLQueueADT {

    private int size;
    private Node front;
    private Node rear;

    public LLQueueADT () {
        size = 0;
        front = null;
        rear = null;
    }

    public boolean empty () {
        return (size == 0);
    }

    public void enqueue (int number) {
        Node newNode = new Node ();
        newNode.setData(number);
        newNode.setNext(null);
        if (this.empty())
            front = newNode;
        else
            rear.setNext(newNode);
        rear = newNode;
        size++;
    }

    public int dequeue () {
        int i;
        i = front.getData();
        front = front.getNext();
        size--;
        if (this.empty())
            rear = null;
        return i;
    }

    public int front () {
        return front.getData();
    }

    public int size () {
        return size;
    }
}

class Graph {

    private LinkListADT[] adjacencyList;

    public Graph(int vertices) {
        adjacencyList = new LinkListADT[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkListADT();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].insertFirst(destination);
        adjacencyList[destination].insertFirst(source);
    }

    public LinkListADT[] getAdjacencyList() {
        return adjacencyList;
    }

    public void printGraph() {
        for (int i = 0; i < adjacencyList.length; i++) {
            System.out.print("adjacency list " + i + " : ");
            adjacencyList[i].traverse();
            System.out.println();
        }
    }
}

public class GraphExample {
    public static void main(String[] args) {
        Graph graph = new Graph(11);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 5);
        graph.addEdge(0, 9);
        graph.addEdge(1, 2);
        graph.addEdge(1, 8);
        graph.addEdge(2, 6);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.addEdge(7, 10);
        graph.printGraph();

        System.out.println("\nDepth-First Search (starting from vertex 0):");
        boolean[] visited = new boolean[graph.getAdjacencyList().length]; // Array to track visited vertices
        for (int i = 0; i <= visited.length - 1; i++)
            visited[i] = false; // Initialize all vertices as unvisited

        dfs(graph, 0, visited);

        System.out.println("\nBreadth-First Search (starting from vertex 0):");
        bfs(graph, 0);
    }

    // Recursive Depth-First Search
    public static void dfs(Graph graph, int vertex, boolean[] visited) {

        visited[vertex] = true;
        System.out.print(vertex + " ");

        Node current = graph.getAdjacencyList()[vertex].getFirst();

        while(current != null){
            if(!visited[current.getData()]){
                dfs(graph, current.getData(), visited);
            }
            current = current.getNext();
        }

    }

    // Breadth-First Search -- Iterative, uses a queue
    public static void bfs(Graph graph, int startVertex) {

        boolean[] inQueue = new boolean[graph.getAdjacencyList().length];
        LLQueueADT nodesToVisit = new LLQueueADT();

        for(int i = 0; i < graph.getAdjacencyList().length - 1; i++){
            inQueue[i] = false;
        }

        nodesToVisit.enqueue(startVertex);
        inQueue[startVertex] = true;

        while(!nodesToVisit.empty()){
            int currentVertex = nodesToVisit.dequeue();
            System.out.print(currentVertex + " ");

            Node current = graph.getAdjacencyList()[currentVertex].getFirst();

            while(current != null){
                if(!inQueue[current.getData()]){
                    inQueue[current.getData()] = true;
                    nodesToVisit.enqueue(current.getData());
                }
                current = current.getNext();
            }
        }
    }
}