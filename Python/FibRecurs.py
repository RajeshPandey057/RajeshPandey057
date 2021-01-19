def fib(term):
    if term > 2:
        return fib(term - 1) + fib(term - 2)
    else:
        return 1


k = int(input("Enter up to which term you want to know:"))
for i in range(1, k + 1):
    print(fib(i))
