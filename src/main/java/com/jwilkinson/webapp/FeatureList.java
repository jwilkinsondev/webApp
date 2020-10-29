package com.jwilkinson.webapp;

import java.util.List;

public class FeatureList {
    public List<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
    }

    List<Feature> featureList;

    public FeatureList(List<Feature> featureList) {
        this.featureList = featureList;
    }
}
