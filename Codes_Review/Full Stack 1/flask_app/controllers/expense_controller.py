from flask_app import app
from flask import render_template, request, redirect
from flask_app.models.expense_model import Expense


# **display route to display the create form
@app.route("/expenses/new")
def create_form():
    return render_template("create.html")


# * action route for handling the create form
@app.route("/expenses/create", methods=["POST"])
def handle_create_form():
    Expense.create(request.form)
    return redirect("/expenses")

@app.route("/expenses")
def home():
    all_expenses = Expense.get_all()
    return render_template("home.html", all_expenses = all_expenses)

@app.route("/expenses/show/<int:expense_id>")
def show_one(expense_id):
    expense = Expense.show_one({"id": expense_id})
    return render_template("show_one.html", expense = expense)

@app.route("/expenses/edit/<int:id>")
def edit_form(id):
    expense = Expense.show_one({"id": id})
    return render_template("edit.html",expense = expense)

@app.route("/expenses/update/<int:id>", methods=['POST'])
def handle_edit_form(id):
    Expense.update({**request.form, "id":id})
    return redirect("/expenses")

@app.route("/expenses/delete/<int:id>", methods=['POST'])
def delete(id):
    Expense.delete({"id": id})
    return redirect("/expenses")