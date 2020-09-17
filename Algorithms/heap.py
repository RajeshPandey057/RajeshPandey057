a=[]
print("Enter the size ")
l=int(input())
for i in range(0,l):
    a.append([])
    a[i].append(int(input()))
def heapify(i,dl):
    m=i
    if((2*i+1)<dl and a[2*i+1]>a[m]):
        m=2*i+1
    if((2*i+2)<dl and a[2*i+2]>a[m]):
        m=2*i+2
    if(m==i):
        return i
    else:
        a[i],a[m]=a[m],a[i]
        heapify(m,dl)
def heapsort(arr,dl):
    for j in range(int(dl/2)-1,-1,-1):
        heapify(j,dl)
    while(dl>0):
        arr[0],arr[dl-1]=arr[dl-1],arr[0]
        dl=dl-1
        heapify(0,dl)
heapsort(a,l)
print(a)
