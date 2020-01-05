package com.labi.multipledb.customer.repo;

import com.labi.multipledb.customer.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <CustomerModel, Integer > {
}