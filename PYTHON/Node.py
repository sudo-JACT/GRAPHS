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


    

    def getToW(self, n):

        i = 0

        for x in self.to:

            if x.getNodeName() == n.getNodeName():

                return self.toW[i]

            i += 1

        return -404

    # get from w
    def getFromW(self, n):

        i = 0;

        for x in self.fromnodes:

            if x.getNodeName() == n.getNodeName():

                return self.fromW[i]

            i += 1

    def getTag(self):

        return self.tag


    def getNodeName(self):

        return self.nodename

    def getFromNode(self, i):

        return self.fromnodes[i]

    def getToNode(self, i):

        return self.to[i]


    def addFromNode(self, n):

        self.fromnodes.append(n)
        self.fromW.append(n.getToW(self))
        self.noffromnode += 1

        self.calcTag()
    
    def addToNode(self, n, w):

        self.to.append(n)
        self.toW.append(w);
        self.noftonode += 1

        n.addFromNode(self)


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



    def equals(self, n):

        if self.tag == n.getTag() and self.nodename == n.getNodeName():

            return True

        else:

            return False


    def toString(self):

        s = f"|{self.nodename}:{self.tag}|"

        return s


