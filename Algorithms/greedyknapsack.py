def knapsack(W, wt, val, n):
    mm = []
    for i in range(0, 3):
        mm.append([])
        ratio = val[i]/wt[i]
        mm[i].append(ratio)
        mm[i].append(wt[i])
        mm[i].append(val[i])
    mm.sort()
    res = []
    temp = 0
    length = len(mm)
    while W>0 and length>0:
        if (mm[length-1][1] < W) :
            W = W - mm[length-1][1]
            temp=temp+mm[length-1][2]
        length = length - 1
    print("Maximum value is:")
    print(temp)
    #return K[n][W]


val = [60, 100, 120]
wt = [10, 20, 30]
W = 50
n = len(val)
knapsack(W, wt, val, n)

