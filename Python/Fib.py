# -*- coding: utf-8 -*-
"""
@author: Shadow
Diving Right IN
"""


def fib(n):
    if(n == 1 or n == 2):
        return 1
    else:
        return fib(n-1)+fib(n-2)


for i in range(1, int(input("Enter Max:"))):
    fib(i)
