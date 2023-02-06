from Node import Node


n1 = Node("A")
n2 = Node("B")
n3 = Node("C")
n4 = Node("D")
n5 = Node("E")
n6 = Node("F")

nodes = []
nnodes = 6

n1.addToNode(n2, 1)
n1.addToNode(n6, 3)


n2.addToNode(n3, 3)
n2.addToNode(n6, 1)
n2.addToNode(n5, 5)


n3.addToNode(n4, 2)


n5.addToNode(n4, 1)


n6.addToNode(n5, 2)


nodes.append(n1)
nodes.append(n2)
nodes.append(n3)
nodes.append(n4)
nodes.append(n5)
nodes.append(n6)

for i in range(nnodes):

    print(nodes[i].toString())
