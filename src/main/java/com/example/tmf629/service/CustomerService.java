package com.example.tmf629.service;

import com.example.tmf629.dto.CustomerDTO;
import com.example.tmf629.dto.PatchCustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(String id);
    CustomerDTO patchCustomerById(String id, PatchCustomerDTO customerDTO);
    void deleteCustomerById(String id);
}
