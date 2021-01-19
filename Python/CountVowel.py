vowel = ['a', 'e', 'i', 'o']
stg = list(input("Enter the string:"))
l = []
while ' ' in stg:
    stg.remove(' ')
for i in range(0, 26):
    l.append(0)
for i in stg:
    l[ord(i)-97] += 1
for i in vowel:
    print(i, ":", l[ord(i)-97])
