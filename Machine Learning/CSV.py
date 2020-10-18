import pandas as pd
import numpy as np
import csv
print("Importing Using Standard Library\n")
with open('Iris.csv', 'r') as csv_file:
    reader = csv.reader(csv_file)

    for row in reader:
        print(row)
        print("Importing Using NumPy\n")
        data = np.loadtxt('Iris.csv', delimiter=",", skiprows=1)
        print(data)
    print("Importing Using Panda\n")
    data = pd.read_csv('Iris.csv', skiprows=1)
    print(data)
