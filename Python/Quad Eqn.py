# -*- coding: utf-8 -*-
"""
@author: Shadow
Diving Right IN
"""
import math
A = float(input('Enter the a:'))
B = float(input('Enter the b:'))
C = float(input('Enter the c:'))
D = B*B - 4*A*C
AA = (-B + math.sqrt(D))/2*A
BB = (-B - math.sqrt(D))/2*A
print('The Solution of this equations is ', AA, BB)
