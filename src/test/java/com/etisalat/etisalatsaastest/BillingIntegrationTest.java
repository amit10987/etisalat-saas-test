package com.etisalat.etisalatsaastest;

import com.etisalat.etisalatsaastest.model.Account;
import com.etisalat.etisalatsaastest.response.BillingResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EtisalatSaasTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BillingIntegrationTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void getBillingInfoTest() {
        ResponseEntity<BillingResponse> response = getBillingResponse();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertNotNull("data should not be null", response.getBody().getData());
    }

    private ResponseEntity<BillingResponse> getBillingResponse() {
        String url = TestUtil.createURLWithPort("/billing/info/{accountNumber}", port);
        Map<String, String> params = new HashMap<>();
        params.put("accountNumber", "235435");
        return restTemplate.getForEntity(url, BillingResponse.class, params);
    }
}
