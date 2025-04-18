package com.example.MediCure.weka;

import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class WekaModelHandler {

    private Classifier classifier;

    public WekaModelHandler()
    {
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/weka/yourModelFile.model"));
            classifier = (Classifier) ois.readObject();
            ois.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public double classifyInstance(Instances instance) {
        try
        {
            return classifier.classifyInstance(instance.firstInstance());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }

    public Instances loadDataFromCSV(String csvPath)
    {
        try
        {
            DataSource source = new DataSource(csvPath);
            return source.getDataSet();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}