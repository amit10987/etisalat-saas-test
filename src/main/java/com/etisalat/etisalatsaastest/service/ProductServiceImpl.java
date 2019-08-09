package com.etisalat.etisalatsaastest.service;

import com.etisalat.etisalatsaastest.EtisalatSaasTestRestTemplate;
import com.etisalat.etisalatsaastest.model.Product;
import com.etisalat.etisalatsaastest.response.ProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    EtisalatSaasTestRestTemplate etisalatSaasTestRestTemplate;

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public ProductResponse create(Product product) {
        ProductResponse productResponse = etisalatSaasTestRestTemplate.postForObject("/ProductCreation", product, ProductResponse.class);
        logger.info("Got create product response from etisalat saas service: {} ", productResponse);
        return productResponse;
    }

    @Override
    public ProductResponse suspend(Product product) {
        ProductResponse productResponse = etisalatSaasTestRestTemplate.postForObject("/ProductSuspension", product, ProductResponse.class);
        logger.info("Got suspend product response from etisalat saas service: {} ", productResponse);
        return productResponse;
    }

    @Override
    public ProductResponse reactivate(Product product) {
        ProductResponse productResponse = etisalatSaasTestRestTemplate.postForObject("/ProductReactivation", product, ProductResponse.class);
        logger.info("Got reactivate product response from etisalat saas service: {} ", productResponse);
        return productResponse;
    }
}
