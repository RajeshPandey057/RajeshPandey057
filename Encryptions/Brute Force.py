s = "fdmhtr"
shift = -25
for i in range(1, 52):
    sm = " "
    print("key :" + str(shift))
    for j in s:
        sti = ord(j) + shift
        sm = sm + str(chr(sti))
    print("Decrypt word:"+sm)
    shift += 1
