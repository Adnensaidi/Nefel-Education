from flask import render_template, request, redirect
from flask_app import app
from flask_app.models.user import User

@app.route('/')
def index():
    return redirect('/users')

@app.route('/users')
def users():
    return render_template("users/index.html", users=User.get_all())

@app.route('/user/new')
def new():
    return render_template("users/new.html")

@app.route('/user/create', methods=['POST'])
def create():
    user_id = User.save(request.form)
    return redirect(f'/users/{user_id}')

@app.route('/users/<int:id>')
def show(id):
    data = {"id": id}
    user = User.get_one(data)
    if user:
        return render_template("users/show.html", user=user)
    return redirect('/users')

@app.route('/users/<int:id>/edit')
def edit(id):
    data = {"id": id}
    return render_template("users/edit.html", user=User.get_one(data))

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
    data = {"id": id}
    User.destroy(data)
    return redirect('/users')
