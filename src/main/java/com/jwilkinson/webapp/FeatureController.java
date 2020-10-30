package com.jwilkinson.webapp;


import com.jwilkinson.webapp.persistence.FeatureDBModel;
import com.jwilkinson.webapp.persistence.FeatureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("feature")
public class FeatureController {
    @Autowired
    FeatureMapper featureMapper;

    @GetMapping()
    public FeatureList getFeatures() {
        List<Feature> features = featureMapper.getAllFeatures().stream().map(featureDBModel ->
                new Feature(featureDBModel.getFeatureID(), featureDBModel.getTitle(), featureDBModel.getDescription(), featureDBModel.getClientID(), featureDBModel.getPriority(), featureDBModel.getTargetDeliveryDate(), featureDBModel.getProductArea())).collect(Collectors.toList());
        return new FeatureList(features);
    }

    @GetMapping(value = "{featureID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Feature> getFeature(@PathVariable("featureID") Long featureID) {
        FeatureDBModel featureDBModel = featureMapper.getFeature(featureID);
        if (featureDBModel == null) {
            return ResponseEntity.notFound().build();
        }

        Feature feature = new Feature();
        feature.setFeatureID(featureDBModel.getFeatureID());
        feature.setTitle(featureDBModel.getTitle());
        feature.setDescription(featureDBModel.getDescription());
        feature.setClientID(featureDBModel.getClientID());
        feature.setPriority(featureDBModel.getPriority());
        feature.setTargetDeliveryDate(featureDBModel.getTargetDeliveryDate());
        feature.setProductArea(featureDBModel.getProductArea());
        return ResponseEntity.ok(feature);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postFeature(@RequestBody Feature feature) {
        FeatureDBModel featureDBModel = new FeatureDBModel();
        featureDBModel.setFeatureID(feature.getFeatureID());
        featureDBModel.setTitle(feature.getTitle());
        featureDBModel.setDescription(feature.getDescription());
        featureDBModel.setClientID(feature.getClientID());
        featureDBModel.setPriority(feature.getPriority());
        featureDBModel.setTargetDeliveryDate(feature.getTargetDeliveryDate());
        featureDBModel.setProductArea(feature.getProductArea());

        try {
            featureMapper.addFeature(featureDBModel);
        } catch (DuplicateKeyException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{featureID}")
                .buildAndExpand(featureDBModel.getClientID())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "{featureID}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity putFeature(@PathVariable("featureID") Long featureID, @RequestBody Feature feature) {
        if (featureID != feature.getFeatureID()) {
            return ResponseEntity.badRequest().build();
        }
        FeatureDBModel featureDBModel = new FeatureDBModel();
        featureDBModel.setFeatureID(feature.getFeatureID());
        featureDBModel.setTitle(feature.getTitle());
        featureDBModel.setDescription(feature.getDescription());
        featureDBModel.setClientID(feature.getClientID());
        featureDBModel.setPriority(feature.getPriority());
        featureDBModel.setTargetDeliveryDate(feature.getTargetDeliveryDate());
        featureDBModel.setProductArea(feature.getProductArea());

        if (featureMapper.updateFeature(featureDBModel) == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping(value = "{featureID}")
    public ResponseEntity deleteFeature(@PathVariable("featureID") Long featureID) {
        featureMapper.deleteFeature(featureID);
        return ResponseEntity.noContent().build();
    }
}
