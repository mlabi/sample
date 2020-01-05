package com.labi.multipledb;

import com.labi.multipledb.customer.model.CustomerModel;
import com.labi.multipledb.customer.repo.CustomerRepository;
import com.labi.multipledb.product.model.ProductModel;
import com.labi.multipledb.product.repo.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleDataSourcesProductTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional("productTransactionManager")
    public void create_check_product() {
        ProductModel product = new ProductModel("228781","Running Shoes", 20.0);
        product = productRepository.save(product);
        System.out.println("Product ID: " + product.getId());

//        assertNotNull(productRepository.findById(product.getId()));
    }

}
