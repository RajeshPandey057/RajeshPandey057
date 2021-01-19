def num1(x):
    def num2(y):
        return x * y

    return num2


res = num1(10)

print(res(5))
