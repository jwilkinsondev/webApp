package com.jwilkinson.webapp;

import java.util.Date;

public class Feature {
    public Feature(int featureID, String title, String description, int clientID, int priority, Date targetDeliveryDate, ProductArea productArea) {
        this.featureID = featureID;
        this.title = title;
        this.description = description;
        this.clientID = clientID;
        this.priority = priority;
        this.targetDeliveryDate = targetDeliveryDate;
        this.productArea = productArea;
    }

    public enum ProductArea {
        POLICIES, BILLING, CLAIMS, REPORTS
    }
    private int featureID;
    private String title;
    private String description;
    private int clientID;
    private int priority; //todo make sure that priority is adjusted as needed
    private Date targetDeliveryDate;
    private ProductArea productArea;

    public int getFeatureID() {
        return featureID;
    }

    public void setFeatureID(int featureID) {
        this.featureID = featureID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getTargetDeliveryDate() {
        return targetDeliveryDate;
    }

    public void setTargetDeliveryDate(Date targetDeliveryDate) {
        this.targetDeliveryDate = targetDeliveryDate;
    }

    public ProductArea getProductArea() {
        return productArea;
    }

    public void setProductArea(ProductArea productArea) {
        this.productArea = productArea;
    }
}
