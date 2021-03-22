package com.upgrad.course.demo.controller;

import com.upgrad.course.demo.dto.CustomerDTO;
import com.upgrad.course.demo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController(value = "/customer")
public class CustomerController {

    private static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/live")
    public Object checkStatus() {
        LOGGER.info("Inside checkStatus");
        return new ResponseEntity<>(HttpStatus.OK).getBody();
    }

    @PostMapping("/v1/customer")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        CustomerDTO response = customerService.saveCustomerData(customerDTO);
        return null;
    }

    @GetMapping("/v1/customer/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable int customerId) {
        CustomerDTO customerDTO = customerService.getCustomerData(customerId);
        return null;
    }
}
