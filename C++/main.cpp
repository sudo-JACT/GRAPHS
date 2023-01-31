#include <iostream>
#include <vector>
#include "Node.hpp"

using namespace std;


int main(){

    vector<Node> graph;
    int nofn = 6;

    Node n1 = Node("A");
    Node n2 = Node("B");
    Node n3 = Node("C");
    Node n4 = Node("D");
    Node n5 = Node("E");
    Node n6 = Node("F");

    graph.push_back(n1);
    graph.push_back(n2);
    graph.push_back(n3);
    graph.push_back(n4);
    graph.push_back(n5);
    graph.push_back(n6);


    for(int i=0; i < nofn; i++){

        //TODO aggiungere edge e loop

    }

    return 0;
}
