from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
Map = [list(map(int,input().split())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def island(x,y):
    queue = deque()
    visited[x][y] = True
    Map[x][y] = k
    queue.append((x,y))

    while queue:
        cur_x,cur_y = queue.popleft()
        for i in range(4):
            nx,ny = cur_x + dx[i], cur_y + dy[i]
            if 0<=nx<N and 0<=ny<N and not visited[nx][ny]:
                if Map[nx][ny] == 1:
                    visited[nx][ny] = True
                    Map[nx][ny] = k
                    queue.append((nx,ny))

def distance(island):
    q = deque()
    dist = [[-1]*(N) for _ in range(N)]

    for i in range(N):
        for j in range(N):
            if Map[i][j] == island:
                q.append((i,j))
                dist[i][j] = 0
    while q:
        cur_x,cur_y = q.popleft()
        for i in range(4):
            nx , ny = cur_x + dx[i], cur_y + dy[i]
            if 0<=nx<N and 0<=ny<N:
                if Map[nx][ny] != island and Map[nx][ny] != 0:
                    return dist[cur_x][cur_y]

                if Map[nx][ny] == 0 and dist[nx][ny] == -1:
                    dist[nx][ny] = dist[cur_x][cur_y] + 1
                    q.append((nx,ny))
                
    

k = 1
for i in range(N):
    for j in range(N):
        if Map[i][j] == 1 and not visited[i][j]:
            island(i,j)
            k+=1

min_dist = sys.maxsize
for num in range(1,k):
    min_dist = min(min_dist,distance(num))
print(min_dist)
                             
        
    
    
