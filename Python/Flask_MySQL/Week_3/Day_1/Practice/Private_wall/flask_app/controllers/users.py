from flask import render_template, redirect, request, session, flash
from flask_app.models.user import User
from flask_app import app

@app.route('/')
def index():
    return render_template('index.html')

@app.route("/register", methods=["POST"])
def register():
    if not User.validate_registration(request.form):
        return redirect("/")
    user_id = User.save(request.form)
    session['user_id'] = user_id
    return redirect("/dashboard")

@app.route("/login", methods=["POST"])
def login():
    user = User.get_by_email(request.form)
    if not user or not User.check_password(request.form['password'], user.password):
        flash("Invalid email or password", "login")
        return redirect("/")
    session['user_id'] = user.id
    return redirect("/dashboard")

@app.route("/dashboard")
def dashboard():
    if 'user_id' not in session:
        return redirect("/")
    user = User.get_by_id(session['user_id'])
    return render_template("dashboard.html", user=user)

@app.route("/logout")
def logout():
    session.clear()
    return redirect("/")