"""
Homework
"""
str = input("Please enter a number:")
index = 0
sum = 0
while index < len(str):
    if str[index] >= "0" and str[index] <= "9":
        sum += int(str[index])
    index += 1
print("sum = %d" %(sum))


"""
Comparison of strings
"""
# Starting with the first character,the larger the ASCII value is.
# If the Ascii value the first character is equal,then the ASCII value of the next character is compared.
print("ms" == "mk")
































