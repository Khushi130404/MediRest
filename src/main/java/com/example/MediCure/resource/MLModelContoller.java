package com.example.MediCure.resource;

import com.example.MediCure.service.SpecialistPredictionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class MLModelContoller
{
    @Autowired
    private SpecialistPredictionModel predictionModel;

    @GetMapping("/trainModel")
    public String trainModel()
    {
        predictionModel.trainModel();
        return "Model trained successfully!";
    }

    @PostMapping("/predictSpecialist")
    public String predictSpecialist(@RequestBody double[] symptomVector)
    {
        return predictionModel.predictSpecialist(symptomVector);
    }
}
