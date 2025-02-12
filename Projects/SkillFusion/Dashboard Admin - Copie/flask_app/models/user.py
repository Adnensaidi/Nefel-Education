from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE

class User:
    def __init__(self, data):
        self.id = data['id']
        self.username = data['username']
        self.email = data['email']
        self.password = data['password']
        self.profile_pic = data['profile_pic']
        self.bio = data['bio']
        self.type_user = data['type_user']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.status = data.get('status')

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users;"
        results = connectToMySQL(DATABASE).query_db(query)
        students = []
        for student in results:
            students.append(cls(student))
        return students

    @classmethod
    def get_all_requests(cls):
        query = "SELECT * FROM users WHERE status = 'pending';"
        results = connectToMySQL(DATABASE).query_db(query)
        if results is False:
            return []
        requests = []
        for request in results:
            requests.append(cls(request))
        return requests

    @classmethod
    def get_by_id(cls, data):
        query = "SELECT * FROM users WHERE id = %(id)s;"
        results = connectToMySQL(DATABASE).query_db(query, data)
        if results:
            return cls(results[0])
        return None

    @classmethod
    def save(cls, data):
        query = """
            INSERT INTO users (username, email, password, profile_pic, bio, type_user)
            VALUES (%(username)s, %(email)s, %(password)s, %(profile_pic)s, %(bio)s, %(type_user)s);
        """
        return connectToMySQL(DATABASE).query_db(query, data)

    @classmethod
    def update(cls, data):
        query = """
            UPDATE users
            SET username = %(username)s, email = %(email)s, profile_pic = %(profile_pic)s, bio = %(bio)s
            WHERE id = %(id)s;
        """
        return connectToMySQL(DATABASE).query_db(query, data)

    @classmethod
    def delete(cls, data):
        query = "DELETE FROM users WHERE id = %(id)s;"
        return connectToMySQL(DATABASE).query_db(query, data)
