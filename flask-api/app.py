
from flask import Flask, request, jsonify
import joblib
import numpy as np

model_lillaessingen = joblib.load('LillaEssingen-pm10-randomForest.joblib')
model_hornsgatan = joblib.load('Hornsgatan-pm10-randomForest.joblib')
model_steriks = joblib.load('StEriksgatan-pm10-randomForest.joblib')
model_sveav = joblib.load('Sveavägen-pm10-randomForest.joblib')
model_torkel = joblib.load('Torkel-pm10-randomForest.joblib')


bins = [0, 20, 40, 60, 80, 100, 120, 140, np.inf]
labels = [1, 2, 3, 4, 5, 6, 7, 8]

app = Flask(__name__)

@app.route("/predictlillaessingen", methods=["POST"])
def predict():
    data=request.get_json()
    features = np.array(data['features']).reshape(1, -1)  
    prediction = model_lillaessingen.predict(features) 
    categorized_prediction = pd.cut(prediction, bins=bins, labels=labels)
    response = {
        "categorized_prediction": categorized_prediction.astype(int).tolist()
    }
    return jsonify(response)

@app.route("/predicthornsg", methods=["POST"])
def predict():
    data=request.get_json()
    features = np.array(data['features']).reshape(1, -1)  
    prediction = model_hornsgatan.predict(features) 
    categorized_prediction = pd.cut(prediction, bins=bins, labels=labels)
    response = {
        "categorized_prediction": categorized_prediction.astype(int).tolist()
    }
    return jsonify(response)

@app.route("/predictsteriks", methods=["POST"])
def predict():
    data=request.get_json()
    features = np.array(data['features']).reshape(1, -1)  
    prediction = model_steriks.predict(features) 
    categorized_prediction = pd.cut(prediction, bins=bins, labels=labels)
    response = {
        "categorized_prediction": categorized_prediction.astype(int).tolist()
    }
    return jsonify(response)

@app.route("/predictsveav", methods=["POST"])
def predict():
    data=request.get_json()
    features = np.array(data['features']).reshape(1, -1)  
    prediction = model_sveav.predict(features) 
    categorized_prediction = pd.cut(prediction, bins=bins, labels=labels)
    response = {
        "categorized_prediction": categorized_prediction.astype(int).tolist()
    }
    return jsonify(response)

@app.route("/predicttorkel", methods=["POST"])
def predict():
    data=request.get_json()
    features = np.array(data['features']).reshape(1, -1)  
    prediction = model_torkel.predict(features) 
    categorized_prediction = pd.cut(prediction, bins=bins, labels=labels)
    response = {
        "categorized_prediction": categorized_prediction.astype(int).tolist()
    }
    return jsonify(response)
    
# Kör applikationen
if __name__ == "__main__":
    app.run(debug=True)

# skapa enviroment: python3 -m venv venv
# För att starta enviroment: source venv/bin/activate
# installera dependencies: pip install flask joblib numpy
# installera dep: pip install scikit-learn
# För att starta applikationen : python app.py
