#Countdown
def countdown(a):
    for i in range(a,-1,-1):
        print(i)
    return a
countdown(5)

#Print and Return
def print_and_return(a,b):
    print(a)
    return b
print_and_return(1,2)

#First Plus Length
def first_plus_length(arr):
    sum = arr[0]+len(arr)
    return sum

print(first_plus_length([1,2,3,4,5]))

#Value Greater than Second
def values_greater_than_second(arr):
    new_arr = []
    nbr = arr[1]
    count = 0
    for i in range(len(arr)):
        if nbr < arr[i]:
            new_arr.append(arr[i])
            count = count +1
    print(count)    
    return new_arr
values_greater_than_second([5,2,3,2,1,4])

#This Length, That Value
def length_and_value(x,y):
    arr = []
    for i in range(x):
        arr.append(y)
    return arr
test = length_and_value(6,2)
print(test)