class User:
    def __init__(self, first_name, last_name, email, age):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.age = age
        self.is_rewards_member = False
        self.gold_card_points = 0
    
    def display_info(self):
        print(f"name: {self.first_name} {self.last_name}")
        print(f"email: {self.email}")
        print(f"age : {self.age}")
        print(f"reward member : {self.is_rewards_member}")
        print(f"gold card points : {self.gold_card_points}")

    def enroll(self):
            if self.is_rewards_member:
                print(f"{self.first_name}user is alrady an the members")
                return False
            else:
                self.is_rewards_member = True
                self.gold_card_points = 200
                print(f"{self.first_name} has been enrolled in the rewards program")
                return True
            
    def spend_points(self, amount):
        self.gold_card_points

    
