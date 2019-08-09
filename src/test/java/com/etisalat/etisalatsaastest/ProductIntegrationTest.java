package com.etisalat.etisalatsaastest;

import com.etisalat.etisalatsaastest.model.Product;
import com.etisalat.etisalatsaastest.response.ProductResponse;
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
public class ProductIntegrationTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void itShouldCreateProductForValidRequest() {
        ResponseEntity<ProductResponse> response = createProduct();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertNotNull("Data should not be null", response.getBody().getData());

    }

    @Test
    public void itShouldCreateAndSuspendProductForValidRequest() {
        ResponseEntity<ProductResponse> createResponse = createProduct();
        ResponseEntity<ProductResponse> suspendResponse = suspendProduct(createResponse);
        Assert.assertEquals(HttpStatus.OK, suspendResponse.getStatusCode());
        Assert.assertNotNull("Data should not be null", suspendResponse.getBody().getData());

    }

    @Test
    public void itShouldCreateSuspendAndReactivateProductForValidRequest() {
        ResponseEntity<ProductResponse> createResponse = createProduct();
        ResponseEntity<ProductResponse> suspendResponse = suspendProduct(createResponse);
        ResponseEntity<ProductResponse> reactivateResponse = reactivateProduct(suspendResponse);
        Assert.assertEquals(HttpStatus.OK, reactivateResponse.getStatusCode());
        Assert.assertNotNull("Data should not be null", reactivateResponse.getBody().getData());

    }

    private ResponseEntity<ProductResponse> createProduct() {
        String url = TestUtil.createURLWithPort("/product/create", port);
        return restTemplate.postForEntity(url, getProductRequest(), ProductResponse.class);
    }

    private ResponseEntity<ProductResponse> reactivateProduct(ResponseEntity<ProductResponse> suspendResponse) {
        String url = TestUtil.createURLWithPort("/product/reactivate", port);
        String accountNumber = suspendResponse.getBody().getData().getEtisalatAccountNumber();
        String productId = suspendResponse.getBody().getData().getProductID();
        return restTemplate.postForEntity(url, getProductReactivateRequest(accountNumber, productId), ProductResponse.class);
    }

    private Product getProductReactivateRequest(String accountNumber, String productId) {
        Product product = new Product();
        product.setEtisalatAccountNumber(accountNumber);
        product.setProductID(productId);
        return product;
    }

    private ResponseEntity<ProductResponse> suspendProduct(ResponseEntity<ProductResponse> createResponse) {
        String suspendUrl = TestUtil.createURLWithPort("/product/suspend", port);
        String accountNumber = createResponse.getBody().getData().getEtisalatAccountNumber();
        String productId = createResponse.getBody().getData().getProductID();
        Product suspendRequest = getProductSuspendRequest(accountNumber, productId);
        return restTemplate.postForEntity(suspendUrl, suspendRequest, ProductResponse.class);
    }

    private Product getProductSuspendRequest(String accountNumber, String productId) {
        Product product = new Product();
        product.setEtisalatAccountNumber(accountNumber);
        product.setProductID(productId);
        return product;
    }

    private Product getProductRequest() {
        Product product = new Product();
        product.setEtisalatAccountNumber("2105642438");
        product.setPlanID("127");
        return product;
    }
}
