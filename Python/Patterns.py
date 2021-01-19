print("Pattern 1:")
patt1 = []
for i in range(1, 6):
    temp = []
    for j in range(0, i):
        temp.append("*")
    patt1.append(temp)
for i in range(4, 0, -1):
    temp = []
    for j in range(0, i):
        temp.append("*")
    patt1.append(temp)
for i in patt1:
    print(*i, sep='')

print("Pattern 2:")
patt2 = []
for i in range(1, 7):
    temp = []
    for j in range(i, 0, -1):
        temp.append(j)
    patt2.append(temp)
for i in patt2:
    print(*i, sep='')

print("Pattern 3:")
patt3 = []
counter = 0
i = 0
while i in range(0, 10):
    temp = []
    for j in range(0, 4):
        if j <= counter:
            temp.append(chr(i + 65))
            i += 1
        else:
            temp.append(" ")
    counter += 1
    patt3.append(temp)
for i in patt3:
    i.reverse()
    print(*i, sep='')
