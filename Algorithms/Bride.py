def findBride():
    mat = []
    res = []
    fin = []
    fi1 = []
    m, n = map(int, input().split())
    for i in range(0, m):
        b = input()
        a = list(map(int, input().split()))
        mat.append(a)
    for i in range(0,m):
        for j in range(0,n):
            if(mat[i][j]==1):
                temp=[i,j]
                res.append(temp)
    m1=len(res)
    n1=len(res[0])
    for i in range(0,m1):
        c=0
        for i1 in range(0, m1):
                if(res[i][1]==res[i1][1] and (res[i][0]-res[i1][0])==1):
                    c+=1
                if(res[i][0]==res[i1][0] and (res[i][1]-res[i1][1])==1):
                    c+=1
                if (res[i][1] == res[i1][1] and (res[i][0] - res[i1][0]) == -1):
                    c += 1
                if (res[i][0] == res[i1][0] and (res[i][1] - res[i1][1]) == -1):
                    c += 1
                if((res[i][1]-res[i1][1])==1 and (res[i][0]-res[i1][0])==1):
                    c+=1
                if ((res[i][1] - res[i1][1]) == 1 and (res[i][0] - res[i1][0]) == -1):
                    c += 1
                if ((res[i][1] - res[i1][1]) == -1 and (res[i][0] - res[i1][0]) == 1):
                    c += 1
                if ((res[i][1] - res[i1][1]) == -1 and (res[i][0] - res[i1][0]) == -1):
                    c += 1
        temp1=[c,res[i][0],res[i][1]]
        fin.append(temp1)
    fin.sort(reverse=True)
    max=fin[0][0]
    min=m+n
    p=0
    while(p<len(fin)):
        if (fin[p][0]==max):
            fi1.append(fin[p])
        p+=1
    temp=[]
    for i in range(0,len(fi1)):
        if(min>fi1[i][1]+fi1[i][2]):
            temp2=[(fi1[i][1]+fi1[i][2]),fi1[i][0],fi1[i][1],fi1[i][2]]
            temp.append(temp2)
    temp.sort()
    if(temp[0][1]==0):
        print("\"No suitable girl found\"")
        return 0
    elif(len(temp)>1):
        if((temp[0][0]==temp[1][0])):
            print("Polygamy not allowed")
            return 0
    print(temp[0][2]+1,":",temp[0][3]+1,":",temp[0][1])
findBride()