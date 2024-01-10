import sys

arr = sys.stdin.readline()
p = 0
flag = 0
stack = []
result = 0
for i in range(len(arr)):
    if arr[i]=='+':
        if flag == 1:
            stack.append(int(arr[p:i]))
        else:
            result += int(arr[p:i])
        p = i+1
        
    elif arr[i]=='-':
        if flag == 1:
            stack.append(int(arr[p:i]))
        else:
            flag =1
            result += int(arr[p:i])
        p = i+1
if flag == 1:
    stack.append(int(arr[p:len(arr)]))
else:
    result += int(arr[p:len(arr)])
    
print(result - sum(stack))
