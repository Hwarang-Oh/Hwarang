# list.pop(index) -> index에 있는 component를 날림.
# heapQ에 대한 개념정리 필요
# Method 1
import heapq
num_set = int(input())
paperSetlist = []
for loop in range(num_set) :
    paperSetlist.append(int(input()))

heapq.heapify(paperSetlist)
count = 0
while len(paperSetlist) > 1 :
    min1 = heapq.heappop(paperSetlist)
    min2 = heapq.heappop(paperSetlist)
    heapq.heappush(paperSetlist, min1 + min2)
    count += min1 + min2
print(count)