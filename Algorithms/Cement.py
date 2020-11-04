#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'cementDistribution' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER_ARRAY increaseRate
#  2. INTEGER_ARRAY sites
#


def cementDistribution(increaseRate, sites):
    # Write your code here
    y = 1
    increaseRate.reverse()
    t = 0
    while 1:
        t = y
        for i, val in enumerate(increaseRate):
            if t % val != 0:
                f = 1
                break
            else:
                t = t / val + y
        if f == 1:
            y += 1
        else:
            break
    return [y, t]


if __name__ == "__main__":

    increaseRate_count = int(input().strip())

    increaseRate = []

    for _ in range(increaseRate_count):
        increaseRate_item = int(input().strip())
        increaseRate.append(increaseRate_item)

    sites_count = int(input().strip())
    sites = []

    for _ in range(sites_count):
        sites_item = int(input().strip())
        sites.append(sites_item)

    result = cementDistribution(increaseRate, sites)

    print("\n".join(map(str, result)))
    print("\n")
