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


        n1.addToNode(n2, 100);
        n1.addToNode(n3, 2);
        n2.addToNode(n4, 1);
        n2.addToNode(n5, 50);

        n3.addToNode(n2, 5);
        n3.addToNode(n5, 5);
        n4.addToNode(n5, 10);
        n1.addToNode(n5, 50);
        
        n1.addToNode(n6, 9);
        n2.addToNode(n6, 7);
        n3.addToNode(n6, 3);
        n4.addToNode(n6, 4);
        n5.addToNode(n6, 2);

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
