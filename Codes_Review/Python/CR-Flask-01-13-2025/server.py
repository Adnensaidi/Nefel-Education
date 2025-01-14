from flask import Flask, render_template, redirect,request,session # step 5 - 1 (add session)
app = Flask(__name__)
app.secret_key = 'supersecretkey' # step 5 - 1 (add session Key)

# step 1
contacts = [
    {"username":"cool", "email":"cool@g.com", "phone" : 5522114466, "age":22, "country":"Tunisia"},
    {"username":"awsome", "email":"awsome@g.com", "phone" : 5522114466, "age":32, "country":"Algeria"},
    {"username":"funny", "email":"funny@g.com", "phone" : 5522114466, "age":30, "country":"Maroc"},
    {"username":"pretty", "email":"pretty@g.com", "phone" : 5522114466, "age":25, "country":"Syria"},
    {"username":"brave", "email":"brave@g.com", "phone" : 5522114466, "age":35, "country":"Palestine"},
    {"username":"cute", "email":"cute@g.com", "phone" : 5522114466, "age":22, "country":"France"}
]

# step 1 - 1 
@app.route('/')
def index():
    return render_template('index.html')

# step 2 - 1 
@app.route('/contact_list')
def contact_list():
    return render_template("contact_list.html", contacts=contacts)

# step 3 - 1
@app.route('/add_contact')
def add_contact():
    return render_template("add_contact.html")

# step 4 - 1
@app.route('/new_contact', methods=['POST'])
def create_contact():
    contacts.append(request.form)
    session['new_contact']= request.form  # step 5 - 3
    return redirect("/contact_list")

# step 5 - 2 + add session
@app.route('/display')
def display():
    new_contact = session.get("new_contact", {})
    return render_template("display_new_contact.html", contact = new_contact)

@app.route('/reset')
def clear():
    session.clear()
    return redirect('/')




if __name__=="__main__":
    app.run(debug=True)
