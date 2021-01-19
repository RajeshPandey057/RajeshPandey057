import matplotlib.pyplot as plt
import numpy as np

# bar graph:
plt.bar([1, 3, 5, 7, 9], [5, 2, 7, 8, 2], label="Example one")
plt.bar([2, 4, 6, 8, 10], [8, 6, 2, 5, 6], label="Example two", color="g")
plt.legend()
plt.xlabel("bar number")
plt.ylabel("bar height")
plt.title("First Bar Graph")
plt.show()


# histogram:
N = 100
x = np.random.rand(N)
y = np.random.rand(N)
colors = (0, 100, 255)
area = np.pi * 3
plt.scatter(x, y)
plt.title('Scatter plot example using matplotlib')
plt.xlabel('x')
plt.ylabel('y')
plt.show()
