from flask import Flask, render_template, request, session, redirect
import random

app = Flask(__name__)
app.secret_key = 'Adnen_Saidi'


@app.route('/')
def index():
    if 'number' not in session:
        session['number'] = random.randint(1, 100)
    return render_template('index.html')

@app.route('/guess', methods=['POST'])
def guess():
    guess = int(request.form['guess'])
    if guess < session['number']:
        session['result'] = 'low'
        session['message'] = 'Too low!'
    elif guess > session['number']:
        session['result'] = 'high'
        session['message'] = 'Too high!'
    else:
        session['result'] = 'correct'
        session['message'] = f'Correct! The number was {session["number"]}'
    return redirect('/')

@app.route('/reset')
def reset():
    session.clear()
    return redirect('/')

if __name__=="__main__":
    app.run(debug=True)
