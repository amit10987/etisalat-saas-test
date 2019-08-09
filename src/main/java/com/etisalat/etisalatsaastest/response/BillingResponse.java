package com.etisalat.etisalatsaastest.response;

import java.util.List;

public class BillingResponse {

    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BillingResponse{");
        sb.append("data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
