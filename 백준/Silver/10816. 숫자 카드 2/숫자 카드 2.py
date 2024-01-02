N = int(input())
card1 = list(map(int,input().split()))
M = int(input())
card2 = list(map(int,input().split()))

count = {}
for num in card1:
    if num in count:
        count[num]+=1
    else:
        count[num]=1
for num in card2:
    if num in count:
        print(count[num],end=' ')
    else:
        print("0 ",end='')
    



