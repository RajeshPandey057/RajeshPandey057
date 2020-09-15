def graph(n):
    str1=[]
    a='A'
    for i in range(0,n):
        str1.append([])
        print("Connections with ",a)
        str1[i]=input()
        a=chr(ord(a)+1)
    mat=[]
    for i in range(0,n):
        a='a'
        mat.append([])
        for j in range(0,5):
            if(a in str1[i]):
                mat[i].append(1)
            else:
                mat[i].append(0)
            a=chr(ord(a)+1)
    return mat
        

