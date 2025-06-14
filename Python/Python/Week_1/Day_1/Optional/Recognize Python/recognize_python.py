num1 = 42 
num2 = 2.3 
boolean = True 
string = 'Hello World' 

pizza_toppings = ['Pepperoni', 'Sausage', 'Jalepenos', 'Cheese', 'Olives']

person = {'name': 'John', 'location': 'Salt Lake', 'age': 37, 'is_balding': False}

fruit = ('blueberry', 'strawberry', 'banana')
print(type(fruit))

print(pizza_toppings[1])

pizza_toppings.append('Mushrooms')

print(person['name'])

person['name'] = 'George'
person['eye_color'] = 'blue'

print(fruit[2])

if num1 > 45:
    print("It's greater")
else:
    print("It's lower")

if len(string) < 5:
    print("It's a short word!")
elif len(string) > 15:
    print("It's a long word!")
else:
    print("Just right!")

for x in range(5):
    print(x)
for x in range(2,5):
    print(x)
for x in range(2,10,3):
    print(x)

x = 0
while(x < 5):
    print(x)
    x += 1

pizza_toppings.pop()
pizza_toppings.pop(1)

print(person)
person.pop('eye_color')
print(person)

for topping in pizza_toppings:
    if topping == 'Pepperoni':
        continue
    print('After 1st if statement')
    if topping == 'Olives':
        break

# function declaration
def print_hello_ten_times():
    # for loop starts at 0 goes up until 10
    for num in range(10):
        # print to console
        print('Hello')

# Function Call
print_hello_ten_times()

# function Declaration with parameter x
def print_hello_x_times(x):
    # For loop up until a given number x
    for num in range(x):
        # print to console
        print('Hello')

# function call arguement of 4
print_hello_x_times(4)

# function declaration with default parameter
def print_hello_x_or_ten_times(x = 10):
    # For loop until x
    for num in range(x):
        # print to console
        print('Hello')

# Function call goes to 10
print_hello_x_or_ten_times()
# function call goes to 4
print_hello_x_or_ten_times(4)

