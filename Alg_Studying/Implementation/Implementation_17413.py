# tag를 만나기 전까지는 Stack
# tag를 만나면, 다음 tag까지는 Queue
# tag를 만나고 공백은 무시
# tag를 만나기 전에 공백은 graph의 끝을 의미
from collections import deque

wholeQueue = deque()
tempgraph = []
istag = False
for char in input() :
    if char == "<" :
        istag = True
        wholeQueue.append(tempgraph)
        tempgraph = deque()
    if char == ">" :
        istag = False
        tempgraph.append(char)
        wholeQueue.append(tempgraph)
        tempgraph = []
        continue
    if char == " " and not istag :
        wholeQueue.append(tempgraph)
        tempgraph = []
        tempgraph.append(char)
        wholeQueue.append(tempgraph)
        tempgraph = []
        continue
    tempgraph.append(char)
wholeQueue.append(tempgraph)

while wholeQueue :
    SorQ = wholeQueue.popleft()
    if not SorQ :
        continue
    if type(SorQ) == type(list()) :
        loopCount = len(SorQ)
        for loop in range(loopCount) :
            temp = SorQ.pop()
            print(temp, end = "")
    else :
        for temp in SorQ :
            print(temp, end = "")