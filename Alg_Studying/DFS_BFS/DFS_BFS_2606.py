from collections import deque


def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    infected = []
    while queue:
        vertex = queue.popleft()
        infected.append(vertex)
        for adj in graph[vertex]:
            if not visited[adj]:
                queue.append(adj)
                visited[adj] = True
    return len(infected) - 1


comNum = int(input())
pair = int(input())
visited = [False] * (comNum + 1)
graph = [[] for _ in range(comNum + 1)]
for eachPair in range(pair) :
    num1, num2 = map(int,input().split())
    graph[num1].append(num2)
    graph[num2].append(num1)

print(bfs(graph, 1, visited))


