no = int(input())
bottle = list(map(int, input().split()))
bottle.sort()
ans = 0
while len(bottle) > 0:
    j = 0
    while j < len(bottle):
        i = j + 1
        flag = 0
        while i < len(bottle):
            if bottle[i] > bottle[j]:
                flag = 1
                break
            i += 1
        if flag == 1:
            bottle.pop(j)
            j = i - 1
        else:
            bottle.pop(j)
            ans += 1
            j += len(bottle)
print(ans)