straight1 = list(input("Enter string:"))
reverse1 = straight1.copy()
reverse1.reverse()
flag = 0
for i in range(0, len(straight1)):
    if reverse1[i] != straight1[i]:
        flag = 1
        break
else:
    print("Yes")
    exit(0)

if flag == 1:
    print("No")
