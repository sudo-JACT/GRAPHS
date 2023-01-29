import java.util.ArrayList;
import java.util.List;

/**
 * @author 1MD0NK3Y
 * @version 1.0.0
 *
 */

public class Graph {
    
    private List nodes = new ArrayList<Node>();
    private int nofnodes = 0;


    public Graph(){

        

    }


    public void addNode(Node n){

        this.nodes.add(n);
        this.nofnodes++;
    
    }

    public void addNode(){

        String s = "" + this.nofnodes;
        Node n = new Node(s);
        this.nodes.add(n);
        this.nofnodes++;

    }
    
}
