a = [9, 8, 7, 6, 5]

for i in range(0, 4):
    for j in range(0, 4-i):
        if a[j+1] < a[j]:
            temp = a[j+1]
            a[j+1] = a[j]
            a[j] = temp
            #print("swapped!\n")

for i in range(0,5):
    print(a[i])


