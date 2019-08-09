package com.etisalat.etisalatsaastest.controller;

import com.etisalat.etisalatsaastest.model.Account;
import com.etisalat.etisalatsaastest.response.AccountResponse;
import com.etisalat.etisalatsaastest.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Handle all the request related to Account
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    AccountService accountService;

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    /**
     * create Account
     *
     * @param account {@link Account}
     * @return ResponseEntity that wraps {@link AccountResponse}
     */
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<AccountResponse> create(@RequestBody Account account) {
        logger.info("Received request to create the account: {}", account);
        return ResponseEntity.ok(accountService.create(account));
    }

    @PostMapping(value = "/suspend", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<AccountResponse> suspend(@RequestBody Account account) {
        logger.info("Received request to suspend the account: {}", account);
        return ResponseEntity.ok(accountService.suspend(account));
    }
}
