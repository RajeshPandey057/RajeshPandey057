def maxXorValue(x, k):
    l=list(map(int,str(x)))
    result = [0]*len(l)
    if k!=0:
        j=0
        for i in l:
            if(k!= 0 and i==0):
                result[j]=1
                k-=1
            elif(i==1):
                result[j]=0
            j+=1
    return (''.join(str(i) for i in result))
print(maxXorValue(10010,5))