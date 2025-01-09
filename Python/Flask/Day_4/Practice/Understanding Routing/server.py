from flask import Flask, render_template # type: ignore
app = Flask (__name__)


@app.route('/')
def hello():
    return "Hello World!"

@app.route('/dojo')
def Dojo():
    return "Dojo!"

@app.route('/say/<user_name>')
def say_user(user_name):
    return"say" +" "+ user_name


@app.route('/repeat/<int:num>/<string:name>/')
def repeat_user(name,num):
    return render_template('index.html',num=num,name=name)


if __name__=="__main__":
    app.run(debug=True)
