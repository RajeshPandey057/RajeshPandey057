n = int(input("Enter n:"))
total = 0
for i in range(1, n+1):
    total += i/(i+1)
print("%.4f" % total)
