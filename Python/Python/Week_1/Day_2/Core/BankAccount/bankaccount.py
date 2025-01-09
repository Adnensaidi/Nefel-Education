class BankAccount :
    all_accounts = []

def __init__(self, int_rate=0.01,balance=0):
    self.int_rate = int_rate
    self.balance = balance
    BankAccount.all_accounts.append(self)

def deposit(self,amount):
    self.balance += amount
    return self

def withdraw(self, amount):
    if self.balance >= amount:
        self.balance -= amount 
    else:
        print("Insufficient funds: Charging a $5 fee")
        self.balance -= 5
    return self 

def display_account_info(self):
    print(f"Balance: ${self.balance}")
    return self

def yield_interest(self):
    if self.balance > 0:
        self.balance += self.balance * self.int_rate
    return self 

@classmethod
def print_all_accounts(cls):
    print("All Accounts")
for account in cls.all_accounts:
    account.display_account_info()

compte1 = BankAccount(0.01, 100)
compte2 = BankAccount(0.02)
compte1.deposit(100).deposit(200).deposit(300).withdraw(50).yield_interest().display_account_info()
