# -*- coding: utf-8 -*-
"""
@author: Shadow
Diving Right IN
"""
import math


def arm(n):
    b = int(math.log10(n))
    k = b
    n1 = n
    i = 0
    d = []
    while (b >= 0):
        d.append(int(n/math.pow(10, b)))
        n = n-d[i]*math.pow(10, b)
        i = i+1
        b = b-1
    sum = 0
    for i in d:
        sum = sum + math.pow(i, k+1)
    if(sum == n1):
        print(n1)


for i in range(1, int(input("Enter Max:"))):
    arm(i)
