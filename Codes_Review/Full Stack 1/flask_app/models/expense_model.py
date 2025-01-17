from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE


class Expense:
    def __init__(self,data):
        self.id = data["id"]
        self.category = data["category"]
        self.description = data["description"]
        self.amount = data["amount"]
        self.expense_date = data["expense_date"]
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]

    @classmethod
    def create(cls, data):
        query = """INSERT INTO expenses (category, description, amount, expense_date) 
        VALUES (%(category)s, %(description)s, %(amount)s, %(expense_date)s);"""
        return connectToMySQL(DATABASE).query_db(query,data)
    
    @classmethod
    def get_all(cls):
        query="SELECT * FROM expenses;"
        #* results contain a list of dictionaires
        results = connectToMySQL(DATABASE).query_db(query)
        #* organize the results ( making a list of Expense instances instead of list of dictionaries)
        expenses=[]
        for row in results: 
            expenses.append(cls(row))
        return expenses
    
    @classmethod
    def show_one(cls, data):
        query = "SELECT * FROM expenses WHERE id = %(id)s;"
        result = connectToMySQL(DATABASE).query_db(query, data)
        if len(result)<1:
            return False
        return cls(result[0])
    
    @classmethod
    def update(cls,data):
        query = """ UPDATE expenses SET 
                    category = %(category)s,
                    description = %(description)s,
                    amount = %(amount)s,
                    expense_date = %(expense_date)s
                    WHERE id = %(id)s;
                """
        return connectToMySQL(DATABASE).query_db(query, data)
    
    @classmethod
    def delete(cls, data):
        query="DELETE FROM expenses WHERE id = %(id)s;"
        return connectToMySQL(DATABASE).query_db(query, data)
    