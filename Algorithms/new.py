no = int(input())
bottle = list(map(int, input().split()))
bottle.sort()
ans = 0
lb=len(bottle)
while len(bottle) > 0:
    j = 0
    while j < lb:
        i = j + 1
        flag = 0
        while i < lb:
            if bottle[i] > bottle[j]:
                flag = 1
                break
            i += 1
        if flag == 1:
            bottle.pop(j)
            lb -= 1
            j = i - 1
        else:
            bottle.pop(j)
            lb -= 1
            ans += 1
            j += 1
print(ans)