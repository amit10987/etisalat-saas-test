package com.etisalat.etisalatsaastest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {

    @JsonProperty("test_mode")
    private boolean testMode;
    private String accountID;
    private String productID;
    private String planID;
    @JsonProperty("etisalat_account_number")
    private String etisalatAccountNumber;
    private String planName;
    @JsonProperty("tyc_date")
    private String tycDate;
    private String running;

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getTycDate() {
        return tycDate;
    }

    public void setTycDate(String tycDate) {
        this.tycDate = tycDate;
    }

    public String getRunning() {
        return running;
    }

    public void setRunning(String running) {
        this.running = running;
    }

    public boolean isTestMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getPlanID() {
        return planID;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
    }

    public String getEtisalatAccountNumber() {
        return etisalatAccountNumber;
    }

    public void setEtisalatAccountNumber(String etisalatAccountNumber) {
        this.etisalatAccountNumber = etisalatAccountNumber;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Data{");
        sb.append("testMode=").append(testMode);
        sb.append(", accountID='").append(accountID).append('\'');
        sb.append(", productID='").append(productID).append('\'');
        sb.append(", planID='").append(planID).append('\'');
        sb.append(", etisalatAccountNumber='").append(etisalatAccountNumber).append('\'');
        sb.append(", planName='").append(planName).append('\'');
        sb.append(", tycDate='").append(tycDate).append('\'');
        sb.append(", running='").append(running).append('\'');
        sb.append('}');
        return sb.toString();
    }
}