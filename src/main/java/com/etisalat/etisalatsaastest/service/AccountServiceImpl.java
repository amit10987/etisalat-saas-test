package com.etisalat.etisalatsaastest.service;

import com.etisalat.etisalatsaastest.EtisalatSaasTestRestTemplate;
import com.etisalat.etisalatsaastest.model.Account;
import com.etisalat.etisalatsaastest.response.AccountResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    EtisalatSaasTestRestTemplate etisalatSaasTestRestTemplate;

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Override
    public AccountResponse create(Account account) {
        AccountResponse accountResponse = etisalatSaasTestRestTemplate.postForObject("/AccountCreation", account, AccountResponse.class);
        logger.info("Got create account response from etisalat saas service: {} ", accountResponse);
        return accountResponse;
    }

    @Override
    public AccountResponse suspend(Account account) {
        AccountResponse accountResponse = etisalatSaasTestRestTemplate.postForObject("/AccountSuspension", account, AccountResponse.class);
        logger.info("Got suspend account response from etisalat saas service: {} ", accountResponse);
        return accountResponse;
    }
}
