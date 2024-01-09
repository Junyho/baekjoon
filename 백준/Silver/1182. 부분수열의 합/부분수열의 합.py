import sys

N,S = map(int, sys.stdin.readline().split())
arr = list(map(int,sys.stdin.readline().split()))



def solution(nums):
    ans = []
    def backtrack(start, curr):
        if len(curr) == k:
            arr_sum = sum(curr)
            if arr_sum == S:
                ans.append(curr[:])
                return

        for i in range(start, len(nums)):
            curr.append(nums[i])
            backtrack(i+1 ,curr)
            curr.pop()
            
    for k in range(1,len(nums)+1):
        backtrack(start = 0, curr= [])
                
    
    return ans

print(len(solution(arr)))
