public class App {
    
    
    public static void main(String[] args) {
        
        Node n1 = new Node("A");
        Node n2 = new Node("B");
        n1.setToNode(n2);
        n2.setFromNode(n1);

        System.out.println(n1.toString());
        System.out.println(n2.toString());


    }

    
}
