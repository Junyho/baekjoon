def solution(str):
    result = {}
    k=1
    curr=''
    while(k <= len(str)):
        for i in range(len(str)-k+1):
             curr = str[i:i+k]
             if curr not in result:
                 result[curr] = 0
        k+=1
    return result

str = input()
print(len(solution(str)))