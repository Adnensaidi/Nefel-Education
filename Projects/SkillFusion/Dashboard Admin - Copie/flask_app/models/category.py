from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
from flask_app.models.teacher import Teacher

class Category:
    def __init__(self, data):
        self.id = data['id']
        self.title = data['title']
        self.description = data['description']
        self.image = data['image']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.teachers = []


    @classmethod
    def save(cls, data):
        query = """
            INSERT INTO categories (title, description, image) 
            VALUES (%(title)s, %(description)s, %(image)s);
        """
        return connectToMySQL(DATABASE).query_db(query, data)

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM categories;"
        results = connectToMySQL(DATABASE).query_db(query)
        return [cls(row) for row in results]

    @classmethod
    def get_one(cls, data):
        query = "SELECT * FROM categories WHERE id = %(id)s;"
        result = connectToMySQL(DATABASE).query_db(query, data)
        if result:
            return cls(result[0])
        return None

    @classmethod
    def get_one_with_teachers(cls, data):
        query = """
            SELECT c.*, t.id AS teacher_id, t.name, t.subject, t.experience, t.cv_file, t.status, t.created_at, t.updated_at
            FROM categories c
            LEFT JOIN categories_has_teachers ct ON c.id = ct.category_id
            LEFT JOIN teachers t ON ct.teacher_id = t.id
            WHERE c.id = %(id)s AND t.status = 'Accepted';
        """
        results = connectToMySQL(DATABASE).query_db(query, data)

        if not results:
            return None
        category = cls(results[0])

        for row in results:
            if row['teacher_id']:
                teacher_data = {
                    'id': row['teacher_id'],
                    'name': row['name'],
                    'subject': row['subject'],
                    'experience': row['experience'],
                    'cv_file': row['cv_file'],
                    'status': row['status'],
                    'created_at': row['created_at'],
                    'updated_at': row['updated_at']
                }
                category.teachers.append(Teacher(teacher_data))

        return category

    @classmethod
    def update(cls, data):
        query = """
            UPDATE categories 
            SET title = %(title)s, description = %(description)s, image = %(image)s 
            WHERE id = %(id)s;
        """
        return connectToMySQL(DATABASE).query_db(query, data)

    @classmethod
    def delete(cls, data):
        query = "DELETE FROM categories WHERE id = %(id)s;"
        return connectToMySQL(DATABASE).query_db(query, data)

    @classmethod
    def associate_teacher(cls, data):
        query = """
            INSERT INTO categories_has_teachers (category_id, teacher_id)
            VALUES (%(category_id)s, %(teacher_id)s);
        """
        return connectToMySQL(DATABASE).query_db(query, data)
