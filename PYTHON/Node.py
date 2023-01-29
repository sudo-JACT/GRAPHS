class Node():

    def __init__(self, name):
        
        self.nodename = name;
        self.fromnodes = []
        self.fromW = []
        self.noffromnode = 0
        self.to = []
        self.toW = []
        self.noftonode = 0
        self.tag = 0;


    def getNodeName(self):

        return self.nodename

    def getTag(self):

        return self.tag

    def getToW(self, n):

        i = 0

        for x in self.to:

            if x.getNodeName() == n.getNodeName():

                return self.toW[i]

            i += 1

        return -404

    
    def addToNode(self, n, w):

        self.to.append(n)
        self.toW.append(w);
        self.noftonode += 1

        n.addFromNode(self)

    def addFromNode(self, n):

        self.fromnodes.append(n)
        self.fromW.append(n.getToW(self))
        self.noffromnode += 1

        self.calcTag()


    def calcTag(self):

        mintag = 1000000
        minw = mintag
        i = 0

        while i < self.noffromnode:

            if (self.fromnodes[i].getTag() + self.fromW[i]) < (mintag + minw):

                mintag = self.fromnodes[i].getTag()
                minw = self.fromW[i]

            i += 1


        self.tag = mintag + minw



    def equals(self):

        pass


    def toString(self):

        s = f"|{self.nodename}:{self.tag}|"

        return s


