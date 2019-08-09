package com.etisalat.etisalatsaastest.service;

import com.etisalat.etisalatsaastest.model.Account;
import com.etisalat.etisalatsaastest.response.AccountResponse;


/**
 * Account service to handle action like create and suspension of account
 */
public interface AccountService {

    /**
     * Create Account
     *
     * @param account
     * @return AccountResponse
     */
    AccountResponse create(Account account);

    /**
     * Suspend account
     * @param account
     * @return AccountResponse
     */
    AccountResponse suspend(Account account);
}
