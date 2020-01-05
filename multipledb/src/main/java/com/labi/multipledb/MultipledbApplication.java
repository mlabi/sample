package com.labi.multipledb;

import com.labi.multipledb.customer.model.CustomerModel;
import com.labi.multipledb.customer.repo.CustomerRepository;
import com.labi.multipledb.product.model.ProductModel;
import com.labi.multipledb.product.repo.ProductRepository;
import com.labi.multipledb.service.NonWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootApplication
public class MultipledbApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private NonWebService service;
	public static void main(String[] args) {
		SpringApplication.run(MultipledbApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running!!!");
		create_check_customer();
		create_check_product();
		service.printMessage(args);
	}


	@Transactional("productTransactionManager")
	public void create_check_product() {
		ProductModel product = new ProductModel("228781", "Running Shoes", 20.0);
		product = productRepository.save(product);
		System.out.println("Product ID: " + product.getId());

//        assertNotNull(productRepository.findById(product.getId()));
	}

	@Transactional("customerTransactionManager")
	public void create_check_customer() {

//		CustomerModel customer = new CustomerModel("user@www.javadevjournal.com","Robert","Hickle");
//		customer = customerRepository.save(customer);
		Optional<CustomerModel> customer = customerRepository.findById(1);
		System.out.println("Customer email: " + customer.get().getEmail());
//		assertNotNull(customerRepository.findById(customer.getId()));
//		assertEquals(customerRepository.findById(customer.getId()).get().getEmail() ,"user@www.javadevjournal.com");
	}
}
