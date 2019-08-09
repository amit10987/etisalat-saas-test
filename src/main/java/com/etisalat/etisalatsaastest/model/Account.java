package com.etisalat.etisalatsaastest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {

    @JsonProperty("etisalat_account_number")
    private String etisalatAccountNumber;
    private String email;
    @JsonProperty("contact_number")
    private String contactNumber;
    private String planID;

    public String getEtisalatAccountNumber() {
        return etisalatAccountNumber;
    }

    public void setEtisalatAccountNumber(String etisalatAccountNumber) {
        this.etisalatAccountNumber = etisalatAccountNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPlanID() {
        return planID;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
    }

    @Override
    public String toString() {
        return "Account{" +
                "etisalatAccountNumber='" + etisalatAccountNumber + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", planID='" + planID + '\'' +
                '}';
    }
}
