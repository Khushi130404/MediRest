package com.example.MediCure.resource;

import com.example.MediCure.service.SpecialistPredictionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/model")
@CrossOrigin(origins = "http://localhost:3000")
public class ModelContoller
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
