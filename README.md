# Exam Project in Machine Learning, Java and React

## Description
This project aims to explore how machine learning works while applying Python skills and integrating them with Java and React. The outcome is a service that predicts and estimates air quality in specific areas of Stockholm's inner city. Users enter a time of day and select a location within Stockholm via a browser, receiving an estimated air quality forecast for their chosen time and place.

### Project Architecture
The system workflow begins in the frontend, where user input triggers a request. This request is sent to a Java server, which then forwards it to a Flask API. The API leverages a pre-trained machine learning model stored in a joblib file to process the input and generate a prediction. The response is routed back through the Java server to the frontend client, where users can view the estimated air quality. The machine learning model is developed using Python, with tools such as Jupyter Notebooks, Pandas, NumPy, and SciKit Learn.

### Data
The data is gathered from Naturvårdsverket (https://www.naturvardsverket.se/) of particles called PM10, which have big impacts on health. The particles can consist of dust from construction, particles from tires, dust from roads and plant parts. 

## Features
- Prediction of air quality with Machine Learning 
- Flask API
- Java server
- React frontend

## Technologies and Frameworks

- **Programming Languages**: Python, Java, JavaScript
- **IDEs**: Jupyter Notebook, IntelliJ, VSCode
- **Libraries**: Pandas, NumPy, SciKit Learn, Joblib
- **Frontend**: React JS, HTML, CSS

## Process of the Machine Learning

- **Step 1**: Gathering data, inspecting and cleaning it. Visualizing the data by plotting it.
- **Step 2**: Splitting data into input and output.
- **Step 3**: Splitting the input and output data into training and test sets.
- **Step 4**: Testing different algorithms to train the model.
- **Step 5**: Evaluating which model performs the best.
- **Step 6**: Saving the model to a `.joblib` file.

## Licens
Caroline Eklund holds the license.

## Contact
If you have any questions or suggestions, feel free to reach out to me at: eklund.caroline@gmail.com.

