def ana(s1,s2):
    ''.join(sorted(s1))
    ''.join(sorted(s2))
    return  int(s1==s2)
a=input()
n=int(input())
b=[None]*n
c=[]
f=0
op=[]
for i in range(0,n):
    op.append(list(input()))
j=0
k=0
l=len(op)
for i in range(0,l):
    if(op[i][0]=='L'):
        j+=int(op[i][2])
        while(j>=l):
            j-=n
        b[k]=a[j]
        k+=1
    elif (op[i][0] == 'R'):
        j -= int(op[i][2])
        while (j <= 0):
            j += l
        b[k]=(a[j])
        k+=1
for i in range(0,(l-n)+1):
    c=a[i:n]
    print(c)
    if(ana(c,b)==1):
        f=1
if(f==1):
    print("YES")
else:
    print("NO")