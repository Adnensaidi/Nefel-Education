from flask import Flask
app = Flask(__name__) 


app.secret_key = "super_secret_key"
DATABASE = "pulse_academy_schema"