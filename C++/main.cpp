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

    n1.addToNode(n2, 1);
    n1.addToNode(n6, 3);

    n2.addToNode(n3, 3);
    n2.addToNode(n6, 1);
    n2.addToNode(n5, 5);

    n3.addToNode(n4, 2);

    n5.addToNode(n4, 1);

    n6.addToNode(n5, 2);

    graph.push_back(n1);
    graph.push_back(n2);
    graph.push_back(n3);
    graph.push_back(n4);
    graph.push_back(n5);
    graph.push_back(n6);


    for(int i=0; i < nofn; i++){

        // TODO: aggiungere edge e loop
        
        cout << graph[i].toString() << endl;

    }

    return 0;
}
