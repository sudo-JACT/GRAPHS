#include <vector>
#include <string>


using namespace std;

class Node{

    private:

        static int node_created;
        int noden;
        int tag;
        vector<Node> fromnodes;
        vector<int> fromnodesW;
        int noffromnodes = 0;
        vector<Node> tonodes;
        vector<int> tonodesW;
        int noftonodes = 0;
        string nodename;


    public:

        Node(string nn){

            this -> noden = Node::node_created;
            Node::node_created++;
            this -> tag = 0;
            this -> nodename = nn;


        }


        string to_string(){

            return "|" + this -> nodename + ":" + ((string) this -> tag) + "|";

        }


};
