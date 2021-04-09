package com.upgrad.course.demo.controller;

import com.upgrad.course.demo.dto.CustomerDTO;
import com.upgrad.course.demo.exceptions.RecordNotFoundException;
import com.upgrad.course.demo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/customerApi")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @GetMapping("/live")
    public Object checkStatus() {
        return ResponseEntity.ok().body("Customer service is up and running fine.");
    }

    @PostMapping("/v1/customers")
    public ResponseEntity<CustomerDTO> saveCustomer(
            @Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO response = customerService.saveCustomerData(customerDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v1/customers/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(
            @PathVariable int customerId) throws RecordNotFoundException {
        CustomerDTO customerDTO = customerService.getCustomerData(customerId);
        return ResponseEntity.ok(customerDTO);
    }
}
