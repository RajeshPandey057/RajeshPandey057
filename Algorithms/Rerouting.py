def getMinConnectionChange(connection):
    server = {i+1:connection[i] for i in range(0,len(connection))}
    change = 0
    count = 0
    while len(server)!=1:
        key = next(iter(server))
        d=list(server.values())
        freq = max(set(d), key = d.count)
        count = d.count(freq)
        if count==len(server):
            break
        
        if(server[key]==key):
            if key == freq:
                temp=key+1
            else:
                temp=freq
            for k, v in server.items():
                if v == key:
                    server[k] = temp
            change+=1
            server.pop(key) 
        else:
            temp=server[key]
            for k, v in server.items():
                if v == key:
                    server[k] = temp
            server.pop(key)  
    return change
connection = [4,5,1,7,2,8,3,6,4,5]
print(getMinConnectionChange(connection))