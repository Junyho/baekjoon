import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def findMan():
    for i in range(h):
        for j in range(w):
            if space[i][j] == '@':
                return i, j

def bfs(x, y):
    visited[x][y] = True
    queue = deque([(x, y, 0)])
    fire_queue = deque([(i, j) for i in range(h) for j in range(w) if space[i][j] == '*'])

    while queue:
        # Fire spread
        fire_size = len(fire_queue)
        for _ in range(fire_size):
            i, j = fire_queue.popleft()
            for k in range(4):
                nx, ny = i + dx[k], j + dy[k]
                if 0 <= nx < h and 0 <= ny < w and space[nx][ny] == '.':
                    space[nx][ny] = '*'
                    fire_queue.append((nx, ny))

        # Person move
        size = len(queue)
        for _ in range(size):
            x, y, cnt = queue.popleft()
            if x == 0 or x == h-1 or y == 0 or y == w-1:
                return cnt+1  # Escape!

            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]
                if 0 <= nx < h and 0 <= ny < w and space[nx][ny] == '.' and not visited[nx][ny]:
                    visited[nx][ny] = True
                    queue.append((nx, ny, cnt+1))

    return -1

n = int(sys.stdin.readline())

for _ in range(n):
    w, h = map(int, sys.stdin.readline().split())
    space = [list(sys.stdin.readline().strip()) for _ in range(h)]
    visited = [[False] * w for _ in range(h)]
    x, y = findMan()
    result = bfs(x, y)
    if result == -1:
        print("IMPOSSIBLE")
    else:
        print(result)
