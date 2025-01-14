from flask import Flask, render_template, session, redirect, request
import random

app = Flask(__name__)
app.secret_key = 'supersecretkey'  # Clé secrète pour la session

@app.route('/')
def index():
    # Initialiser un nombre aléatoire s'il n'existe pas déjà dans la session
    if 'random_number' not in session:
        session['random_number'] = random.randint(1, 100)
        session['attempts'] = 0  # Nombre de tentatives
    return render_template('index.html')

@app.route('/guess', methods=['POST'])
def guess():
    # Récupérer la supposition de l'utilisateur depuis le formulaire
    user_guess = int(request.form['guess'])
    session['attempts'] += 1  # Augmenter le nombre de tentatives

    # Comparer la supposition avec le nombre aléatoire
    if user_guess < session['random_number']:
        session['message'] = 'Too low!'
        session['color'] = 'red'
    elif user_guess > session['random_number']:
        session['message'] = 'Too high!'
        session['color'] = 'red'
    else:
        session['message'] = f'Correct! You guessed it in {session["attempts"]} attempts.'
        session['color'] = 'green'
        session['game_over'] = True  # Marquer le jeu comme terminé

    return redirect('/')

@app.route('/reset')
def reset():
    session.clear()  # Réinitialiser la session
    return redirect('/')

if __name__ == '__main__':
    app.run(debug=True)