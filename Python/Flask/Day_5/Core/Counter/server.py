from flask import Flask, render_template, session, redirect, request

app = Flask(__name__)
app.secret_key = 'supersecretkey'  # Secret key for sessions

# Root route
@app.route('/')
def index():
    # Check if 'counter' exists in session; if not, initialize it
    if 'counter' not in session:
        session['counter'] = 0
    session['counter'] += 1  # Increment the counter by 1

    # Check if 'visits' exists in session; if not, initialize it
    if 'visits' not in session:
        session['visits'] = 0
    session['visits'] += 1  # Track actual visits

    return render_template('index.html', counter=session['counter'], visits=session['visits'])

# Route to destroy the session
@app.route('/destroy_session')
def destroy_session():
    session.clear()  # Clear the entire session
    return redirect('/')  # Redirect to the root route

# Route to increment the counter by 2
@app.route('/increment_by_2')
def increment_by_2():
    if 'counter' in session:
        session['counter'] += 2  # Increment the counter by 2
    return redirect('/')

# Route to reset the counter
@app.route('/reset_counter')
def reset_counter():
    if 'counter' in session:
        session['counter'] = 0  # Reset the counter to 0
    return redirect('/')

# Route to increment by a user-specified value
@app.route('/custom_increment', methods=['POST'])
def custom_increment():
    try:
        increment_value = int(request.form.get('increment_value', 0))  # Get the increment value from the form
        if 'counter' in session:
            session['counter'] += increment_value  # Increment the counter by the specified value
    except ValueError:
        pass  # Ignore invalid inputs
    return redirect('/')

if __name__ == '__main__':
    app.run(debug=True)