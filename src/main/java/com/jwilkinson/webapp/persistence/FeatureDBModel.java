package com.jwilkinson.webapp.persistence;

import com.jwilkinson.webapp.Feature;

import java.util.Date;

public class FeatureDBModel {

        private Long featureID;
        private String title;
        private String description;
        private Long clientID;
        private Long priority; //todo make sure that priority is adjusted as needed
        private Date targetDeliveryDate;
        private Feature.ProductArea productArea;

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

        public com.jwilkinson.webapp.Feature.ProductArea getProductArea() {
            return productArea;
        }

        public void setProductArea(com.jwilkinson.webapp.Feature.ProductArea productArea) {
            this.productArea = productArea;
        }
    }

