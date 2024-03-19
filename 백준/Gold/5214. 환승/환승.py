from sys import stdin
from collections import deque

input = stdin.readline

n,k,m = map(int, input().split())
station = [[] for _ in range(n)]
hyper_tube = [[] for _ in range(m)]
for idx in range(m):
    nums = list(map(int, input().split()))
    for num in nums:
        station[num-1].append(idx)
        hyper_tube[idx].append(num-1)

def solv():
    visited_station = [False]*n
    visited_hyper = [False]*m
    q = deque([(0,1)])

    visited_station[0] = True
    while q:
        now,cnt = q.pop()

        nxt_hyper = []
        for hyper_idx in station[now]:
            if not visited_hyper[hyper_idx]:
                nxt_hyper.append(hyper_idx)
                visited_hyper[hyper_idx] = True

        for hyper in nxt_hyper:
            for station_idx in hyper_tube[hyper]:
                if not visited_station[station_idx]:
                    if station_idx == n-1:
                        print(cnt+1)
                        return
                    visited_station[station_idx] = True
                    q.appendleft((station_idx,cnt+1))
    print(-1)

if n == 1:
    print(1)
else:
    solv()