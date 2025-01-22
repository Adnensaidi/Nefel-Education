from flask_app.config.mysqlconnection import connect_to_mysql
from flask import flash

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
        INSERT INTO users (first_name, last_name, email, password)
        VALUES (%(first_name)s, %(last_name)s, %(email)s, %(password)s)
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
        result = connect_to_mysql(cls.db).query_db(query, {"id": user_id})
        return cls(result[0]) if result else None

    @staticmethod
    def validate_registration(data):
        is_valid = True
        
        # Validation du prénom
        if len(data['first_name']) < 2:
            flash("Le prénom doit avoir au moins 2 caractères")
            is_valid = False
            
        # Validation du nom
        if len(data['last_name']) < 2:
            flash("Le nom doit avoir au moins 2 caractères")
            is_valid = False
            
        # Validation simple de l'email (juste vérifier s'il n'est pas vide)
        if len(data['email']) < 1:
            flash("L'email est requis")
            is_valid = False
            
        # Validation du mot de passe
        if len(data['password']) < 8:
            flash("Le mot de passe doit avoir au moins 8 caractères")
            is_valid = False
            
        if data['password'] != data['confirm_password']:
            flash("Les mots de passe ne correspondent pas")
            is_valid = False
            
        return is_valid