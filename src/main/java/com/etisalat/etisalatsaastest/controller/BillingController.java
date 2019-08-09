package com.etisalat.etisalatsaastest.controller;

import com.etisalat.etisalatsaastest.model.Account;
import com.etisalat.etisalatsaastest.response.BillingResponse;
import com.etisalat.etisalatsaastest.service.BillingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("billing")
public class BillingController {

    @Autowired
    BillingService billingService;

    Logger logger = LoggerFactory.getLogger(BillingController.class);

    @ResponseBody
    @GetMapping(value = "/info/{accountNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BillingResponse> info(@PathVariable("accountNumber") String accountNumber) {
        logger.info("Received request for billing info: {}", accountNumber);
        Account account = new Account();
        account.setEtisalatAccountNumber(accountNumber);
        return ResponseEntity.ok(billingService.info(account));
    }
}
