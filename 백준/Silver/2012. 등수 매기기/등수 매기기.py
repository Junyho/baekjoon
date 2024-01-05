import sys
n = int(sys.stdin.readline())
rank = []
for _ in range(n):
    rank.append(int(sys.stdin.readline()))


rank.sort()
total = 0
for i in range(len(rank)):
    total += abs(rank[i] - (i+1))
print(total)

    
