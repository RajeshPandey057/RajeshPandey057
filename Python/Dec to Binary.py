number = int(input("Enter decimal:"))
l1 = []
while number > 0:
    l1.append(number % 2)
    number //= 2
print("Binary of that is:")
print(*l1, sep='')
