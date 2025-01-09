from OOP.Animal import Animal 


class Cat(Animal):
    def __init__(self, name, age, fur_color,favorite_toys=None):
        super().__init__(name, "cat", age)
        self.data["fur_color"] = fur_color
        self.data["favorite_toys"]= favorite_toys if favorite_toys else []

    def add_toy(self, toy):
        self.data["favorite_toys"].append(toy)
        print(f"{self.data['name']} loves playing with the new toy: {toy}.")
        return self
    
    def list_toys(self):
        if not self.data["favorite_toys"]:
            return f"{self.data['name']} has no favorite toys yet."
        toys = ""
        for toy in self.data["favoritte_toys"]:
            toys += toy + ", "
            print(f"{self.data['name']}'s favorite toys are: {toys}.")