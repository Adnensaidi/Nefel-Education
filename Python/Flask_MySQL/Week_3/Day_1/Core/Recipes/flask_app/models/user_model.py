from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
from flask import flash 
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$') 


class User:
    def __init__(self,data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name= data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def register(cls, data):
        query= "INSERT INTO users (first_name, last_name, email, password) VALUES (%(first_name)s,%(last_name)s, %(email)s, %(password)s);"
        return connectToMySQL(DATABASE).query_db(query, data)
    

    @classmethod
    def get_by_email(cls, data):
        query = "SELECT * FROM users WHERE email = %(email)s;"
        result = connectToMySQL(DATABASE).query_db(query, data)
        if result: 
            return cls(result[0])
        return False
    
    @classmethod
    def get_by_id(cls, data):
        query = "SELECT * FROM users WHERE id = %(id)s;"
        result = connectToMySQL(DATABASE).query_db(query, data)
        if result: 
            return cls(result[0])
        return False
        
    @staticmethod
    def validation(data):
        is_valid = True
        if len(data['first_name'])<3:
            is_valid = False
            flash("Name must contain at least 3 characters!", "first_name")
        if len(data['last_name'])<3:
            is_valid = False
            flash("Name must contain at least 3 characters!", "last_name")
        if not EMAIL_REGEX.match(data['email']):
            flash("Email not valid", "email")
            is_valid = False
        elif User.get_by_email({'email': data['email']}):
            flash("Email already taken" , "email")
            is_valid = False
        if len(data['password'])<8:
            flash("Password must contain at least 8 characters", "password")
            is_valid= False
        elif data['password'] != data['confirm_password']:
            flash("Passwords must match", "confirm_password")
            is_valid = False
        return is_valid