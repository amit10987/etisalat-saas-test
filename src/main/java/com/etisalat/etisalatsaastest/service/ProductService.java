package com.etisalat.etisalatsaastest.service;

import com.etisalat.etisalatsaastest.model.Product;
import com.etisalat.etisalatsaastest.response.ProductResponse;

public interface ProductService {

    ProductResponse create(Product product);

    ProductResponse suspend(Product product);

    ProductResponse reactivate(Product product);
}
