import sys
import heapq
n = int(sys.stdin.readline())
time = []

for _ in range(n):
    start, end = map(int, sys.stdin.readline().split())
    time.append((start, end))

time.sort(key=lambda x: x[0])

heap = []

for start,end in time:
    if not heap:
        heapq.heappush(heap,(end,start))
    else:
        if heap[0][0] <= start:
            heapq.heappop(heap)
            heapq.heappush(heap,(end,start))
        else:
            heapq.heappush(heap,(end,start))

    
    
print(len(heap))
