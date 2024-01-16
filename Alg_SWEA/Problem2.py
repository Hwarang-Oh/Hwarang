import sys

# Problem 2
input2_f = open("input1.txt", "r")
output2_f = open("output2.txt", "w")
test2 = int(input2_f.readline())

for loop in range(test2) :
    numbers = list(map(int, input2_f.readline().split()))
    numbers = sorted(numbers)
    output2_f.write(f"#{loop + 1} {numbers.pop()}\n")
input2_f.close()
output2_f.close()

