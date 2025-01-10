from flask import Flask, render_template
app = Flask (__name__)

@app.route('/play')
def play():
    return render_template('dashboard.html', num = 3)

@app.route('/play/<int:num>/')
def play_boxes(num):
    return render_template("dashboard.html", num = num)

@app.route('/play/<int:num>/<string:color>/')
def repeat_user(num,color):
    return render_template('dashboard.html',num=num,color=color)

if __name__=="__main__":
    app.run(debug=True)