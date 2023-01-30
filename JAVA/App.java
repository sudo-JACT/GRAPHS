import java.util.ArrayList;
import java.util.List;

public class App {
    
    
    public static void main(String[] args) {
       
        List graph = new ArrayList<Node>();
        int nofnodes = 6;

        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        Node n4 = new Node("D");
        Node n5 = new Node("E");
        Node n6 = new Node("F");

        n1.addToNode(n2, 1);
        n1.addToNode(n6, 3);

        n2.addToNode(n3, 3);
        n2.addToNode(n6, 1);
        n2.addToNode(n5, 5);

        n3.addToNode(n4, 2);

        n5.addToNode(n4, 1);

        n6.addToNode(n5, 2);

        graph.add(n1);
        graph.add(n2);
        graph.add(n3);
        graph.add(n4);
        graph.add(n5);
        graph.add(n6);

        ConsoleTools.clearScreen();

        for(int i=0; i < nofnodes; i++){

            Node n = (Node) graph.get(i);

            System.out.println(n.toString());

        }


    }

    
}
