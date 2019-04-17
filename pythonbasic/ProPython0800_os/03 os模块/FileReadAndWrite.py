"""
List\tuple\dict\set File Operation
"""
# improt the data 持久性 module
import pickle

# Write the List into the file.
myList = [1, 2, 3, 4, 5, "Jackson"]
file = open(r"D:\demo.txt", "wb")
pickle.dump(myList, file)
file.close()

# Read the list from the demo.txt
file2 = open(r"D:\demo.txt", "rb")
tempList = pickle.load(file2)
print(tempList)
file2.close()















































































































