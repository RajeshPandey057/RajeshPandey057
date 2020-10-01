
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
Y=pd.read_csv("D:\Educational\Machine Learning\Book1.csv")
X=Y.iloc[:,[0,1]].values
plt.plot(X[:,0],X[:,1])
plt.title("Graph of Age vs Salary")
plt.xlabel("Age")
plt.ylabel("SAlary")
plt.show()