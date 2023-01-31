from Node import Node


n1 = Node("A")
n2 = Node("B")
n3 = Node("C")


print(n1.toString())
print(n2.toString())
print(n3.toString() + "\n\n\n")


n1.addToNode(n2, 100)
n1.addToNode(n3, 3)


print(n1.toString())
print(n2.toString())
print(n3.toString() + "\n\n\n")


n3.addToNode(n2, 2)


print(n1.toString())
print(n2.toString())
print(n3.toString())

