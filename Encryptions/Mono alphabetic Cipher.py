def mapping(msg, dic):
    result = ""
    for i in message:
        if i in mydict.keys():
            result += mydict[i]
        else:
            result += i
    return result


list1 = []
list2 = ['B', 'Q', 'W', 'T', 'N', 'O', 'R', 'J', 'D', 'H', 'Y', 'E',
         'F', 'P', 'U', 'M', 'V', 'I', 'L', 'A', 'Z', 'X', 'C', 'S', 'K', 'G']
for j in range(0, 26):
    list1.append(chr(97+j))
mydict = dict(zip(list1, list2))
message = "this is my message contain"
print("Plain text : "+message)
print("Cipher text : "+mapping(message, mydict))
