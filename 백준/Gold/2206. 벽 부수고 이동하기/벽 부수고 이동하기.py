import sys
from collections import deque

input = sys.stdin.readline

N,M = map(int,input().split())
Map = [list(map(int,input().rstrip())) for _ in range(N)]
visited = [[[False,False] for _ in range(M)] for _ in range(N)]

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs():
    q = deque()
    visited[0][0][0] = True
    visited[0][0][1] = True
    q.append((0,0,1,0))
    shortest_path_len = -1

    while q:
        cur_x,cur_y,cur_len,breakWall = q.popleft()
        if cur_x == N-1 and cur_y == M-1:
            shortest_path_len = cur_len
            break
            
        for i in range(4):
            nx,ny = cur_x+dx[i] , cur_y + dy[i]
            if 0<=nx<N and 0<=ny<M:
                if Map[nx][ny] == 0 and visited[nx][ny][breakWall] == 0:
                    visited[nx][ny][breakWall] = True
                    q.append((nx,ny,cur_len+1,breakWall))
                elif Map[nx][ny] == 1 and breakWall == 0:
                    visited[nx][ny][1] = True
                    q.append((nx,ny,cur_len+1,1))
                                
            
        
    return shortest_path_len

                    
                        
print(bfs())
