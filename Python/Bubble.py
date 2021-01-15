numbers = list(map(int, input("Enter Numbers:").split()))
for i in range(0, len(numbers)):
    for j in range(i+1, len(numbers)):
        if numbers[i] > numbers[j]:
            numbers[i], numbers[j] = numbers[j], numbers[i]
print(*numbers)
