from OOP.Animal import Animal 


class dog(Animal):
    def __init__(self, name, breed, tricks=None):
        super().__init__(name, "Dog", age)
        self.data["breed"]= breed
        self.data["tricks"]= tricks if tricks else []


    def add_trick(self,trick):
        self.data["tricks"].append(trick)
        print(f"self.data['name] learned a new trick: {trick}!")
        return self
    

    def list_tricks(self):
        if not self.data["tricks"]:
            return f"{self}"
