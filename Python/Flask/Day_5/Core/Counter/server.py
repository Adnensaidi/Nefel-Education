from flask import Flask, render_template, session, redirect

app = Flask(__name__)
app.secret_key = 'Adnen_Saidi'

@app.route('/')
def index():
    if 'A' not in session:
        session['A'] = 1
    else:
        session['A'] += 1
    return render_template('index.html', A=session['A'])


@app.route('/submit_session')
def submit_session():
    session.update()
    return redirect('/')

@app.route('/destroy_session')
def destroy_session():
    session.clear()
    return redirect('/')


if __name__ == "__main__":
    app.run(debug=True)