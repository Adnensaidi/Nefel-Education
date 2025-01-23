from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
from flask import flash
from datetime import date, datetime



class Recipe:
    def __init__(self,data):
        self.id = data["id"]
        self.name = data["name"]
        self.description = data["description"]
        self.instruction = data["instruction"]
        self.under_30_min = data["under_30_min"]
        self.date_made = data["date_made"]
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]
        self.user_id = data["user_id"]
        self.creator =""

    
    @classmethod
    def create(cls, data):
        query = """INSERT INTO recipes (name, description,instruction, under_30_min, date_made, user_id) 
        VALUES (%(name)s, %(description)s, %(instruction)s, %(under_30_min)s, %(date_made)s, %(user_id)s);"""
        return connectToMySQL(DATABASE).query_db(query,data)#* this method will return the id 
    

    @classmethod
    def get_all(cls):
        query = """SELECT recipes.*, users.first_name, users.last_name 
                FROM recipes
                JOIN users ON recipes.user_id = users.id;"""
        results = connectToMySQL(DATABASE).query_db(query)
        recipes = []  # Liste pour stocker les instances de `Recipe`.
        for row in results:
            recipe = cls(row)  # Convertit chaque dictionnaire en instance de `Recipe`.
            recipe.creator = f"{row['first_name']} {row['last_name']}"  # Récupère le nom complet du créateur.
            recipes.append(recipe)
        return recipes

    @classmethod
    def show_one(cls, data):
        query = """SELECT recipes.*, users.first_name, users.last_name 
                FROM recipes 
                JOIN users ON users.id = recipes.user_id 
                WHERE recipes.id = %(id)s;"""
        result = connectToMySQL(DATABASE).query_db(query, data)
        if len(result) < 1:
            return False
        recipe = cls(result[0])  # Convertit le premier résultat en instance de `Recipe`.
        recipe.creator = f"{result[0]['first_name']} {result[0]['last_name']}"  # Ajoute le nom complet du créateur.
        return recipe
    
    @classmethod
    def delete(cls, data):
        query = "DELETE FROM recipes WHERE id = %(id)s;"
        return connectToMySQL(DATABASE).query_db(query, data)

    @staticmethod
    def validate(data):
        is_valid = True
        
        # Validate name
        if len(data.get("name", "").strip()) < 3:
            flash("Name must be at least 3 characters long.", "name")
            is_valid = False
        
        # Validate description
        if len(data.get("description", "").strip()) < 10:
            flash("Description must contain at least 10 characters.", "description")
            is_valid = False
        
        # Validate instruction
        if len(data.get("instruction", "").strip()) < 10:
            flash("Instruction must contain at least 10 characters.", "instruction")
            is_valid = False
        
        # Validate under_30_min
        if "under_30_min" not in data or data["under_30_min"] not in [0, 1]:
            flash("Please specify if the recipe is under 30 minutes (0 or 1).", "under_30_min")
            is_valid = False
        
        # Validate date_made
        try:
            recipe_date = datetime.strptime(data.get("date_made", ""), "%Y-%m-%d").date()
            if recipe_date > date.today():
                flash("Date must be in the past.", "date_made")
                is_valid = False
        except ValueError:
            flash("Invalid date format. Use YYYY-MM-DD.", "date_made")
            is_valid = False
        # Validate user_id
        if not data.get("user_id"):
            flash("User ID is required.", "user_id")
            is_valid = False
        return is_valid