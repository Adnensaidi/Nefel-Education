from flask import Flask, render_template, request, redirect
from __init__ import User

app = Flask(__name__)

@app.route('/')
def index():
    return redirect('/users')

@app.route('/users')
def users():
    return render_template("index.html", users=User.get_all())

@app.route('/user/new')
def new():
    return render_template("new.html")

@app.route('/user/create', methods=['POST'])
def create():
    user_id = User.save(request.form)
    return redirect(f'/users/{user_id}')

@app.route('/users/<int:id>')
def show(id):
    data = {
        "id": id
    }
    user = User.get_one(data)
    if user:
        return render_template("show.html", user=user)
    return redirect('/users')

@app.route('/users/<int:id>/edit')
def edit(id):
    data = {
        "id": id
    }
    return render_template("edit.html", user=User.get_one(data))

@app.route('/users/<int:id>/update', methods=['POST'])
def update(id):
    data = {
        "id": id,
        "first_name": request.form['first_name'],
        "last_name": request.form['last_name'],
        "email": request.form['email']
    }
    User.update(data)
    return redirect(f'/users/{id}')

@app.route('/users/<int:id>/destroy')
def destroy(id):
    data = {
        "id": id
    }
    User.destroy(data)
    return redirect('/users')

if __name__ == "__main__":
    app.run(debug=True)
