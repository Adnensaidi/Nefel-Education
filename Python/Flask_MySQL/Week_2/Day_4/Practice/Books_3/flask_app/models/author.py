from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import book

class Author:
    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.favorite_books = []
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.favorite_books = []

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM books_schema.authors;"  
        authors = []
        results = connectToMySQL('books_schema').query_db(query)  
        for row in results:
            authors.append(cls(row))
        return authors

    @classmethod
    def save(cls, data):
        query = "INSERT INTO books_schema.authors (name) VALUES (%(name)s);"  
        return connectToMySQL('books_schema').query_db(query, data)  

    @classmethod
    def unfavorited_authors(cls, data):
        query = "SELECT * FROM books_schema.authors WHERE books_schema.authors.id NOT IN ( SELECT author_id FROM books_schema.favorites WHERE book_id = %(id)s );" 
        authors = []
        results = connectToMySQL('books_schema').query_db(query, data) 
        for row in results:
            authors.append(cls(row))
        return authors

    @classmethod
    def add_favorite(cls, data):
        query = "INSERT INTO books_schema.favorites (author_id, book_id) VALUES (%(author_id)s, %(book_id)s);"  
        return connectToMySQL('books_schema').query_db(query, data)  

    @classmethod
    def get_by_id(cls, data):
        query = "SELECT * FROM books_schema.authors LEFT JOIN books_schema.favorites ON books_schema.authors.id = books_schema.favorites.author_id LEFT JOIN books_schema.books ON books_schema.books.id = books_schema.favorites.book_id WHERE books_schema.authors.id = %(id)s;" 
        results = connectToMySQL('books_schema').query_db(query, data)  

        author = cls(results[0])
        for row in results:
            if row['books_schema.books.id'] == None:
                break
            data = {
                "id": row['books_schema.books.id'],
                "title": row['books_schema.books.title'],
                "num_of_pages": row['books_schema.books.num_of_pages'],
                "created_at": row['books_schema.books.created_at'],
                "updated_at": row['books_schema.books.updated_at']
            }
            author.favorite_books.append(book.Book(data))
        return author