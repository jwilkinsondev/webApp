package com.jwilkinson.webapp;

import java.util.Date;

public class Feature {

    public Feature() {

    }
    public Feature(Long featureID, String title, String description, Long clientID, Long priority, Date targetDeliveryDate, ProductArea productArea) {
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
    private Long featureID;
    private String title;
    private String description;
    private Long clientID;
    private Long priority; //todo make sure that priority is adjusted as needed
    private Date targetDeliveryDate;
    private ProductArea productArea;

    public Long getFeatureID() {
        return featureID;
    }

    public void setFeatureID(Long featureID) {
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

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
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
