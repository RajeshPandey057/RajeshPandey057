n = int(input("Enter Number:"))
print("Factors are")
for j in range(1, (n // 2) + 1):
    if n % j == 0:
        print(j)
print(n)
