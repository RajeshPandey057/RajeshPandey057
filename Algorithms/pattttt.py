n = int(input())

s = []
c = 1
for i in range(n):
    te = ""
    for k in range(i):
        te += "**"
    for j in range(n-i):
        te += str(c)
        te += "0"
        c += 1
    s.append(te)

s2 = []
for i in range(n):
    te = ""
    for j in range(i):
        te += str(c)
        te += "0"
        c += 1
    te += str(c)
    c += 1
    s2.append(te)

ans = []
for i in range(n):
    ans.append(s[i]+s2[n-i-1])

for i in range(n):
    print(ans[i])