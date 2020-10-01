5
def pivot(a,l,r,p,length):
    t1=l
    t2=r
    t3=a[p]
    t4=p
    while(l<=r):
        if(a[l]>a[p]):
            if(a[r]<a[p]):
                a[l],a[r]=a[r],a[l]
                l+=1
                r-=1
            else:
                r-=1
        else:
            l+=1
    if(l<length):
        if(r>0):
            for i in range(t1,l):
                a[i-1]=a[i]
            a[l-1]=t3
            pivot(a,t1,r-1,t4,length)
            pivot(a,l+1,t2,l,length)
    
length=int(input("Size of array:"))
a=[]
for i in range(0,length):
    a.append([])
    a[i].append(int(input()))
pivot(a,1,length-1,0,length)
print(a)
