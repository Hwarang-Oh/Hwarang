numJew, numBag = map(int, input().split())
jew_list = []
storage_list = []
gems = [list(map(int,input().split())) for _ in range(numJew)]
gems.sort()

# for loop in range(numJew):
#     weight, value = map(int, input().split())
#     jew_list.append([weight, value])
# jew_list.sort(key=lambda x: x[1])

for loop in range(numBag) :
    storage_list.append(int(input()))

print(gems)
print(storage_list)

# 털 보석점에는 보석이 총 N개 있다.
# 각 보석은 무게 Mi와 가격 Vi를 가지고 있다.
# 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci, 한개의 보석만 가능
# 훔칠 수 있는 보석의 최대 가격

# 2 1 (보석 개수 & 가방 개수)
# 5 10 (보석 무게 & 보석 가치)
# 100 100 (보석 무게 & 보석 가치)
# 11 ( 가방의 최대 용량 )
# -> 100

# 3 2
# 1 65
# 5 23
# 2 99
# 10 -> 이것보다 작은 무게에서 최대 가치
# 2 -> 이것보다 작은 무게에서 최대 가치
# 무게