from flask import render_template, request, redirect
from flask_app import app
from flask_app.models.dojo_model import Dojo

@app.route('/')
def index():
    return render_template("index.html")

@app.route('/create/dojo', methods=['POST'])
def create_dojo():
    if Dojo.is_valid(request.form):
        Dojo.save(request.form)
        return redirect('/results')
    return redirect('/')

@app.route('/results')
def results():
    return render_template('results.html', dojo=Dojo.get_last_dojo())