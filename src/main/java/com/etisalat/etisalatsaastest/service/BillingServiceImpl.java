package com.etisalat.etisalatsaastest.service;

import com.etisalat.etisalatsaastest.EtisalatSaasTestRestTemplate;
import com.etisalat.etisalatsaastest.model.Account;
import com.etisalat.etisalatsaastest.response.BillingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    EtisalatSaasTestRestTemplate etisalatSaasTestRestTemplate;

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public BillingResponse info(Account account) {
        HttpEntity<Account> accountHttpEntity = new HttpEntity<>(account);
        BillingResponse billingResponse =  etisalatSaasTestRestTemplate.exchange("/BillingInformation", HttpMethod.GET, accountHttpEntity, BillingResponse.class).getBody();
        logger.info("Got billing info response from etisalat saas service: {} ", billingResponse);
        return billingResponse;
    }
}
