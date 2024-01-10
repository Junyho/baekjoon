import sys



def solution(nums):
    def backtrack(curr):
        if len(curr) == 6:
            ans.append(curr[:])
            return
        for num in nums:
            if not curr or num > curr[-1]:
                curr.append(num)
                backtrack(curr)
                curr.pop()
    ans = []
    backtrack([])
    return ans

while True:
    S = list(map(int,sys.stdin.readline().split()))
    k = S[0]
    S.pop(0)
    
    if k==0:
        break
    result = solution(S)
    for i in range(len(result)):
        print(' '.join(map(str,result[i])))

    print()

    
