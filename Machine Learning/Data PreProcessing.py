import numpy as np
from sklearn import preprocessing

input_data = np.array(
    [[3, -1.5, 3, -6.4], [0, 3, -1.3, 4.1], [1, 2.3, -2.9, 4.3]])
# this function makes mean of data near to zero and standard
data_standardized = preprocessing.scale(input_data)
# deviation nearer to 1
data2 = preprocessing.scale([0, 12, 34, 6, -99])

print(data_standardized)
print(sum(data_standardized[0])/4)
print(data2)
print(data2/len(data2))

print("\nMean =", data_standardized.mean(axis=0))
print("Std deviation =", data_standardized.std(axis=0))

data_normalized = preprocessing.normalize(input_data, norm='l1')
print("\nL1 normalized data =", data_normalized)

data_binarized = preprocessing.Binarizer(threshold=1.4).transform(input_data)
print("\nBinarized data =", data_binarized)

encoder = preprocessing.OneHotEncoder()
encoder.fit([[0, 2, 1, 12], [1, 3, 5, 3], [2, 3, 2, 12], [1, 2, 4, 3]])
encoded_vector = encoder.transform([[2, 3, 5, 3]]).toarray()
print("\nEncoded vector =", encoded_vector)
