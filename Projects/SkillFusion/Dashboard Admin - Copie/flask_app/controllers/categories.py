from flask import render_template, redirect, request
from flask_app import app
from flask_app.models.category import Category
from flask_app.models.teacher import Teacher

@app.route('/categories')
def categories():
    categories = Category.get_all()
    return render_template('categories.html', categories=categories)

@app.route('/categories/new')
def new_category():
    teachers = Teacher.get_all()  # Liste de tous les enseignants
    return render_template('new_category.html', teachers=teachers)

@app.route('/categories/create', methods=['POST'])
def create_category():
    category_id = Category.save(request.form)

    teacher_ids = request.form.getlist('teachers[]')  # Récupérer les enseignants sélectionnés
    for teacher_id in teacher_ids:
        data = {
            'category_id': category_id,
            'teacher_id': teacher_id
        }
        Category.associate_teacher(data)

    return redirect('/categories')

@app.route('/categories/<int:id>')
def get_category(id):
    data = {'id': id}
    category = Category.get_one_with_teachers(data)
    all_teachers = Teacher.get_all()  # Liste complète des enseignants
    return render_template('show_category.html', category=category, teachers=all_teachers)

@app.route('/categories/update/<int:id>', methods=['POST'])
def update_category(id):
    data = {
        'id': id,
        'title': request.form['title'],
        'description': request.form['description'],
        'image': request.form['image']
    }
    Category.update(data)
    return redirect(f'/categories/{id}')

@app.route('/categories/delete/<int:id>', methods=['POST'])
def delete_category(id):
    data = {'id': id}
    Category.delete(data)
    return redirect('/categories')

@app.route('/categories/edit/<int:id>', methods=['GET', 'POST'])
def edit_category(id):
    category = Category.get_one({'id': id})
    if request.method == 'POST':
        data = {
            'id': id,
            'title': request.form['title'],
            'description': request.form['description'],
            'image': request.form['image']
        }
        Category.update(data)
        return redirect(f'/categories/{id}')
    return render_template('edit_category.html', category=category)
