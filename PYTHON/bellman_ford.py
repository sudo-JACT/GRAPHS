from Node import Node

nodes = []
nnodes = 4

n1 = Node("A")
n2 = Node("B")
n3 = Node("C")
n4 = Node("D")

n1.addToNode(n2, 2)
n1.addToNode(n3, 1)
n1.addToNode(n4, -1)
n1.addToNode(n1, 0)

n2.setWFromNode(0, -1)
n2.addToNode(n3, 9)
n2.addToNode(n2, 0)

n3.setWFromNode(0, 10)
n3.setWFromNode(1, 4)
n3.addToNode(n4, 1)
n3.addToNode(n3, 0)

n4.setWFromNode(0, 2)
n4.setWFromNode(1, -1)
n4.addToNode(n4, 0)

nodes.append(n1)
nodes.append(n2)
nodes.append(n3)
nodes.append(n4)


for i in range(nnodes):

    for x in nodes:

        print(f"{nodes[i].getNodeName()} to {x.getNodeName()}: {nodes[i].findW(x)}")

    print()
