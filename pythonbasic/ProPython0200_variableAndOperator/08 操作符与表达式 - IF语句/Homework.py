"""
Narcissistic Number
"""
num = int(input("Please enter a three-digit number:"))

a = num % 10
b = num // 10 % 10
c = num // 100

if num == a ** 3 + b ** 3 + c ** 3:
    print("It's a narcissistic number.")
else:
    print("It isn't  a narcissistic number.")


























