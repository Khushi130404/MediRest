package com.example.MediCure.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import java.io.InputStream;
import java.util.ArrayList;

@Service
public class SpecialistPredictionModel
{
    private Classifier model;
    private Instances trainingDataset;

    public void trainModel()
    {
        try
        {
            ClassPathResource resource = new ClassPathResource("data/doctor_specialist_binary_symptoms.csv");
            InputStream csvStream = resource.getInputStream();
            CSVLoader loader = new CSVLoader();
            loader.setSource(csvStream);

            trainingDataset = loader.getDataSet();
            trainingDataset.setClassIndex(trainingDataset.numAttributes() - 1);

            model = new J48();
            model.buildClassifier(trainingDataset);

            System.out.println("Model trained successfully with the CSV dataset!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error training the model: " + e.getMessage());
        }
    }

    public String predictSpecialist(double[] symptomVector)
    {
        try
        {
            DenseInstance newInstance = new DenseInstance(1.0, symptomVector);
            newInstance.setDataset(trainingDataset);
            double predictedClassIndex = model.classifyInstance(newInstance);
            String predictedSpecialty = trainingDataset.classAttribute().value((int) predictedClassIndex);
            return predictedSpecialty;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "Error making prediction: " + e.getMessage();
        }
    }
}