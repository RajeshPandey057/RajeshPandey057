class Reverser:
    def do_it(self, string):
        temp = string.split(' ')
        temp = reversed(temp)
        return " ".join(temp)


String_reverse_obj = Reverser()
stg = input("Enter String:")
print("Reversed string :", String_reverse_obj.do_it(stg))
