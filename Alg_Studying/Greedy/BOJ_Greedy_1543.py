word = input()
search = input()
count = 0
start = 0
while (start <= len(word) - len(search)) :
    if search == word[start : start + len(search)] :
        count += 1
        start += len(search)
    else :
        start += 1
print(count)