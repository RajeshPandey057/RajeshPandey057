def fib(term):
    if term > 2:
        return fib(term - 1) + fib(term - 2)
    else:
        return 1


k = int(input("Enter term you want to know:"))
print("Number is :", fib(k))
