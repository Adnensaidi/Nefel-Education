from flask import render_template, redirect, request, session, flash
from flask_app.models.user import User
from flask_app import app
from flask_bcrypt import Bcrypt

bcrypt = Bcrypt(app)

@app.route("/")
def index():
    return render_template("index.html")

@app.route("/register", methods=["POST"])
def register():
    print("Données du formulaire:", request.form)  # Pour voir les données reçues
    
    if not User.validate_registration(request.form):
        return redirect("/")
    
    data = {
        "first_name": request.form['first_name'],
        "last_name": request.form['last_name'],
        "email": request.form['email'],
        "password": bcrypt.generate_password_hash(request.form['password'])
    }
    
    print("Données à sauvegarder:", data)  # Pour voir les données avant sauvegarde
    
    user_id = User.save(data)
    print("ID utilisateur créé:", user_id)  # Pour voir l'ID retourné
    
    session['user_id'] = user_id
    print("Session après enregistrement:", session)  # Pour voir la session
    
    return redirect("/dashboard")

@app.route("/login", methods=["POST"])
def login():
    user = User.get_by_email({"email": request.form['email']})
    
    if not user:
        flash("Email ou mot de passe invalide")
        return redirect("/")
        
    if not bcrypt.check_password_hash(user.password, request.form['password']):
        flash("Email ou mot de passe invalide")
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