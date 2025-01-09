class Pet:
    def __init__(self, name, type, tricks):
        self.name = name
        self.type = type
        self.tricks = tricks
        self.health = 100
        self.energy = 100

    def sleep(self):
        self.energy += 25
        print(f"{self.name} is sleeping. Energy increased to {self.energy}")
        return self
    
    def eat(self):
        self.energy += 5
        self.health += 10
        print(f"{self.name} is eating. Energy: {self.energy}, Health:{self.health}")
        return self
    
    def play(self):
        self.health += 5
        print(f"{self.name} is playing! Health increased to {self.health}")
        return self
    
    def noise(self):
        if self.type.lower() == "dog":
            sound = "Woof!"
        elif self.type.lower() == "cat":
            sound = "Meow!"
        else:
            sound = ""
        print(f"{self.name} says: {sound}")

    class Ninja:
        def __init__(self, first_name, last_name, treats, pet_food, pet):
            self.first_name = first_name
            self.last_name = last_name
            self.treats = treats
            self.pet_food = pet_food
            self.pet = pet
        
        def walk(self):
            print(f"{self.first_name} takes {self.pet.name} for a walk!")
            self.pet.play()

        def feed(self):
            print(f"{self.first_name} feeds {self.pet.name}{self.pet_food}!")
            self.pet.eat()
            return self
        
        def bathe(self):
            print(f"{self.first_name} bathes {self.pet.name}!")
            self.pet.noise()
            return self
    my_pet = Pet("Rex", "Dog", ["sit","roll over"])
    ninja = Ninja("John", "Doe","dog biscuits","kibble",my_pet)
    ninja.feed().walk().bathe()