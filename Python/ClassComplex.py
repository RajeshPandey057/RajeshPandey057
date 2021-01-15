class Complex:
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y

    def __add__(self, other):
        return Complex(self.x+other.x, self.y+other.y)

    def __str__(self):
        return "("+str(self.x)+")"+"+i("+str(self.y)+")"


c1 = Complex(2, 3)
c2 = Complex(5, -87)
print(c1+c2)
