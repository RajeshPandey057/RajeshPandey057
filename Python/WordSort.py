string_arrays = input("Enter strings:").split()
string_arrays.sort()
print("Sorted Data:")
print(*string_arrays, sep='\n')
