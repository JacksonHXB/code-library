"""
Find the second largest value from the input 6 numbers.
"""
# Define the initial value
num = 0
numList = []

while num < 6:
    # Get the value entered by user.
    val = int(input("Please enter the %d-th number:" %(num + 1)))
    # Insert per value into the numList.
    numList.append(val)
    # Each increment by one.
    num += 1
print("Original List:", numList)

# Sort the list
numList.sort()

# Get the times of maximum
count = numList.count(numList[len(numList) - 1])

# Remove all maximums
c = 0
while c < count:
    numList.pop()
    c += 1

# Get the maximum after remove
print("The second largest value:%d" %(numList[len(numList) - 1]))






















