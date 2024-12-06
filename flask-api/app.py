
from flask import Flask, request, jsonify
import joblib
import numpy as np

model = joblib.load('luftkvalitet-pm10.joblib')

app = Flask(__name__)

@app.route("/predict", methods=["POST"])
def predict():
    data = request.get_json()  
    features = np.array(data['features']).reshape(1, -1)  
    prediction = model.predict(features)  
    return jsonify({"prediction": prediction.tolist()})
      

# Kör applikationen
if __name__ == "__main__":
    app.run(debug=True)

# skapa enviroment: python3 -m venv venv
# För att starta enviroment: source venv/bin/activate
# installera dependencies: pip install flask joblib numpy
# installera dep: pip install scikit-learn
# För att starta applikationen : python app.py