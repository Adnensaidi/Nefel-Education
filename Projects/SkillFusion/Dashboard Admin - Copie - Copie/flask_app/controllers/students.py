from flask import render_template, redirect, request
from flask_app import app
from flask_app.models.user import User

@app.route('/students')
def show_students():
    students = User.get_all()
    return render_template('student.html', students=students)

@app.route('/students/<int:id>')
def show_student_details(id):
    data = {'id': id}
    student = User.get_by_id(data)
    if student:
        return render_template('student_details.html', student=student)
    return redirect('/students')

@app.route('/students/delete/<int:id>', methods=['POST'])
def delete_student(id):
    data = {'id': id}
    User.delete(data)
    return redirect('/students')

@app.route('/students/edit/<int:id>', methods=['GET', 'POST'])
def edit_student(id):
    data = {'id': id}
    student = User.get_by_id(data)
    if request.method == 'POST':
        updated_data = {
            'id': id,
            'username': request.form['username'],
            'email': request.form['email'],
            'profile_pic': request.form['profile_pic'],
            'bio': request.form['bio']
        }
        User.update(updated_data)
        return redirect('/students')
    return render_template('edit_student.html', student=student)

@app.route('/requests')
def show_requests():
    requests = User.get_all_requests()
    return render_template('student_requests.html', requests=requests)

@app.route('/accept_request/<int:id>', methods=['POST'])
def accept_request(id):
    data = {'id': id, 'status': 'accepted'}
    User.update(data)
    return redirect('/requests')

@app.route('/reject_request/<int:id>', methods=['POST'])
def reject_request(id):
    data = {'id': id, 'status': 'rejected'}
    User.update(data)
    return redirect('/requests')

@app.route('/remove_request/<int:id>', methods=['POST'])
def remove_request(id):
    data = {'id': id}
    User.delete(data)
    return redirect('/requests')
