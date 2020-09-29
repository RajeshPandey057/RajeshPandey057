deno = [1, 2, 5, 10, 20, 50, 100, 500,  1000]
size = len(deno)

def findMin(value):
    arr = [0]
    ans = []
    for i in range(size-1, -1, -1):
        while value >= deno[i] :
            value -= deno[i]
            print(value)
            ans.append(deno[i])
    print(ans)

n = 93
findMin(n)