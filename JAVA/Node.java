import java.util.ArrayList;
import java.util.List;

/**
 * @author 1M0NK3Y
 * @version 1.0.0
 *
 */

public class Node {
    
    private static int nodes_created=0;

    private int noden;
    private int tag;
    private List fromdgeW = new ArrayList<Integer>();
    private List toedgeW = new ArrayList<Integer>();
    private List from = new ArrayList<Node>();
    private int noffromnode = 0;
    private List to = new ArrayList<Node>();
    private int noftonode = 0;
    private String nodename;


    public Node(String nn){

        this.noden = Node.nodes_created;
        Node.nodes_created++;
        this.nodename = nn;
        this.tag = 0;

    }

    public Node(Node f, Node t, String nn){

        this.noden = Node.nodes_created;
        Node.nodes_created++;
        this.from.add(f);
        this.noffromnode++;
        this.to.add(t);
        this.noftonode++;
        this.nodename = nn;
        this.fromdgeW.add(f.getToW(this));
        this.toedgeW.add(t.getFromW(this));
        this.tag = f.getToW(this) + f.getTag();


    }


    public int getToW(Node n){

        Node n2;

        for(int i=0; i < this.noftonode; i++){

            n2 = (Node) this.to.get(i);

            if (n.equals(n2)) {

                int g = (int) this.toedgeW.get(i);

                return g;
                
            }

        }

        return -404;

    }

    public int getFromW(Node n){

        Node n2;

        for(int i=0; i < this.noffromnode; i++){

            n2 = (Node) this.from.get(i);

            if (n.equals(n2)) {

                int g = (int) this.fromdgeW.get(i);

                return g;
                
            }

        }

        return -404;

    }

    public int getTag(){

        return this.tag;

    }

    public int getNodeN(){

        return this.noden;

    }

    public String getNodeName(){

        return this.nodename;

    }

    public Node getFromNode(int i){

        Node n = (Node) this.from.get(i);

        return n;

    }

    public Node getToNode(int i){

        Node n = (Node) this.to.get(i);

        return n;

    }


    public Node addFromNode(Node n){

        this.from.add(n);
        this.noffromnode++;
        this.fromdgeW.add(n.getToW(this));

        this.calcTag();

        for(int i=0; i < this.noftonode; i++){

            Node n2 = (Node) this.to.get(i);
            n2.calcTag();

        }

        return this;

    }

    public Node addToNode(Node n, int w){

        this.to.add(n);
        this.noftonode++;
        this.toedgeW.add(w);

        n.addFromNode(this);

        return this;

    }

    // TODO: 
    /* 
    public int setFromnNodeW(int w){

        this.fromdgeW = w;
        this.from.setToNodeW(w);
        this.calcTag();
        return this.fromdgeW;

    }

    public int setToNodeW(int w){

        this.toedgeW = w;
        return this.toedgeW;

    }

    */

    public int calcTag(){

        int mintag = 1000000, minW = 1000000, nw;
        Node n;

        for(int i=0; i < this.noffromnode; i++){

            n = (Node) this.from.get(i);
            nw = (int) this.fromdgeW.get(i);

            if((n.getTag() + nw) < (mintag + minW)){

                mintag = n.getTag();
                minW = nw;

            }

        }



        this.tag = mintag + minW;

        
        return this.tag;

    }

    
    @Override
    public boolean equals(Object obj) {
        
        if (obj == null || !(obj instanceof Node)) {

            return false;
            
        }else{

            Node n = (Node) obj;

            if (this.nodename.equals(n.getNodeName()) && this.noden == n.getNodeN() && this.tag == n.getTag()) {

                return true;
                
            }else{

                return false;

            }

        }
    }

    @Override
    public String toString() {

        return "|" + this.nodename + ":" + this.tag + "|";

    }

}
