import os
import uuid
from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE

class Teacher:
    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.subject = data['subject']
        self.experience = data['experience']
        self.cv_file = data['cv_file']
        self.status = data['status']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def save(cls, data):
        query = """
            INSERT INTO teachers (name, subject, experience, cv_file, status) 
            VALUES (%(name)s, %(subject)s, %(experience)s, %(cv_file)s, 'Pending');
        """
        return connectToMySQL(DATABASE).query_db(query, data)

    @classmethod
    def get_all_pending(cls):
        query = "SELECT * FROM teachers WHERE status = 'Pending';"
        results = connectToMySQL(DATABASE).query_db(query)
        return [cls(row) for row in results]

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM teachers;"
        results = connectToMySQL(DATABASE).query_db(query)
        return [cls(row) for row in results]

    @classmethod
    def get_one(cls, data):
        query = "SELECT * FROM teachers WHERE id = %(id)s;"
        result = connectToMySQL(DATABASE).query_db(query, data)
        if result:
            return cls(result[0])
        return None

    @classmethod
    def update_status(cls, data):
        query = "UPDATE teachers SET status = %(status)s WHERE id = %(id)s;"
        return connectToMySQL(DATABASE).query_db(query, data)

    @classmethod
    def save_cv(cls, file):
        upload_folder = 'uploads'
        if not os.path.exists(upload_folder):
            os.makedirs(upload_folder)

        allowed_extensions = ['.pdf', '.doc', '.docx']
        file_extension = os.path.splitext(file.filename)[1].lower()
        if file_extension not in allowed_extensions:
            raise ValueError("Invalid file type. Only PDF and DOCX are allowed.")

        unique_filename = str(uuid.uuid4()) + file_extension
        file_path = os.path.join(upload_folder, unique_filename)
        file.save(file_path)

        return unique_filename
