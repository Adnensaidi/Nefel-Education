import os
import uuid
from flask import render_template, redirect, request, flash, send_from_directory
from flask_app import app
from flask_app.models.teacher import Teacher
from flask_app.models.category import Category

UPLOAD_FOLDER = 'uploads/'
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

if not os.path.exists(UPLOAD_FOLDER):
    os.makedirs(UPLOAD_FOLDER)

@app.route('/teachers')
def teachers():
    teachers = Teacher.get_all_pending()
    categories = Category.get_all()
    return render_template('teachers.html', teachers=teachers, categories=categories)

@app.route('/teachers/accept/<int:id>', methods=['POST'])
def accept_teacher(id):
    category_id = request.form.get('category_id')

    if not category_id:
        flash("Please select a category!", "error")
        return redirect('/teachers')

    Teacher.update_status({'id': id, 'status': 'Accepted'})
    Category.associate_teacher({'category_id': category_id, 'teacher_id': id})

    flash("Teacher accepted successfully!", "success")
    return redirect('/teachers')

@app.route('/teachers/reject/<int:id>', methods=['POST'])
def reject_teacher(id):
    Teacher.update_status({'id': id, 'status': 'Rejected'})
    flash("Teacher rejected.", "info")
    return redirect('/teachers')

@app.route('/uploads/<filename>')
def download_cv(filename):
    return send_from_directory(app.config['UPLOAD_FOLDER'], filename)

@app.route('/teachers/apply', methods=['GET', 'POST'])
def apply_teacher():
    if request.method == 'POST':
        name = request.form['name']
        subject = request.form['subject']
        experience = request.form['experience']
        cv_file = request.files['cv_file']

        if not cv_file:
            flash('Please upload a CV file.', 'error')
            return redirect('/teachers/apply')

        cv_filename = Teacher.save_cv(cv_file)

        teacher_data = {
            'name': name,
            'subject': subject,
            'experience': experience,
            'cv_file': cv_filename
        }

        Teacher.save(teacher_data)
        flash('Your application has been submitted successfully!', 'success')
        return redirect('/teachers')

    return render_template('apply_teacher.html')
