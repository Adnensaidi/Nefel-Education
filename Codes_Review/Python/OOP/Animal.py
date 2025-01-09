class Animal: 
    def __init__(self, name , species , age ):
        self.data = {
            "name": name,
            "species": species,
            "age": age
        }

    def get_info(self):
        print(f"{self.data['name']} is a {self.data['age']}- year-old {self.data['species']}.")
        return self
    

    def age_up(self):
        self.data["age"] += 1
        print(f"{self.data['name']} is now {self.data['age']} years old.")
        return self
    
    def describe(self):
        return f"{self.data['name']} is {self.data['age']}"