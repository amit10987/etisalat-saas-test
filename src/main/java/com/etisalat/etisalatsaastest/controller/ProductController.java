package com.etisalat.etisalatsaastest.controller;

import com.etisalat.etisalatsaastest.model.Product;
import com.etisalat.etisalatsaastest.response.ProductResponse;
import com.etisalat.etisalatsaastest.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProductResponse> create(@RequestBody Product product) {
        logger.info("Received request to create the product: {}", product);
        return ResponseEntity.ok(productService.create(product));
    }

    @PostMapping(value = "/suspend", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProductResponse> suspend(@RequestBody Product product) {
        logger.info("Received request to suspend the product: {}", product);
        return ResponseEntity.ok(productService.suspend(product));
    }

    @PostMapping(value = "/reactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProductResponse> reactivate(@RequestBody Product product) {
        logger.info("Received request to reactivate the product: {}", product);
        return ResponseEntity.ok(productService.reactivate(product));
    }
}
