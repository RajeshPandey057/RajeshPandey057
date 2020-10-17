def permute(p, s, l):
    ns = ''
    for i in range(l):
        ns += s[p[i] - 1]
    return ns


def lcs(ss, n):
    rlcs = ''
    for i in range(len(ss)):
        rlcs += ss[(n+i) % 5]
    return rlcs


def spliter(s, d):
    split1 = s[0:d]
    split2 = s[d:]
    return(split1, split2)


def keygenerator(p10, p8, key):
    keyp = permute(p10, key, 10)
    ls1, ls2 = spliter(keyp, 5)
    ls1 = lcs(ls1, 1)
    ls2 = lcs(ls2, 1)
    ls = ls1 + ls2
    k1 = permute(p8, ls, 8)
    ls1 = lcs(ls1, 2)
    ls2 = lcs(ls2, 2)
    ls = ls1 + ls2
    k2 = permute(p8, ls, 8)
    return(k1, k2)


def doxor(s1, s2, l):
    c = ''
    for i in range(l):
        c = c + str(int(s1[i]) ^ int(s2[i]))
    return c


def stoi(sdata):
    return int(sdata, 2)


def giveindex(data):
    r = stoi(data[0]+data[3])
    c = stoi(data[1]+data[2])
    return (r, c)


p10 = [3, 5, 2, 7, 4, 10, 1, 9, 8, 6]
p8 = [6, 3, 7, 4, 8, 5, 10, 9]
p4 = [2, 4, 3, 1]
ip = [2, 6, 3, 1, 4, 8, 5, 7]
ep = [4, 1, 2, 3, 2, 3, 4, 1]
s1 = [['01', '00', '11', '10'], ['11', '10', '01', '00'],
      ['00', '10', '01', '11'], ['11', '01', '11', '10']]
s2 = [['00', '01', '10', '11'], ['10', '00', '01', '11'],
      ['11', '00', '01', '00'], ['10', '01', '00', '11']]
key = '1010000010'
plaintext = '01100010'
ipinv = []
for i in range(8):
    ipinv.append(ip.index(i+1)+1)
key1, key2 = keygenerator(p10, p8, key)
plaintextip = permute(ip, plaintext, 8)
l0, r0 = spliter(plaintextip, 4)
# Round 1
u_r0 = permute(ep, r0, 8)  # Expansion Permutation
xorout = doxor(u_r0, key1, 8)  # XOR operation with key
sbx1, sbx2 = spliter(xorout, 4)  # Spliting of output of xor operation
# Getting index for sbox s1 & s2 from splited string
r1r1, r1c1 = giveindex(sbx1)
r1r2, r1c2 = giveindex(sbx2)
u_r0 = s1[r1r1][r1c1]+s2[r1r2][r1c2]  # Getting according data from s-boxes
u_r0 = permute(p4, u_r0, 4)  # Last 4 bit permutation
# end of Round 1
r1 = doxor(l0, u_r0, 4)  # Swaping for Round-2
l1 = r0
# Round 2
u_r1 = permute(ep, r1, 8)  # Expansion Permutation
xorout = doxor(u_r1, key2, 8)  # XOR operation with key
sbx1, sbx2 = spliter(xorout, 4)  # Spliting of output of xor operation
# Getting index for sbox s1 & s2 from splited string
r2r1, r2c1 = giveindex(sbx1)
r2r2, r2c2 = giveindex(sbx2)
u_r1 = s1[r2r1][r2c1]+s2[r2r2][r2c2]  # Getting according data from s-boxes
u_r1 = permute(p4, u_r1, 4)  # Last 4 bit permutation
u_r1 = doxor(u_r1, l1, 4)
# end of Round 2
last = u_r1+r1
# Permutation with inverse of initial permutation(ip)
ciphertext = permute(ipinv, last, 8)
print("Plain Text : ", plaintext)
print("Cipher Text : ", ciphertext)
