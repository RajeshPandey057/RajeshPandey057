# -*- coding: utf-8 -*-
"""
@author: Shadow
Diving Right IN
"""

a = int(input('Enter the Min:'))
b = int(input('Enter the Max:'))
for i in range(a, b+1):
    for j in range(2, (i//2)+1):
        if(i % j == 0):
            break
    else:
        print(i)
