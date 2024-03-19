import sys

input = sys.stdin.readline

N = int(input())
score = [int(input().strip()) for _ in range(N)]

total = 0
for i in range(N-1, 0, -1):
    if score[i-1] >= score[i]:
        sub = score[i] - 1
        total += (score[i-1] - sub)
        score[i-1] = sub

print(total)
