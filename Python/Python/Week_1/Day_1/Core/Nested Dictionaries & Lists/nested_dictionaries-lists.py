# 1. Update Values in Dictionaries and Lists

x = [ [5,2,3], [10,8,9] ] 
students = [
    {'first_name':  'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]

# Change the value 10 in x to 15. Once you're done, x should now be [ [5,2,3], [15,8,9] ].

x[1][0] = 15 

# Change the last_name of the first student from 'Jordan' to 'Bryant'

students[0]['last_name'] = 'Bryant'

# In the sports_directory, change 'Messi' to 'Andres'

sports_directory['soccer'][0]= 'Andres'

# Change the value 20 in z to 30

z[0]['y']= 30

# 2. Iterate Through a List of Dictionaries

students = [
        {'first_name':  'Michael', 'last_name' : 'Jordan'},
        {'first_name' : 'John', 'last_name' : 'Rosales'},
        {'first_name' : 'Mark', 'last_name' : 'Guillen'},
        {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]

def iteratedictionary(list):
    for dict in list :
        for key, val in dict.items():
            print(key, " - ", val)

iteratedictionary(students)

# 3. Get Values From a List of Dictionaries



students = [
        {'first_name':  'Michael', 'last_name' : 'Jordan'},
        {'first_name' : 'John', 'last_name' : 'Rosales'},
        {'first_name' : 'Mark', 'last_name' : 'Guillen'},
        {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]

def iterateDictionary2(key_name, students):
    for student in students:
            print(student[key_name])

# 4. Iterate Through a Dictionary with List Values

def printInfo(some_dict):
    for key, value_list in some_dict.items():
        print(f"{len(value_list)} {key.upper()}")
        for value in value_list:
            print(value)
        print("")

students = [
    {'first_name': 'Michael', 'last_name': 'Jordan'},
    {'first_name': 'John', 'last_name': 'Rosales'},
    {'first_name': 'Mark', 'last_name': 'Guillen'},
    {'first_name': 'KB', 'last_name': 'Tonel'}
]

dojo = {
    'locations':['San Jose', 'Seattle', 'Dallas','Chicago','Tulsa','DC','Burbank'],
    'instructors':['Michael','Amy','Eduardo','Josh','Graham','Patrick','Minh','Devon']
}