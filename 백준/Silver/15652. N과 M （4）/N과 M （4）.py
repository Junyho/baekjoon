N, M = map(int, input().split())
nums = [i + 1 for i in range(N)]

def solution(nums):
    def backtrack(curr):
        if len(curr) == M:
            ans.append(curr[:])
            return

        for num in nums:
            if not curr or num >= curr[-1]:
                curr.append(num)
                backtrack(curr)
                curr.pop()

    ans = []
    backtrack([])
    return ans

answer = solution(nums)
for i in range(len(answer)):
    print(' '.join(map(str, answer[i])))
