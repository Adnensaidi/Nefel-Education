from flask import Flask, render_template, request, redirect, session

app = Flask(__name__)
app.secret_key = 'supersecretkey'  # Clé secrète pour la gestion des sessions

@app.route('/')
def index():
    return render_template('index.html')  # Rend la page du formulaire

@app.route('/process', methods=['POST'])
def process():
    # Récupérer les données du formulaire et les stocker dans la session
    session['name'] = request.form.get('name', '')
    session['location'] = request.form.get('location', '')
    session['language'] = request.form.get('language', '')
    session['comment'] = request.form.get('comment', '')
    session['gender'] = request.form.get('gender', '')
    session['interests'] = request.form.getlist('interests')  # Liste pour les cases à cocher
    return redirect('/result')  # Redirige vers la page des résultats

@app.route('/result')
def result():
    return render_template('result.html')  # Affiche la page des résultats

if __name__ == '__main__':
    app.run(debug=True)
