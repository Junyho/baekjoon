import sys

N,M = map(int, sys.stdin.readline().split())
graph = [ [-1] * (N) for _ in range(N) ]

for i in range(M):
    heavy,light = map(int,sys.stdin.readline().split())
    graph[heavy-1][light-1] = 1
    graph[light-1][heavy-1] = 0

for k in range(N):
    for i in range(N):
        for j in range(N):
            if graph[i][k] == 1 and graph[k][j] == 1:
                graph[i][j] = 1
            if graph[i][k] == 0 and graph[k][j] == 0:
                graph[i][j] = 0

notMid = 0
for i in range(N):
    cntH = 0
    cntL = 0
    for j in range(N):
        if graph[i][j] == 1:
            cntH += 1
        if graph[i][j] == 0:
            cntL += 1
            
    if cntH >= (N+1)/2 or cntL >= (N+1)/2:
        notMid += 1
    
    

print(notMid)


