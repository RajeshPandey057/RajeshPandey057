l = [input() for i in range(int(input()))]
count = []
for s in l:
    ct = 0
    cs = 0
    s = s.replace("START", "s")
    for i in range(len(s)):
        if s[i] == "K" and s[i : i + 4] == "KICK":
            cs += 1
        if s[i] == "s":
            ct += cs
    count.append(ct)
for i, j in enumerate(count):
    print("Case #" + str(i + 1) + ": " + str(j))
