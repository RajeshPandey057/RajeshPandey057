def affine(msg, key):
    result = ""
    for i in range(len(msg)):
        if i == 0:
            result += chr(((ord(msg[i]) - 64) + key) % 26 + 64)
        else:
            result += chr(((ord(msg[i]) - 64) +
                           (ord(msg[i - 1]) - 64)) % 26 + 64)
    return result


key = int(input("Enter key : "))
msg = "THISISMYMESSAGE"
print("Plain text : "+msg)
print("Cipher text : "+affine(msg, key))
