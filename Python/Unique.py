def unique_in_list(l):
    return list(set(l))


l = list(map(int, input("Enter List:").split(' ')))
l = unique_in_list(l)
print("Unique elements in list:")
print(l)
l = list(map(int, input("Enter List:").split(' ')))
mul = 1
for i in l:
    mul *= i
print("Multiplication of whole list:")
print(mul)
l = list(map(int, input("Enter List:").split(' ')))
mul = 1
for i in l:
    mul *= i
print("Multiplication of whole list:")
print(mul)
