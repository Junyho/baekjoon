import sys

N = int(sys.stdin.readline())
line = []

for _ in range(N):
    line.append(tuple(map(int,sys.stdin.readline().split())))
line.sort()

s = line[0][0]
e = line[0][1]
result = 0

for i in range(1,N):
    if line[i][0] > e:
        result += e-s
        s = line[i][0]
        e = line[i][1]
    elif line[i][0] <= e and e < line[i][1]:
        e = line[i][1]

result += e-s
print(result)
        
