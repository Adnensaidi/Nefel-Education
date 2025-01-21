from flask_app.config.mysqlconnection import connect_to_mysql
from flask import flash
from flask_bcrypt import Bcrypt
from flask_app import app

bcrypt = Bcrypt(app)

class User:
    db = "login_registration_schema"

    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def save(cls, data):
        query = """
        INSERT INTO users (first_name, last_name, email, password, created_at, updated_at)
        VALUES (%(first_name)s, %(last_name)s, %(email)s, %(password)s, NOW(), NOW());
        """
        return connect_to_mysql(cls.db).query_db(query, data)

    @classmethod
    def get_by_email(cls, data):
        query = "SELECT * FROM users WHERE email = %(email)s;"
        result = connect_to_mysql(cls.db).query_db(query, data)
        return cls(result[0]) if result else None

    @classmethod
    def get_by_id(cls, user_id):
        query = "SELECT * FROM users WHERE id = %(id)s;"
        data = {"id": user_id}
        result = connect_to_mysql(cls.db).query_db(query, data)
        return cls(result[0]) if result else None

    @staticmethod
    def validate_registration(data):
        is_valid = True
        if len(data['first_name']) < 2 or not data['first_name'].isalpha():
            flash("First name must be at least 2 characters and letters only", "register")
            is_valid = False
        if len(data['last_name']) < 2 or not data['last_name'].isalpha():
            flash("Last name must be at least 2 characters and letters only", "register")
            is_valid = False
        if not data['email']:
            flash("Email is required", "register")
            is_valid = False
        if len(data['password']) < 8 or not any(char.isdigit() for char in data['password']) or not any(char.isupper() for char in data['password']):
            flash("Password must be at least 8 characters, include a number and an uppercase letter", "register")
            is_valid = False
        if data['password'] != data['confirm_password']:
            flash("Passwords must match", "register")
            is_valid = False
        return is_valid

    @staticmethod
    def check_password(password, hashed_password):
        return bcrypt.check_password_hash(hashed_password, password)