from flask import render_template, redirect, request
from flask_app import app
from flask_app.models.dojo import Dojo

@app.route('/')
def index():
    return redirect('/dojos')

@app.route('/dojos')
def show_dojos():
    dojos = Dojo.get_all()
    return render_template('dojos.html', dojos=dojos)

@app.route('/dojos/create', methods=['POST'])
def create_dojo():
    Dojo.save(request.form)
    return redirect('/dojos')

@app.route('/dojos/<int:dojo_id>')
def show_dojo(dojo_id):
    data = {'id': dojo_id}
    dojo = Dojo.get_one_with_ninjas(data)
    return render_template('dojo_show.html', dojo=dojo)