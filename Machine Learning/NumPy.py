import pandas
import matplotlib.pyplot as plt
import numpy

myList = [1, 2, 3, 4]
na = numpy.array(myList)
print(na.shape)

del myList
myList = [[1, 2, 3], [4, 5, 6]]
myArray = numpy.array(myList)
print(myArray.shape)
print("First row: ", myArray[0])
print("Last row: ", myArray[-1])
print("Whole col: ", myArray[:, 2])


myarray = numpy.array([1, 2, 3, 90])
plt.plot(myarray)
plt.xlabel('some x axis')
plt.ylabel('koik y axis')
plt.show()

myarray1 = numpy.array([1, 2, 3, 33, 35])
myarray2 = numpy.array([4, 5, 6, 21, 11])
plt.scatter(myarray1, myarray2)
plt.xlabel('some x axis')
plt.ylabel('koik y axis')
plt.show()

del myArray
del myarray
del myarray2
del myarray1

myArray = numpy.array([1, 6, 98, 34])
row_name = ['a', 'b', 'c', 'd']
mySeries = pandas.Series(myArray, index=row_name)
print(mySeries)
del myArray
del mySeries

myArray = numpy.array(myList)
row_name = ['a', 'b']
col_name = ['ek', 'be', 'tain']
mdf = pandas.DataFrame(myArray, index=row_name, columns=col_name)
print(mdf)
