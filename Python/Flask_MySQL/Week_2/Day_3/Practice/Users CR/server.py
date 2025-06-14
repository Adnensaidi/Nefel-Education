from flask import Flask, render_template, request, redirect
from __init__ import User

app=Flask(__name__)
@app.route('/')
def index():
    return redirect('/users')

@app.route('/users')
def users():
    return render_template("index.html",users=User.get_all())

@app.route('/user/new')
def new():
    return render_template("dashboard.html")

@app.route('/user/create',methods=['POST'])
def create():
    print(request.form)
    User.save(request.form)
    return redirect('/users')

if __name__=="__main__":
    app.run(debug=True)
