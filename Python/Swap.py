# -*- coding: utf-8 -*-
"""
@author: Shadow
Diving Right IN
"""

A = float(input('Enter the a:'))
B = float(input('Enter the b:'))
print("Swapping\n")
A, B = B, A
C = input('Press 1 to print a or anything else to print b\n')
if(C == '1'):
    print(A)
else:
    print(B)
