from OOP.Cat import Cat
from OOP.Dog import Dog

dog_one = Dog('Rocky', 4,"Pitbull")
dog_two = Dog("Marley",7,"German shepherd", tricks = ["Bring the ball"])

dog_one.add_trick("sit").list_tricks()

dog_two.add_trick("roll over").list_tricks()

dog_two.describe()