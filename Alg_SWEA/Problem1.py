import sys

# Problem 1
input1_f = open("input1.txt", "r")
output1_f = open("output1.txt", "w")
test = int(input1_f.readline())

for loop in range(test) :
    total_sum = 0
    numbers = input1_f.readline().split()
    for component in numbers:
        if int(component) % 2 == 1 :
            total_sum += int(component)

    output1_f.write(f"#{loop + 1} {total_sum}\n")
input1_f.close()
output1_f.close()



