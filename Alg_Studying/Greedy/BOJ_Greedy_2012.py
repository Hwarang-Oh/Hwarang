# Method 1
# num_stud = int(input())
# rank_list = list(range(1, num_stud + 1))
# max_diff = 0
# for loop in range(num_stud):
#     studRank = int(input())
#     rank_diff = num_stud
#     for i in range(len(rank_list)):
#         curr_diff = abs(studRank - rank_list[i])
#         if curr_diff < rank_diff:
#             rank_diff = curr_diff
#             selectedRank = rank_list[i]
#     max_diff += rank_diff
#     rank_list.remove(selectedRank)
# print(max_diff)

# Method 2
num_stud = int(input())
rank_list = list(range(1, num_stud + 1))
studRank_list = []
max_diff = 0
for loop in range(num_stud):
    studRank_list.append(int(input()))
studRank_list.sort()
for index in range(num_stud):
    max_diff += abs(studRank_list[index] - rank_list[index])
print(max_diff)