public class Node {
    
    private static int nodes_created=0;

    private int noden;
    private int tag;
    private int fromdgeW;
    private int toedgeW;
    private Node from;
    private Node to;
    private String nodename;


    public Node(String nn){

        this.noden = Node.nodes_created;
        Node.nodes_created++;
        this.nodename = nn;
        this.tag = 0;
        this.from = null;
        this.to = null;

    }

    public Node(Node f, Node t, String nn){

        this.noden = Node.nodes_created;
        Node.nodes_created++;
        this.from = f;
        this.to = t;
        this.nodename = nn;
        this.fromdgeW = f.getToW();
        this.toedgeW = t.getFromW();
        this.tag = f.getToW() + f.getTag();


    }


    public int getToW(){

        return this.toedgeW;

    }

    public int getFromW(){

        return this.fromdgeW;

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

    public Node getFromNode(){

        return this.from;

    }

    public Node getToNode(){

        return this.to;

    }


    public Node setFromNode(Node n){

        this.from = n;
        this.setFromnNodeW(n.getToW());

        return this;

    }

    public Node setToNode(Node n){

        this.to = n;
        this.toedgeW = n.getFromW();

        return this;

    }

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

    private void calcTag(){

        this.tag = this.from.getToW() + this.from.getTag();

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

        String n = "";

        if (this.from == null) {

            n += "NULL---";
            
        }else{

            n += "|" + this.from.getNodeName() + ":" + this.from.getTag() + "|---";

        }

        n += "|" + this.nodename + ":" + this.tag + "|---";

        
        if (this.to == null) {


            n += "NULL";
            
        }else{

            n += "|" + this.to.getNodeName() + ": " + this.to.getTag() + "|";

        }

        return n;

    }

}
