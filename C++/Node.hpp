#include <cstdint>
#include <vector>
#include <string>
#include <iostream>

using namespace std;

int node_created = 0;

class Node{

    private:

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

            this -> noden = node_created;
            node_created++;
            this -> tag = 0;
            this -> nodename = nn;


        }

        int getToW(Node n){

            for (int i=0; i < this -> noftonodes; i++){

                if(n.equals(this -> tonodes[i])){

                    int g = this -> tonodesW[i];

                    return g;

                }
                
            }

            return -404;

        }


        int getTag(){

            return this -> tag;

        }

        int getNodeN(){

            return this -> noden;

        }

        Node addFromNode(Node n){

            this -> fromnodes.push_back(n);
            this -> noffromnodes++;
            this -> fromnodesW.push_back(n.getToW(*this));

            this -> calcTag();

            for (int i=0; i < this -> noftonodes; i++){
                
                this -> tonodes[i].calcTag();

            }

            return *this;

        }

        Node addToNode(Node n, int w){
        
            this -> tonodes.push_back(n);
            this -> noftonodes++;
            this -> tonodesW.push_back(w);

            n.addFromNode(*this);

            return *this;
        }

        bool equals(Node n){

            if(this -> tag == n.getTag() && this -> noden == n.getNodeN()){
                
                return true;

            }else {
                    
                return false;

            }

        }

        int calcTag(){

            int mintag=INT32_MAX/2, minW=INT32_MAX/2, tg, nw;

            for(int i=0; i < this -> noffromnodes; i++){

                tg = this -> fromnodes[i].getTag();
                nw = this -> fromnodesW[i];

                if((tg + nw) < (mintag + minW)){

                    mintag = tg;
                    minW = nw;

                    cout << mintag << " " << minW << endl;

                }

            }

            this -> tag = mintag + minW;

            cout << this -> nodename << " " << this -> tag << endl;

            return this -> tag;

        }

        string toString(){

            string t = to_string(this -> tag);

            return "|" + this -> nodename + ":" + t + "|";

        }


};
