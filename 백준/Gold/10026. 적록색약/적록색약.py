
import sys
sys.setrecursionlimit(10**5)

n = int(input().rstrip())
draw = [list(input().rstrip()) for _ in range(n)]
visited = [[False] * n for _ in range(n)]

three_cnt, two_cnt = 0,0
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def dfs(x,y):
    visited[x][y] = True
    cur_color = draw[x][y]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if (0 <= nx < n) and (0 <= ny < n):
            if visited[nx][ny] == False:
                if draw[nx][ny] == cur_color:
                    dfs(nx,ny)
for i in range(n):
    for j in range(n):
        if visited[i][j] == False:
            dfs(i,j)
            three_cnt += 1

for i in range(n):
    for j in range(n):
        if draw[i][j] == 'R':
            draw[i][j] = 'G'

visited = [[False]*n for _ in range(n)]

for i in range(n):
    for j in range(n):
        if visited[i][j] == False:
            dfs(i,j)
            two_cnt+=1
print(three_cnt,two_cnt)

