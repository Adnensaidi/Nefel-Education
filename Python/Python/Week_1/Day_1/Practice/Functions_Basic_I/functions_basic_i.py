#1
def number_of_food_groups():
    return 5
print(number_of_food_groups())

#It will print the number 5

#2
def number_of_military_branches():
    return 5
print(number_of_days_in_a_week_silicon_or_triangle_sides() + number_of_military_branches())

#It will be an error because "number_of_days_in_a_week_silicon_or_triangle_sides()" does not defined


#3
def number_of_books_on_hold():
    return 5
    return 10
print(number_of_books_on_hold())

#It will return 5 because in python when return exist, that tells the function it end of it 


#4
def number_of_fingers():
    return 5
    print(10)
print(number_of_fingers())

#It will print 5 print 10 is in the function


#5
def number_of_great_lakes():
    print(5)
x = number_of_great_lakes()
print(x)

#It will show 5 twice 
#We did not get it when the terminal print with the 5s "None" 


#6
def add(b,c):
    print(b+c)
print(add(1,2) + add(2,3))

#It will print error


#7
def concatenate(b,c):
    return str(b)+str(c)
print(concatenate(2,5))

#It will print "25" because it's a string 


#8
def number_of_oceans_or_fingers_or_continents():
    b = 100
    print(b)
    if b < 10:
        return 5
    else:
        return 10
    return 7
print(number_of_oceans_or_fingers_or_continents())

#It will print 100 and 10


#9
def number_of_days_in_a_week_silicon_or_triangle_sides(b,c):
    if b<c:
        return 7
    else:
        return 14
    return 3
print(number_of_days_in_a_week_silicon_or_triangle_sides(2,3))
print(number_of_days_in_a_week_silicon_or_triangle_sides(5,3))
print(number_of_days_in_a_week_silicon_or_triangle_sides(2,3) + number_of_days_in_a_week_silicon_or_triangle_sides(5,3))


#condition 1: result = 7
#condition 2: result = 14
#condition 3: result = 21

#10
def addition(b,c):
    return b+c
    return 10
print(addition(3,5))

# Result = 8


#11
b = 500
print(b)
def foobar():
    b = 300
    print(b)
print(b)
foobar()
print(b)

# result 1: b = 500
# result 2: b = 500
# result 3: b = 300
# result 4: b = 500


#12
b = 500
print(b)
def foobar():
    b = 300
    print(b)
    return b
print(b)
foobar()
print(b)

#result1: b=500 
#result2: b= 500
#result: print the print first 300 then print the returned value 300
#result: b= 500


#13
b = 500
print(b)
def foobar():
    b = 300
    print(b)
    return b
print(b)
b=foobar()
print(b)

#result 1 : b = 500
#result 2 : b = 500
#result 3 : b = 300



#14
def foo():
    print(1)
    bar()
    print(2)
def bar():
    print(3)
foo()

#Result: 1
#        3
#        2


#15
def foo():
    print(1)
    x = bar()
    print(x)
    return 10
def bar():
    print(3)
    return 5
y = foo()
print(y)

#result: 1, 3, 5, 10