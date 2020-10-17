def Polysub(msg, key):
    key_len = len(key)
    result = ""
    for i in range(len(msg)):
        if msg[i] == ' ' or msg[i] == '\n' or msg[i] == '.':
            result = result + msg[i]
        else:
            result = result + chr(((ord(msg[i])-65+key[i % key_len]) % 26)+65)
    return result


key = [1, 5, 3, 7]
msg = "THIS IS MY MESSAGE CONTAIN"
print("Plain text : "+msg)
print("Cipher text : "+Polysub(msg, key))
