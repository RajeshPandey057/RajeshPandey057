minLen = int(input())
maxLen = int(input())
minWid = int(input())
maxWid = int(input())

ans = 0

for i in range(minLen, maxLen + 1):
    for j in range(minWid, maxWid + 1):
        temp1, temp2 = i, j
        rem=1
        while rem != 0:
            if temp1 >= temp2:
                result = temp1 // temp2
                ans += result
                rem = temp1 % temp2
                temp1 = rem
            else:
                result = temp2 // temp1
                ans += result
                temp2 = temp2 % temp1
                temp2 = rem

print(ans)