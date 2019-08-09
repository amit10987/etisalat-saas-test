package com.etisalat.etisalatsaastest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

    @JsonProperty("etisalat_account_number")
    private String etisalatAccountNumber;
    private String planID;
    private String productID;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getEtisalatAccountNumber() {
        return etisalatAccountNumber;
    }

    public void setEtisalatAccountNumber(String etisalatAccountNumber) {
        this.etisalatAccountNumber = etisalatAccountNumber;
    }

    public String getPlanID() {
        return planID;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("etisalatAccountNumber='").append(etisalatAccountNumber).append('\'');
        sb.append(", planID='").append(planID).append('\'');
        sb.append(", productID='").append(productID).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
