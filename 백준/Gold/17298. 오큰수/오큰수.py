import sys
n = int(input())
arr = list(map(int,input().split()))
result = [0] * n
stack = []

for i in range(n):
    while stack and arr[stack[-1]] < arr[i]:
        result[stack.pop()] = arr[i]
    stack.append(i)

while stack:
    result[stack.pop()] = -1

for i in range(n):
    sys.stdout.write(str(result[i])+" ")
        
