N = int(input())
meeting = []
for _ in range(N):
    meeting.append(tuple(map(int,input().split())))
meeting.sort(key=lambda x:x[0])
meeting.sort(key=lambda x:x[1])
count = 0
last = 0
for start,end in meeting:
    if  start >= last:
        count+=1
        last = end
print(count)

   
