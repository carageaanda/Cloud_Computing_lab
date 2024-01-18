package com.project.accounts.mapper;

import com.project.accounts.dto.AccountsDto;
import com.project.accounts.dto.CustomerDto;
import com.project.accounts.entity.Accounts;
import com.project.accounts.entity.Customer;

public class CustomerMapper {

    public static CustomerDto maptoCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}
