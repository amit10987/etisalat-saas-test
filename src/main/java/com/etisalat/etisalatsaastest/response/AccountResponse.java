package com.etisalat.etisalatsaastest.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AccountResponse{");
        sb.append("data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
