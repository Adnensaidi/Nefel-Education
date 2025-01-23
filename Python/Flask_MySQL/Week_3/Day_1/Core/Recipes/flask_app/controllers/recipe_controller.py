from flask_app import app
from flask import render_template, request, redirect, session , flash
from flask_app.models.recipe_model import Recipe
from flask_app.models.user_model import User

# **display route to display the create form
@app.route("/recipes/new")
def create_form():
    if not "user_id" in session:
        return redirect('/')
    return render_template("create.html")


# * action route for handling the create form
@app.route("/recipes/create", methods=["POST"])
def handle_create_form():
    if not Recipe.validate(request.form):
        return redirect("/recipes/new")
    # Vérification des données avant insertion
    if not 'under_30_min' in request.form:
        flash("Please select Yes or No for 'Under 30 minutes?'", "under_30_min")
        return redirect('/recipes/new')
    Recipe.create({**request.form, "user_id": session['user_id']})
    return redirect("/recipes")
    # Préparer les données pour l'insertion


@app.route("/recipes")
def home():
    if not "user_id" in session:
        return redirect('/')
    all_recipes = Recipe.get_all()
    loggedin_user = User.get_by_id({"id": session['user_id']})
    return render_template("home.html", all_recipes = all_recipes, loggedin_user= loggedin_user)

@app.route("/expenses/show/<int:expense_id>")
def show_one(recipe_id):
    recipe = Recipe.show_one({"id": recipe_id})
    return render_template("show_one.html", recipe = recipe)

@app.route("/recipes/edit/<int:id>")
def edit_form(id):
    recipe = Recipe.show_one({"id": id})
    return render_template("edit.html",recipe = recipe)

@app.route("/recipes/update/<int:id>", methods=['POST'])
def handle_edit_form(id):
    data = {
        **request.form,
        "id": id
    }
    if not Recipe.validate(request.form):
        return redirect(f"/recipes/edit/{id}")
    Recipe.update(data)
    return redirect("/recipes")

@app.route("/recipes/delete/<int:id>", methods=['POST'])
def delete(id):
    Recipe.delete({"id": id})
    return redirect("/recipes")