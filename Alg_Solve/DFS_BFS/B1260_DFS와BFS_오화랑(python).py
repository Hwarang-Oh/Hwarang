from collections import deque


def dfs(graph, start, visited) :
    visited[start] = True
    print(start, end = " ")
    for adj in graph[start] :
        if not visited[adj] :
            dfs(graph, adj, visited)


def bfs(graph, start, visited) :
    visited[start] = True
    queue = deque([start])
    while queue:
        currVer = queue.popleft()
        print(currVer, end = " ")
        for adj in graph[currVer] :
            if not visited[adj] :
                queue.append(adj)
                visited[adj] = True


vertexNum, nodeNum, startVertex = map(int, input().split())
graph = [[] for _ in range(vertexNum + 1)]
visited = [False] * (vertexNum + 1)
for eachNode in range(nodeNum) :
    ver1, ver2 = map(int, input().split())
    graph[ver1].append(ver2)
    graph[ver2].append(ver1)

for list in graph :
    list.sort()

dfs(graph, startVertex, visited)
visited = [False] * (vertexNum + 1)
print()
bfs(graph, startVertex, visited)