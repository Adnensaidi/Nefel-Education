from flask_app import app
from flask_app.models.user_model import User
from flask import render_template, request , session, redirect, flash
from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app) #Bcrypt class must have the application type in the parameter of its constructor


@app.route("/")
def index():
    return render_template("index.html")


# action route for registration 
@app.route("/register", methods=['post'])
def register():
    if User.validation(request.form):
        pw_hash = bcrypt.generate_password_hash(request.form["password"])
        data={
            **request.form,
            "password": pw_hash
        }
        
        user_id = User.register(data)
        session['user_id'] = user_id
        return redirect("/recipes")
    return redirect("/")

@app.route("/login", methods=['post'])
def login():
    user = User.get_by_email({'email': request.form['email']})
    if not user:
        flash("Invalid credentials", "login")
        return redirect('/')
    if not bcrypt.check_password_hash(user.password, request.form['password']):
        flash("Invalid credentials", "login")
        return redirect('/')
    session['user_id'] = user.id
    return redirect("/recipes")


@app.route("/logout", methods=['post'])
def logout():
    session.clear()
    return redirect("/")