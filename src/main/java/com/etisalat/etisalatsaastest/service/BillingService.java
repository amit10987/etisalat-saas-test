package com.etisalat.etisalatsaastest.service;

import com.etisalat.etisalatsaastest.model.Account;
import com.etisalat.etisalatsaastest.response.BillingResponse;

public interface BillingService {

    BillingResponse info(Account account);
}
