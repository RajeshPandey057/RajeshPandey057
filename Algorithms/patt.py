n = int(input())
a = 10
b = 0
c = 0
d = 0
for i in range(0, n):
    temp = ""
    if i == 0:
        for j in range(0, n):
            temp += str(a)
            a += 10
        b = (a - 10) * ((a - 10) // 10) + 10
        d = b
        for j in range(0, n):
            temp += str(b)
            b += 10
        c = (b - 10) // 10 + 1
        temp += str(c)
    else:
        for j in range(0, i):
            temp += "**"
        for j in range(0, n-1):
            temp += str(a)
            a += 10
        b = d - (n - i) * 10
        d = b
        for j in range(0, n-i-1):
            temp += str(b)
            b += 10
        c = c - (n - i + 1)
        temp += str(c)
    print(temp)