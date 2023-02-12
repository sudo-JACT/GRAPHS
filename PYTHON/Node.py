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


    

    def findW(self, n):

        i = 0

        r = 1000000

        for x in self.to:

            #if x.findW(n, False) + self.toW[i] < resultT and t == True:
                
                #resultT = x.findW(n, False) + self.toW[i]


            if x.getNodeName() == n.getNodeName() and x.getFromW(self) >= 0 and x.getFromW(self) < r:

                r = self.toW[i]

            i += 1

        i = 0
        for x in self.fromnodes:

            #if x.findW(n, False) + self.fromW[i] < resultF and t == True:

                #resultF = x.findW(n, False) + self.fromW[i]


            if x.getNodeName == n.getNodeName() and x.getToW(self) >= 0 and x.getToW(n) < r:

                r = self.fromW[i]

            i += 1



        i = 0

        for x in self.fromnodes:
        

            if x.isConnected(n) == -1 and x.getFromW(n) > -1:


                if x.getFromW(n) + self.fromW[i] < r and r >= 0 and x.getFromW(n) + self.fromW[i] >= 0:

                    r = x.getFromW(n) +self.fromW[i]
        


            elif x.isConnected(n) == 1 and x.getToW(n) > -1:

                if x.getToW(n) + self.fromW[i] < r and r >= 0 and x.getToW(n) + self.fromW[i] >= 0:

                    r = x.getToW(n) + self.fromW[i]
                

            i += 1


        i = 0

        for x in self.to:

            if x.isConnected(n) == -1 and x.getFromW(n) > -1:

                if x.getFromW(n) + self.toW[i] < r and r >= 0 and x.getFromW(n) + self.toW[i] >= 0:

                    r = x.getFromW(n) + self.toW[i]

            elif x.isConnected(n) == 1 and x.getToW(n) > -1:

                if x.getToW(n) + self.toW[i] < r and r >= 0 and x.getToW(n) + self.toW[i] >= 0:

                    r = x.getFromW(n) + self.toW[i]

            i += 1
        
        if r != 1000000:

            return r

        else:

            return -1


    def getFromW(self, n):

        i = 0
        
        for x in self.fromnodes:

            if x.equals(n):

                return self.fromW[i]
            
            i += 1

        return -1

    def getToW(self, n):

        i = 0

        for x in self.to:

            if x.equals(n):

                return self.toW[i]

            i += 1

        return -1

    def isConnected(self, n):

        for x in self.to:

            if x.equals(self):

                return 1

        for x in self.fromnodes:

            if x.equals(self):

                return -1

        return 0


    def getTag(self):

        return self.tag


    def getNodeName(self):

        return self.nodename

    def getFromNode(self, i):

        return self.fromnodes[i]

    def getToNode(self, i):

        return self.to[i]

    def setWFromNode(self, i, w):

        self.fromW[i] = w

        return self.fromnodes

    def setWToNode(self, i, w):

        self.toW[i] = w

        return self.toW[i]


    def addFromNode(self, n, w):

        self.fromnodes.append(n)
        self.fromW.append(w)
        self.noffromnode += 1

        self.calcTag()
    
    def addToNode(self, n, w):

        self.to.append(n)
        self.toW.append(w);
        self.noftonode += 1

        n.addFromNode(self, w)


    def calcTag(self):

        mintag = 1000000
        minw = mintag
        i = 0

        while i < self.noffromnode:

            if self.fromnodes[i].getTag() >= 0 and self.fromW[i] >= 0 and ((self.fromnodes[i].getTag() + self.fromW[i]) < (mintag + minw)) and self.fromnodes[i].getNodeName() != self.nodename:

                mintag = self.fromnodes[i].getTag()
                minw = self.fromW[i]

            i += 1


        self.tag = mintag + minw
        
        return self.tag


    def equals(self, n):

        if self.tag == n.getTag() and self.nodename == n.getNodeName():

            return True

        else:

            return False


    def toString(self):

        s = f"|{self.nodename}:{self.tag}|"

        return s


