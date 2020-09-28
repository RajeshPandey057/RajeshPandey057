def receivedText(S):
    l=list(S)
    numLock = True
    result = []
    temp = []
    for i in l:
        if(i=='<'):
            if(temp):
                result+=temp
            temp = result
            result = []
        elif(i=='>'):
            result =  result + temp
            temp = []
        elif(i=='*' and result):
            result.pop()
        elif(i=='#'):
            numLock = not numLock
        else:
            if(numLock):
                result.append(i)
            elif(i.isdigit()!=True ):
                result.append(i)
    result = result + temp
    return  (''.join(str(i) for i in result))
print(receivedText(input()))