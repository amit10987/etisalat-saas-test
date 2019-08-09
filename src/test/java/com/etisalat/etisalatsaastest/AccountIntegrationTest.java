package com.etisalat.etisalatsaastest;

import com.etisalat.etisalatsaastest.model.Account;
import com.etisalat.etisalatsaastest.response.AccountResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EtisalatSaasTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AccountIntegrationTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void itShouldCreateAccountForValidPlanId() {
        ResponseEntity<AccountResponse> response = createAccount();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(getAccountWithValidPlanId().getPlanID(), response.getBody().getData().getPlanID());

    }

    private ResponseEntity<AccountResponse> createAccount() {
        String url = TestUtil.createURLWithPort("/account/create", port);
        return restTemplate.postForEntity(url, getAccountWithValidPlanId(), AccountResponse.class);
    }

    @Test
    public void itShouldNotCreateAccountForInvalidValidPlanId() {
        String url = TestUtil.createURLWithPort("/account/create", port);
        ResponseEntity<AccountResponse> response = restTemplate.postForEntity(url, getAccountWithInValidPlanId(), AccountResponse.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertNull("data should be null", response.getBody().getData());

    }

    @Test
    public void itShouldCreateAndSuspendAccount() {
        ResponseEntity<AccountResponse> createResponse = createAccount();
        String accountNumber = createResponse.getBody().getData().getEtisalatAccountNumber();
        ResponseEntity<AccountResponse> response = suspendAccount(accountNumber);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertNotNull(response.getBody().getData());
        Assert.assertEquals(accountNumber, response.getBody().getData().getEtisalatAccountNumber());
    }

    private ResponseEntity<AccountResponse> suspendAccount(String accountNumber) {
        String suspendUrl = TestUtil.createURLWithPort("/account/suspend", port);
        return restTemplate.postForEntity(suspendUrl, getAccountWithSuspendRequest(accountNumber), AccountResponse.class);
    }

    private Account getAccountWithSuspendRequest(String accountNumber) {
        Account account = new Account();
        account.setEtisalatAccountNumber(accountNumber);
        return account;
    }

    private Account getAccountWithValidPlanId() {
        Account account = new Account();
        account.setEmail("test@gmail.com");
        account.setContactNumber("555555");
        account.setEtisalatAccountNumber("235435");
        account.setPlanID("127");
        return account;
    }

    private Account getAccountWithInValidPlanId() {
        Account account = new Account();
        account.setEmail("test@gmail.com");
        account.setContactNumber("555555");
        account.setEtisalatAccountNumber("235435");
        account.setPlanID("1237");
        return account;
    }
}
